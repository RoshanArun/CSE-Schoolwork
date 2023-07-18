package edu.ser216.checkers.core;

import java.util.Scanner;

public class CheckersComputerPlayer implements CheckersGame {
    private int turn = 0;
    private char[][] board;
    private Scanner scan;

    // implements and creates basic checkers board using a 2d array and x/o tokens
    public CheckersComputerPlayer(Scanner scan) {
        this.scan = scan;
        board = new char[8][8];

        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (row < 3 && (column + (row % 2)) % 2 != 1) {
                    board[row][column] = 'x';
                } else if (row > 4 && (column + (row % 2)) % 2 != 1) {
                    board[row][column] = 'o';
                } else {
                    board[row][column] = '_';
                }
            }
        }

    }

    /**
     * @param row
     * @param column
     * @return char
     */

    @Override
    public void doTurn() {
        // Prompts user for input
        if (turn % 2 == 0) {
            String input = scan.nextLine();

            if (input.length() != 5) {
                System.out.println("This move is invalid");
                doTurn();
            }

            char number = input.charAt(0);
            char letter = input.charAt(1);
            char number2 = input.charAt(3);
            char letter2 = input.charAt(4);

            int startRow = charToInt2(number);
            int startCol = charToInt(letter);
            int endRow = charToInt2(number2);
            int endCol = charToInt(letter2);

            char startContent = getSquare(startRow, startCol);

            if (isValidMove(startRow, startCol, endRow, endCol)) {

                setSquare(startRow, startCol, '_');
                setSquare(endRow, endCol, startContent);
                turn++;
            } else {
                System.out.println("This move is invalid");
                doTurn();
            }
        }
        int one = 0;
        if (turn % 2 == 1) {
            OUTER_LOOP: for (int row = 0; row < 8; row++) {
                for (int column = 0; column < 8; column++) {
                    char currentSquare = getSquare(row, column);
                    // if square isn't empty
                    if (currentSquare != '_') {
                        if (isValidMove(row, column, row - 1, column - 1)) {
                            setSquare(row, column, '_');
                            setSquare(row - 1, column - 1, 'o');
                            System.out.println("works");
                            one++;
                            break OUTER_LOOP;
                        }
                        if (isValidMove(row, column, row - 1, column + 1)) {
                            setSquare(row, column, '_');
                            setSquare(row - 1, column + 1, 'o');
                            System.out.println("works");
                            one++;
                            break OUTER_LOOP;
                        }

                    }
                }
            }
            turn++;
        }
    }

    @Override
    // checks to see if there is a winning player
    public char getWinningPlayer() {
        int xPieces = 0;
        int oPieces = 0;
        int xMoves = 0;
        int oMoves = 0;
        // check all squares
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                char currentSquare = getSquare(row, column);
                // if square isn't empty
                if (currentSquare != '_') {
                    // check if it can make any moves
                    if (isValidMove(row, column, row + 1, column + 1) ||
                            isValidMove(row, column, row + 1, column - 1)) {
                        // if so set moves to true
                        if (currentSquare == 'x') {
                            xMoves++;
                        }
                    }

                    if (isValidMove(row, column, row + 1, column + 1) ||
                            isValidMove(row, column, row + 1, column - 1)) {
                        oMoves++;

                    }

                    // count pieces
                    if (currentSquare == 'x') {
                        xPieces++;
                    } else {
                        oPieces++;
                    }
                }

            }
        }

        // if either player has no pieces or no moves they lose
        if (xPieces == 0 || xMoves == xPieces) {
            return 'o';
        } else if (oPieces == 0 || oMoves == oPieces) {
            return 'x';
        } else {
            return '_';
        }
    }

    // checks to see if a valid move can be made
    private boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {

        if (endRow < 0 || endRow > 7 || endCol < 0 || endCol > 7) {
            return false;
        }

        if (startRow < 0 || startRow > 7 || startCol < 0 || startCol > 7) {
            return false;
        }

        // checks if the piece exists
        if (getSquare(startRow, startCol) == '_') {
            return false;
        }

        // checks if there is no movement
        if (startRow == endRow && startCol == endCol) {
            return false;
        }

        // checks if the movement is diagonal
        if (Math.abs(startRow - endRow) != Math.abs(startCol - endCol)) {
            return false;
        }

        // check if destination is occupied
        if (getSquare(endRow, endCol) != '_') {
            return false;
        }

        // checks if the movement is greater than two
        if (Math.abs(endRow - startRow) > 2) {
            return false;
        }

        // checks if the destination is an opponent piece
        if (board[endRow][endCol] == 'x' && board[startRow][startCol] == 'o') {
            return false;
        }
        if (board[endRow][endCol] == 'o' && board[startRow][startCol] == 'x') {
            return false;
        }

        // checks if the movement is the opposite direction of the team
        // check if the direction of the movement is opposite
        // checks if the movement is going in the opposite direction from the current
        // player
        if (startRow - endRow > 0 && turn % 2 == 0 ||
                startRow - endRow < 0 && turn % 2 == 1) {
            return false;
        }

        // check if movement is further than one
        if (Math.abs(startRow - endRow) == 2) {
            int middleRow = (startRow + endRow) / 2;
            int middleCol = (startCol + endCol) / 2;
            char middleContent = getSquare(middleRow, middleCol);
            char startContent = getSquare(startRow, startCol);
            // check if friendly piece is in the middle
            if (middleContent == startContent || middleContent == '_') {
                return false;
            } else {
                setSquare(middleRow, middleCol, '_');
            }
        }

        // Check if the piece belongs to the current player
        if (turn % 2 == 0 && getSquare(startRow, startCol) == 'o' ||
                turn % 2 == 1 && getSquare(startRow, startCol) == 'x') {
            return false;
        }

        // returns true if all criteria is met
        return true;
    }

    @Override
    // returns the value of a certain box of the checkers board
    public char getSquare(int row, int column) {
        return board[row][column];
    }

    @Override
    // sets the value of a certain box of the checkers board
    public void setSquare(int row, int column, char content) {
        board[row][column] = content;
    }

    @Override
    // checks and keeps track of who's turn is next
    public void nextTurn() {
        if (turn == 0 || turn % 2 == 0) {
            System.out.println(
                    "\nPlayer X - your turn. \nChoose a cell position of piece, 3a-4b 3g-4h");
        } else {
            System.out.println(
                    "\nPlayer O - your turn. \nChoose a cell position of piece, 3a-4b 3g-4h");
        }
    }

    @Override
    // prints the winner
    public void onEnd() {
        char winner = getWinningPlayer();
        if (winner == 'x') {
            System.out.println("Player X wins!");
        } else if (winner == 'o') {
            System.out.println("Player O wins!");
        }
    }

    // align the letters to columns
    public int charToInt(char c) {

        int column;
        if (c == 'a') {
            column = 0;
        } else if (c == 'b') {
            column = 1;
        } else if (c == 'c') {
            column = 2;
        } else if (c == 'd') {
            column = 3;
        } else if (c == 'e') {
            column = 4;
        } else if (c == 'f') {
            column = 5;
        } else if (c == 'g') {
            column = 6;
        } else {
            column = 7;
        }
        return column;
    }

    // align the numbers to properly represent the array
    public int charToInt2(int row2) {

        int row;
        if (row2 == '1') {
            row = 0;
        } else if (row2 == '2') {
            row = 1;
        } else if (row2 == '3') {
            row = 2;
        } else if (row2 == '4') {
            row = 3;
        } else if (row2 == '5') {
            row = 4;
        } else if (row2 == '6') {
            row = 5;
        } else if (row2 == '7') {
            row = 6;
        } else {
            row = 7;
        }
        return row;
    }

}



