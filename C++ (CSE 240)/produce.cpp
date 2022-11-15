#include <iostream>
#include<string.h>
#include <string>
using namespace std;

class BoxOfProduce{
    //private variable representing box of food 
    private: 
    string food[3];

    public:
    //returns food items
    string getfruit(int i){
        return food[i];
    }

    //sets the food 
    string setFruit(int i, string newFood){
        food[i] = newFood;
        return food[i];
    }

    //displays all items in the box
    void display(){
        cout << "Contents of the box: " << endl;
        for(int i = 0; i < 3; i++){
            cout << food[i] << ", ";
        }
        cout << endl;
    }
};

int main(){
    BoxOfProduce one;
    bool cont = true;
    static int numOfBoxes = 1;
    string items[5] = {"Broccoli", "Tomato", "Kiwi", "Kale", "Tomatillo"};

    //creates a random box filled w veggies/fruits from the list
    srand (time(NULL));
    for(int i = 0 ; i < 3; i++){
        int RanIndex = rand() % 5;
        one.setFruit(i, items[RanIndex]);
    }

    //keeps creating boxes until they don't want more 
    while(cont = true){
        one.display();
        string userInput;
        string yHold = "y";
        cout << endl;
        cout << "Would you like to replace any of the produce? (y/n)" << endl;
        cin >> userInput;

        //this loop asks a series of questions and uses the answers to create specific boxes of veggies/fruits 
        while(userInput.compare(yHold) == 0){
            cout << "Which produce would you like to replace? (1/2/3)" << endl;
            cin >> userInput;

            //check test case "1"
            if(userInput.compare("1") == 0){
                cout << "What vegetable would you like in slot 1? Options: [Broccoli, Tomato, Kiwi, Kale, Tomatillo] (1/2/3/4/5)" << endl;
                cin >> userInput;
                int num = stoi(userInput) - 1;
                one.setFruit(0, items[num]);
                cout << endl;
                one.display();
                cout << "Number of Boxes: ";
                cout << numOfBoxes;
                cout << endl;
                cout << endl;
                cout << "Would you like to replace any of the produce? (y/n)" << endl;
                cin >> userInput;
            }
            //check test case "2"
            else if(userInput.compare("2") == 0){
                cout << "What vegetable would you like in slot 2? Options: [Broccoli, Tomato, Kiwi, Kale, Tomatillo] (1/2/3/4/5)" << endl;
                cin >> userInput;
                int num = stoi(userInput) - 1;
                one.setFruit(1, items[num]);
                cout << endl;
                one.display();
                cout << "Number of Boxes: ";
                cout << numOfBoxes;
                cout << endl;
                cout << endl;
                cout << "Would you like to replace any of the produce? (y/n)" << endl;
                cin >> userInput;
            }
            //check test case "3"
            else if(userInput.compare("3") == 0){
                cout << "What vegetable would you like in slot 3? Options: [Broccoli, Tomato, Kiwi, Kale, Tomatillo] (1/2/3/4/5)" << endl;
                cin >> userInput;
                int num = stoi(userInput) - 1;
                one.setFruit(2, items[num]);
                cout << endl;
                one.display();
                cout << "Number of Boxes: ";
                cout << numOfBoxes;
                cout << endl;
                cout << endl;
                cout << "Would you like to replace any of the produce? (y/n)" << endl;
                cin >> userInput;
            }
        }
        cout << endl;
        cout << "Would you like to create another box? (y/n)" << endl;
        cin >> userInput;
        cout << endl;

        //checks user input to see if another box should be created
        if(userInput.compare(yHold) == 0){
            cont = true;
            numOfBoxes = numOfBoxes + 1;
        }else{
            //if not, then it prints the number of boxes created
            cont = false;
            cout << "Number of Boxes: ";
            cout << numOfBoxes;
            return 0;
        }
    }
}