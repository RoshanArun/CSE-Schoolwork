#include <iostream>
#include<string.h>
using namespace std;

class student{
    //declare private varibles 
    private: 
    string name;
    int numClasses;
    string *classList;

    public: 
    //constructor, sets intial private variable values. 
    student(){ 
        name = "";
        numClasses = 0;
        classList = NULL; 
    }

    //sets name
    string setName(string na){
        name = na;
        return name;
    }

    //return name
    string getName(){
        return name;
    }

    //sets num of classes
    int setNumClasses(int classes){
        numClasses = classes;
        return numClasses;
    } 

    //gets num of classes
    int getNumClasses(){
        return numClasses;
    }

    //gets list of classes
    string getclassList(int i){
        return classList[i];
    }

    //allows user to input their name, num of classes, and which classes they are taking
    void input(){
        cout << "Enter student name: ";
        cin >> name;
        cout << "Enter number of classes: ";
        cin >> numClasses;
        classList = new string[numClasses];
        for(int i = 0; i < numClasses; i++){
            cout << "Enter name of one class: ";
            cin >> classList[i];
        }
    }

    //displays the input
    void output(){
        cout << endl;
        cout << "Name: " << name << endl; 
        cout << "Num of Classes: " << numClasses << endl; 
        for(int i = 0; i < numClasses; i++){
            cout << "Class " << classList[i] << endl;
        }
    }

    //resets varibles so code can run again 
    void reset(){
        delete[] classList;
        numClasses = 0;
    }
};

//tests all functions
int main(){
    student one;

    one.input();
    one.output();

    string userInput;
    string yHold = "y";
    cout << endl;
    cout << "Do you want to enter the data again? y/n: ";
    cin >> userInput;

    if(userInput.compare(yHold) == 0){
        one.reset();
        main();
    }
}