#ifndef _HW2_H
#define _HW2_H

/**
 * (A brief description of what the program does)
 *
 * Completion time: (the time it took you to complete the assignment)
 *
 * @author (Your Name), (anyone elses name who's code you used... ie Acuna)
 * @version (a version number or date)
 *
 */

////////////////////////////////////////////////////////////////////////////////
// INCLUDES
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>

////////////////////////////////////////////////////////////////////////////////
// MACROS: CONSTANTS
#define MAX_STUDENT_NAME_LENGTH 20
#define MAX_COURSE_NAME_LENGTH 10
#define MAX_TEACHER_NAME_LENGTH 20
#define MAX_COMMENT_LENGTH 20
#define MAX_ASSIGN_NAME_LENGTH 20
#define MAX_FILENAME_LENGTH 30

////////////////////////////////////////////////////////////////////////////////
// DATA STRUCTURES

typedef enum AcademicLevel
{
    Freshman = 1,
    Sophomore = 2,
    Junior = 3,
    Senior = 4
} AcademicLevel;

typedef struct ScoreStruct
{
    int studentNo;
    int assignNo;
    float score;
    char *comment;
} ScoreStruct;

typedef struct Assign
{
    int no;
    char *name;
} Assign;

typedef struct Student
{
    int no;
    char *name;
    AcademicLevel level;
} Student;

typedef struct Course
{
    int no;
    char *name;
    char *teacher;
    int numAssigns;
    Assign *assigns;
    ScoreStruct **scores;
} Course;

////////////////////////////////////////////////////////////////////////////////
// GLOBAL VARIABLES
// place to store student information
Student *students = NULL;
// place to store course information
Course *courses = NULL;
int numCourses, numStudents;

////////////////////////////////////////////////////////////////////////////////
// FORWARD DECLARATIONS

// the following should be used to read student/course data in from the file
void readFile(char *filename);
void readString(FILE *file, char **dst, int max_length);
Student *readStudents(FILE *file);
Course *readCourses(FILE *file);
Assign *readAssigns(FILE *file, int numAssigns);
ScoreStruct **readScores(FILE *file, int numAssigns);

// the following should be used to free all heap data allocated during the programs runtime
// and handle dangling pointers
void terminate();
void studentsDestructor();
void coursesDestructor();
void assignsDestructor(Assign **assigns, int numAssign);
void scoresDestructor(ScoreStruct ***scores, int numAssigns);

// the following should be used to cleanly print the data used in the program
void printStudents();
void printAssigns(Assign *assigns, int numAssigns);
void printGrades(ScoreStruct **scores, int numAssigns);
void printCourse(Course course);

// the following are mostly complete functions that define and
// control the CLI menu associated with the program
void mainMenu();
void mainMenuBranch(int option);
void subMenu(Course course);
void subMenuBranch(int option, Course course);

// these are the 'special' functions that you are being asked to implement
void studentMenu(Course course);
void getStudentScores(Course course, int studentNo);
void assignmentMenu(Course course);
void getAssignmentScore(Course course, int assignmentNo);

// this is an optional function that parses and executes instructions defined in an input file
void performInstructions(char *iFile);

// this is a utility function to be called when input filenames are invalid
void printUsage();

/////////////////////////////////////////////////////////////////////////////////
// IMPLEMENTATION

/**
 * Loads data from student/course data file
 * @param filename is the name of the file
 */
void readFile(char *filename)
{
    FILE *file = fopen(filename, "r");
    // FOR YOU TO IMPLEMENT
    fscanf(file, "%d", &numStudents);
    students = readStudents(file);
    fscanf(file, "%d\n", &numCourses);
    courses = readCourses(file);
    fclose(file);
}

void studentMenu(Course course)
{
    printf("\nPlease choose from the following students: \n");
    printStudents();
    printf("  0 RETURN TO PREVIOUS MENU\n");
    int studentNo;
    printf("Please enter your choice ---> ");
    scanf(" %d", &studentNo);
    while (studentNo < 0 || studentNo > numStudents)
    {
        printf("Please enter a valid option ---> ");
        scanf(" %d", &studentNo);
    }
    if (studentNo == 0)
    {
        printf("Returning to previous menu...\n");
        return;
    }
    else
    {
        getStudentScores(course, studentNo);
    }

} /** * Prints student grades in course * @param course is the course struct to be read from * @param studentNo is the id of the student to be read */
void getStudentScores(Course course, int studentNo)
{
    double total = 0, average = 0;
    int i;
    printf("\n%s's assignment specific grades were: \n\n", students[studentNo - 1].name);
    printf("  %-16s%-16s%-16s\n", "Assign Name", "Score", "Comment");
    printf("-----------------------------------------------\n");
    for (i = 0; i < course.numAssigns; i++)
    {
        total += course.scores[studentNo - 1][i].score;
        printf("  %-16s%-16.2f%-16s\n", course.assigns[i].name, course.scores[studentNo - 1][i].score, course.scores[studentNo - 1][i].comment);
    }
    average = total / course.numAssigns;
    printf("\n%s's final grade was %.2f.\n", students[studentNo - 1].name, average);
}