//engineering - Application of scientific knowledge in creating/building cost effect solutions to practical problems. 
//Software engineering - collection of techniques methodolodiges that help with production of high quality software. 
//2 kind of hierarchy - partof/iskindof, System Model based on struccture of the system - object model

//model based on how system reacts to external events/event flow - dynamic model. what functions are doing/dataflow - funcitonal
//model based on open/closed issues, constraignts by client and resolutions - issues model. Greenfield - classes for new software
//Functional decomp - system is decomped into smaller modules/functions, object decomp - into smaller classes (large abstractions)
//Reengineering - clases in exising system, interface engineering - can create a class-based interface to any system, 
//issues that affect software - scale/heterogeneity/security, module used to represent roles in project/organization - org chart
//sequence diagrams - dynamic behavior between objects of system, state chart - dynamic behavior of indiivual object
//activity - dynamic behavior of a system (workflow), useCase - funcitonal behavior of system seen by user, Ovals - functions
//retangles - classes/instances, instances are underlined, user case - Unique name, participating actors, entry/exit conditions, 
//flow of events, special requirements, extends - represents seldom invoked use cases of exceptional functionality (login error)
//class diagrams show static structure of the system: objects, attributes, and associations, actor: user, external system, physical environment
//includes - represents seldom invoked use cases of exceptional functionality, @param - Describes argument of method/constructor
//Generalization is used to simplify systems with simliar objects through "super-class" which generalizes the objects sharing attributes/methods.
//if a use case X inlcude use case Y , then X cannot accomplish goal without using the use case Y, passenger (stick figure), useCase - oval

