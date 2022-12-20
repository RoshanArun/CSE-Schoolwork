#include <iostream>
#include<string.h>
using namespace std;

class Ship{
    private: 
    //instance variables
    string name;
    int year;

    public: 
    //constructor
    Ship(string nam, int y){
        name = nam;
        year = y;
    }

    //get/set functions
    string getName(){
        return name;
    }

    int getYear(){
        return year;
    }

    string setName(string str){
        name = str;
        return name;
    }

    int setYear(int y){
        year = y;
        return year;
    }

    //print statement
    virtual void print(){
        cout << "The Ship "<<getName()<< " was built in " << getYear()<<"."<<endl; 
        cout << endl;
    }
};

class CruiseShip: public Ship{
    private: 
    //instance variables
    int maxPeople;

    public:
    //constructor
    CruiseShip(string nam, int y, int ma) : Ship(nam, y){
        maxPeople = ma;
    }

    //print function
    virtual void print(){
        cout << "The Cruise "<<getName() << " can have a maximum of " << maxPeople << " passengers." <<endl;
        cout << endl;
    }
};

class CargoShip: public Ship{
    private: 
    //instance variables
    int capacity; 

    public: 
    //constructor
    CargoShip(string nam, int y, int cap) : Ship(nam, y){
        capacity = cap;
    }

    //print function
    virtual void print(){
        cout << "The Cruise "<<getName() << " has capacity of "<< capacity<< " tons." << endl; 
        cout << endl;
    }
};


int main(){
    int i ;
    //creates multiple ships
    Ship *ships[3] = {
    new Ship("Test1", 1960),
    new CruiseShip("Test2", 2010, 2400),
    new CargoShip("Test3", 2003, 50000)
    };


    //prints ships
    for(int i = 0; i < 3; i++){
        ships[i]->print();
        ("pause");
    }

    //variables
    string shipType; 
    string name;
    int year;
    int maxPeople;
    int capacity;

    cout << endl;
    cout << "Enter the type of the ship: (Ship/Cruise/Cargo)" << endl;
    cin >> shipType;

    //if statement to determine which ship, and what questions to ask
    if(shipType.compare("Ship") == 0){
        cout << "Enter the name of the ship: "<< endl;
        cin >> name;
        cout << "Enter the year that the ship was built in: "<< endl;
        
        Ship *working[1] = {new Ship(name, year)};
        cout<<endl;
        working[0]->print();
    }
    if(shipType.compare("Cruise") == 0){
        cout << "Enter the name of the ship: "<< endl;
        cin >> name;
        cout << "Enter the year that the ship was built in: "<< endl;
        cin >> year;
        cout << "Enter the maximum number of passengers: "<< endl;
        cin >> maxPeople;
        
        Ship *working[1] = {new CruiseShip(name, year, maxPeople)};
        cout<<endl;
        working[0]->print();
    }
    if(shipType.compare("Cargo") == 0){
        cout << "Enter the name of the ship: "<< endl;
        cin >> name;
        cout << "Enter the year that the ship was built in: "<< endl;
        cin >> year;
        cout << "Enter the cargo capacity of the ship in tons: "<< endl;
        cin >> capacity;
        
        Ship *working[1] = {new CargoShip(name, year, capacity)};
        cout<<endl;
        working[0]->print();
    }
    return 0;
}