void assignmentMenu(Course course)
{
    printf("\nPlease choose from the following assignments: \n");
    printAssigns(course.assigns, course.numAssigns);
    printf("  0 RETURN TO PREVIOUS MENU\n");
    int assignNo;
    printf("Please enter your choice ---> ");
    scanf(" %d", &assignNo);
    while (assignNo < 0 || assignNo > course.numAssigns)
    {
        scanf(" %d", &assignNo);
    }
    if (assignNo == 0)
    {
        printf("Returning to previous menu...\n");
        return;
    }
    else
    {
        getAssignmentScore(course, assignNo);
    }
}

void getAssignmentScore(Course course, int assignNo)
{
    double total = 0, average = 0;
    int i;
    for (i = 0; i < numStudents; i++)
    {
        total += course.scores[i][assignNo - 1].score;
    }
    average = total / numStudents;
    printf("\nThe average grade on %s was %.2f.\n", course.assigns[assignNo - 1].name, average);
}

// Student *readStudents(FILE *file)
// {
//     Student *students = (Student *)malloc(sizeof(Student) * numStudents);
//     int i;

//     for (i = 0; i < numStudents; i++)
//     {
//         fscanf(file, "%d\n", &students[i].no);
//         readString(file, &students[i].name, MAX_STUDENT_NAME_LENGTH);
//         int level;
//         fscanf(file, "%d\n", &level);
//         students[i].level = level;
//     }
//     return students;
// }

// Course *readCourses(FILE *file)
// {
//     Course *courses = (Course *)malloc(sizeof(Course) * numCourses);
//     int i;

//     for (i = 0; i < numCourses; i++)
//     {
//         fscanf(file, "%d\n", &courses[i].no);
//         readString(file, &courses[i].name, MAX_COURSE_NAME_LENGTH);
//         readString(file, &courses[i].teacher, MAX_TEACHER_NAME_LENGTH);
//         fscanf(file, "%d\n", &courses[i].numAssigns);
//         courses[i].assigns = readAssigns(file, courses[i].numAssigns);
//         courses[i].scores = readScores(file, courses[i].numAssigns);
//     }
//     return courses;
// }
// Assign *readAssigns(FILE *file, int numAssigns)
// {
//     Assign *assigns = (Assign *)malloc(sizeof(Assign) * numAssigns);
//     int i;
//     for (i = 0; i < numAssigns; i++)
//     {
//         fscanf(file, "%d\n", &assigns[i].no);
//         readString(file, &assigns[i].name, MAX_ASSIGN_NAME_LENGTH);
//     }
//     return assigns;
// }

// ScoreStruct **readScores(FILE *file, int numAssigns)
// { // Allocate 2D array
//     ScoreStruct **scores = (ScoreStruct **)malloc(sizeof(ScoreStruct *) * numStudents);
//     int i;
//     for (i = 0; i < numStudents; i++)
//     {
//         scores[i] = (ScoreStruct *)malloc(sizeof(ScoreStruct) * numAssigns);
//     }
//     int j;
//     // Loop to read through numAssigns * numStudents grade data
//     for (j = 0; j < numAssigns * numStudents; j++)
//     {
//         int studentNo, assignNo;                         // read student and assign no to temporary variables
//         fscanf(file, "%d\n%d\n", &assignNo, &studentNo); // store student and assign no in appropriate grade structs
//         // note: student/assign numbers start at 1, hence the offset
//         scores[studentNo - 1][assignNo - 1].studentNo = studentNo;
//         scores[studentNo - 1][assignNo - 1].assignNo = assignNo; // read grade score and comment into appropriate grade structs
//         fscanf(file, "%f\n", &scores[studentNo - 1][assignNo - 1].score);
//         readString(file, &scores[studentNo - 1][assignNo - 1].comment, MAX_COMMENT_LENGTH);
//     }
//     return scores;
// }

/**
 * Implements main menu functionality, which allows user to select a course to interact with
 */
void mainMenu()
{
    int input_buffer;
    printf("Course Searcher");
    do
    {
        printf("\n-----------------------------------\n");
        printf("Course Options");
        printf("\n-----------------------------------\n");
        int i;
        for (i = 0; i < numCourses; i++)
        {
            // FOR YOU TO IMPLEMENT
            printf("   %d %s\n", courses[i].no, courses[i].name);
        }
        printf("   0 REPEAT OPTIONS\n");
        printf("  -1 TERMINATE PROGRAM\n");
        printf("Please enter your choice ---> ");
        scanf(" %d", &input_buffer);
        mainMenuBranch(input_buffer);
    } while (1);
}

/**
 * Handles menu options of main menu
 * @param option is the chosen operation's option #
 */