//javadoc - Author, version, param, return, exception, throws, /** *@author @ *version */ types of doctors - inhertitance, MDA - CIM/PSM/PIM
//aggregation - objects composed of different parts (other objects), compositoin - strong form aggregation;lifetime controlled by aggregate
//driven modeling - systeem can be represented a model with finite number of discrete states and internal/internal events transitions
//System model perspectives - external/interaction/behavioral/structual, edges in state diagram - event/stimuli
//activies grouped in swimlines denote the object imlements the activites, Javadoc starts with /** */and is in HTML
//PSP defect logging - phases injected/removed/defect type/description/fix time, PSP1. Peer review - full review/inspections/walkthroughs
//PSP0 - Simple prodess scripts, 3 basic work measures (time spent, size of product,^ defects corrected), simple post project analysis
//PSP includes defined steps, forms, standards, means personal softawre process. PSP0 - current process, time and defect recording, and defect type standard
//PSP1 - size estimate, resource and schedule plans, and test report, PSP2 - code reviews and design reviews, defect and yield management
//PSP forms - project plan summary, time recording, defect recording, defect type standard.

//Waterfall model - when requirements are well known, product definition is stable, tech is understood, new version of existing product
//V shaped - High reliability, requirements known, solution/tech are known, Agile: RUP/ASD/FDD/DSDM/RAD/XP
//Incremental - Need for early realization of benefits, most requirements are known up front but are expected to evolve.
//Spiral - When creation of prototype is appropriate, when costs and risk eval is important, medium/high risk projects, requirements are complex.
//Flight simulation - V shaped/waterfall, library management system - Wtaerfall, Visual modeling tool - incremental
//Throw clause - specifies exceptions a method throws, unchecked Exception - indexoutofbounds, exception classes inhert dir/indir - throwable
//Finally -  Code in finally is executed underall all circumstatces, regardless of exception thrown, should be placed after try and before catch
//Uncaught exception - exception that occurs when there are no matching clauses, to catch exception - try block, checked exceptino - IOException
//if catch/declare requrement for a checked exception is not satisfied, compiler will issue error indicating exception muist be caught/declared
//instrucitno son handling exceptino are not include in a exceptions stack trace, false - exception handling can catch but not resolve exceptions
//logical lines of code - invariant to editing changes, uniquely definable, correlate with development effort
//Software Lifecycle activities - requirements elicitation, analysis, system design, object design, imlementation, testingg, deployment/maintenance
//^Defintion: Set of activities and their relationships to each other to support the development of a software system







//failure - Any deviation of the observed behavior from the specified behavior, error - The system is in a state such that further processing by the system can lead to a failure
//fault/bug/defect) - The mechanical or algorithmic cause of an error, validation - Activity of checking for deviations between the observed behavior of a system and its specification
//faults in interface specification - Mismatch between what the client needs and what the server offers Mismatch between requirements and implementation
//algorithmic faults - Missing initialization, Incorrect branching condition, Missing test for null, Mechanical fault - operating temp outside of equipment specifcations 
//errors - null reference, concurrency, exceptions. How do we deal with errors, failures and faults - Modular redundancy, patching and testing
//fault avoidance - Use methodology to reduce complexity, Use configuration management to prevent inconsistency, Apply verification to prevent algorithmic faults, Use Reviews
//Fault detection - Testing: Activity to provoke failures in a planned way, Debugging: Find and remove faults, Monitoring: Deliver information about state used during debugging
//fault tolerance (recover from failure once the system is released) − Exception handling/Modular redundancy, Testing lifecycle - unit/itegration/system/acceptance
//unit testing - Individual component (class or subsystem), Carried out by developers, Goal: Confirm that the component or subsystem is correctly coded and carries out the intended functionality
//Integratino testing - Groups of subsystems (collection of subsystems) and eventually the entire system, Carried out by developers, Goal: Test the interfaces among the subsystems.
//System testing - The entire system, Carried out by developers, Goal: Determine if the system meets the requirements (functional and nonfunctional
//Acceptance testing - The entire system, Carried out by developers, Goal: Determine if the system meets the requirements (functional and nonfunctional

//javafx - A new framework for developing Java GUI programs, BASIC STRUCTURE - Application, Override the start(Stage) method, Stage, Scene, and Nodes
//binding - enables target object to be bound to source object, If  value in  source object changes,  target property is also changed automatically.  change if the value is changed. 
//The target object is simply called a binding object or a binding property. Unidirectional - When the target changes when the source changes.  Bidirectional - both the target ^and source 