void mainMenuBranch(int option)
{
    if (option < -1 || option > numCourses)
    {
        printf("Invalid input. Please try again...\n");
        ;
        while (option < -1 || option > numCourses)
        {
            printf("Please enter a valid option ---> ");
            scanf(" %d", &option);
        }
    }
    if (option == -1)
    {
        printf("Terminating program...\n");
        terminate();
    }
    else if (option == 0)
    {
        printf("Repeating options...\n");
    }
    else
    {
        Course course = courses[option - 1];
        // FOR YOU TO IMPLEMENT
        printf("Course with name %s selected.\n", course.name);
        subMenu(course);
    }
}

/**
 * Implements sub menu functionality, which allows users to select how they want to interact with course
 * @course is the course to be queried
 */

void subMenu(Course course)
{
    int input_buffer;
    do
    {
        printf("\n-----------------------------------\n");
        printf("Menu Options");
        printf("\n-----------------------------------\n");
        printf("   1 Get a student's final grades in the course\n");
        printf("   2 Get the average grade of an assignment in the course\n");
        printf("   3 Print all course data\n");
        printf("   0 REPEAT OPTIONS\n");
        printf("  -1 RETURN TO PREVIOUS MENU\n");
        printf("  -2 TERMINATE PROGRAM\n");
        printf("Please enter your choice ---> ");
        scanf(" %d", &input_buffer);
        subMenuBranch(input_buffer, course);
    } while (input_buffer != -1);
}

/**
 * Handles menu options of submenu
 * @param option is the chosen operation's option #
 * @param course is the course struct to be queried
 */
void subMenuBranch(int option, Course course)
{
    if (option < -2 || option > 3)
    {
        printf("Invalid input. Please try again...\n");
        ;
        while (option < -2 || option > 3)
        {
            printf("Please enter a valid option ---> ");
            scanf(" %d", &option);
        }
    }
    if (option == -2)
    {
        printf("Terminating program...\n");
        terminate();
    }
    else if (option == -1)
    {
        printf("Returning to previous menu...\n");
    }
    else if (option == 0)
    {
        printf("Repeating options...\n");
    }
    else if (option == 1)
    {
        // FOR YOU TO IMPLEMENT
        studentMenu(course);
    }
    else if (option == 2)
    {
        // FOR YOU TO IMPLEMENT
        assignmentMenu(course); 
    }
    else if (option == 3)
    {
        // FOR YOU TO IMPLEMENT
        printCourse(course); 
    }
}

/**
 * Prints basic usage instructions for the program to the command line
 */
void print_usage()
{
    printf("USAGE:\n./LastNameCourseReader -d <data_file_name(char*)> -c <instruction_file_name(char*)>\n");
    printf("-d refers to the required input data file containing student & course information; this must be a valid .txt file\n");
    printf("-i refers to the optionally supported 'instruction file' that provides directions for how the program should execute without CLI input; \n\t must be a valid .txt.file\n");
}

void terminate()
{
    // FREE EVERYTHING HERE
    studentsDestructor();   
    coursesDestructor();   
    exit(1);
}

int main(int argc, char *argv[])
{
    char *datafile = NULL;
    char *instructionfile = NULL;
    int opt;
    while ((opt = getopt(argc, argv, ":d:i:")) != -1)
    {
        switch (opt)
        {
        case 'd':
            datafile = optarg;
            break;
        case 'i':
            instructionfile = optarg;
            break;
        case ':':
            printf("option needs a value\n");
            break;
        case '?':
            printf("unknown option: %c\n", optopt);
            break;
        }
    }
    for (; optind < argc; optind++)
    {
        printf("Given extra arguments: %s\n", argv[optind]);
    }

    int dflen;
    if (datafile != NULL)
    {
        dflen = strlen(datafile);
        if (dflen >= 5 && (strcmp(&datafile[dflen - 4], ".txt") == 0) && (access(datafile, F_OK) != -1))
        {
            printf("Importing data from %s\n\n", datafile);
            readFile(datafile);
        }
        else
        {
            printf("Data file has an invalid name or does not exist.\n");
            print_usage();
            exit(1);
        }
    }
    else
    {
        printf("No data file name provided. This is a required field.\n");
        print_usage();
        exit(1);
    }

    int iflen;
    int ifval;
    if (instructionfile != NULL)
    {
        iflen = strlen(instructionfile);
        if (iflen >= 5 && (strcmp(&instructionfile[iflen - 4], ".txt") == 0) && (access(instructionfile, F_OK) != -1))
        {
            printf("Performing instructions defined in %s:\n", instructionfile);
            // uncomment below if doing this optional part of the assignment
            // performInstructions(instructionfile);
        }
        else
        {
            printf("Instruction file has an invalid name or does not exist.\n");
            print_usage();
            exit(1);
        }
    }
    else
    {
        printf("No instruction file provided. Using CLI:\n");
        mainMenu();
    }
    return 0;
}

#endif