//Procedural - executed in procedural order, Event Driven - code is executed upon activation of events.
//Event - A type of signal to the program that something has happened. The event is generated by external user actions such as mouse movements, mouse clicks, or keystrokes.
//Listener - contains a method for processing the event. Button (event source object), event (even object), event handler process event (event handler object)
//Anonymous inner class - An anonymous inner class must always extend a superclass or implement an interface, but it cannot have an explicit extends or implements clause
//An anonymous inner class must implement all the abstract methods in the superclass or in the interface, An anonymous inner class always uses the no-arg constructor from its superclass 
//to create an instance, An anonymous inner class is compiled into a class named OuterClassName$n.class. For example, if the outer class Test has two anonymous inner classes, these two 
//classes are compiled into Test$1.class and Test$2.class. DEFINITION - An inner class without a name It combines declaring an inner class and creating an instance of the class in one step
//Inner class listeners can be shortened using anonymous inner classes, anonymous inner class is an inner class without a name, declares an inner class and creates an instance of the class in one step
//Inner class: class is a member of another class, ADVANTAGES - In some applications, you can use an inner class to make programs simple, supports work out its containing outer class
//Inner Class - can reference the data and methods defined in the outer class in which it nests, so you do not need to pass the reference of the outer class to the constructor of the inner class
//Is compiled into a class named OuterClassName$InnerClassName.class, can be declared public, protected, or private subject to the same visibility rules applied to a member of the class
//Can be declared static, can be accessed using the outer class name, cannot access nonstatic members of the outer class 
//lambda expression - New feature in Java 8. Can be viewed as an anonymous method with a concise syntax. type1 param1, type2 param2, ...) -> expression'

//Software Quality defect removel methods - unit/integration/system testing, design/code reviews/inspections. Product Standards - design review form , java program style, method header format. 
//Reivew/Inspection purpose - improve software quality. Principles - PSP reviews follow a defined process with guidelines, checklists, and standards. The PSP review goal is to find every defect
//before the first compile or test. To address this goal, you should review before compiling or testing, use coding standards, use design completeness criteria measure and improve your review 
//process, use a customized personal checklist. Design review - produce dsigns that can be reviews/follow explicit review trat/review design in stages/verify logic corrrectly implements reqs
//Reviewable design - defined context, precise repreentation, consistende/clear structure. Purpose/fuction explicity stated, criteria for design completeness, strcutured in logical elements
//Defect review strategy - review against reqs, verify overal program strucutre/flow, check lgoical constrcuts, check for robustness/safety/security, check function/method, check special vars
//Limited logging meeting - gathers limited group together, user participation - pluralistic/cognitive walk throughs, review type - virutal/limited/pair review/no-logging review

//Static testing (at compile time)- Static Analysis, Review, Walk-through (informal), Code inspection (formal), Automated tools/check for syntax and semantic errors/departure from coding standards 
//Dynamic testing (at run time) - Black/White box testing. Black(func) - Looks at a program's inputs and outputs, nothing else. White(dyn) - Looks under covers and into subsystem of an application.
//Lets you see what is happening inside teh app, provides more than access to user interface, allows tester to refer to and interact with objects that compirse an appliation.  
//Code coverage - statement/branch/path. JUNIT - testcase/asset/testsuite. Unit testing tester - devs. Test fixture - fixed satet of a set of object sused as a baseline for running tests
//Junit - open source, providse annoation to identify test methods, tests can be run autmaically, tests can be organized into test suites. yield - used to temp release time for other threads. 

//Check if object is null - void assertNull(Object, object), causes method to be run aftert each test method - @after. Best way to release a thread object when done - assign null to threat var
//Requests connection to server using - S s = new Socket(ServerName, port), listens for request using Socket s = serverSOcket.accept(), sleep - puts thread to sleep for specified time in ms



//Integration testing - big bang, bottom up, top down, sandwich, continuous. Driver - component calls testedUnit, 
//controls test cases. Stub - testedunit depends, partial impl, return fake values
//Functional - test cases are designed from the requirements analysis document (better: user manual) 
//and centered around requirements and key functions (use cases) (black box), can be reused
//Perforamnce - Test how the system behaves when overloaded., Can bottlenecks be identified, 
//Try unusual orders of execution,response to lots of data, amojnt of time spent in different use cases
//software test plan - introduction, goals/objs, statement of scope, major constraints, test plan, 
//software to be tested, testing strat, unit testing, integration testing, system testing acceptance testing, 
//test procedure, software to be tested, testing procedure, unit test cases, stubs/drivers for component i






























