#include <iostream>
#include<string.h>
using namespace std;

class Customer{
    private:
    //instance varibles
    string name;
    int numCalls;
    int monthly;

    public:
    //constructor
    Customer(string nam, int num){
        name = nam;
        numCalls = num;
        monthly = 10;
    }

    //standard get/set functions
    string getName(){
        return name;
    }

    int getCalls(){
        return numCalls;
    }

    string setName(string nam){
        name = nam;
        return name;
    }

    int getMonthly(){
        return monthly;
    }
    
    int setCalls(int calls){
        numCalls = calls;
        return numCalls;
    }

    virtual double Compute_Bill(){
        double Bill; 
        Bill = monthly + (numCalls * .5);
        return Bill;
    }
};

class Premium: public Customer{
    private: 
    //instace variables
    int numMins;

    public: 
    //constructor
    Premium(string name, int numCalls, int mins) : Customer(name, numCalls){
        numMins = mins;
        monthly = 20;
    }

    //standard get/set functions
    int getMins(){
        return numMins;
    }
    
    int getMonthly(){
        return monthly;
    }
    
    int getCalls(){
        return numCalls;
    }

    int setMins(int mins){
        numMins = mins;
        return numMins;
    }

    virtual double Compute_Bill(){
        double Bill; 
        Bill = monthly + (numCalls * .05) + (numMins * .1);
        return Bill;
    }
};

int main() { 
    Customer* list[6] ; 
    list[0] = new Customer("John Doe", 20); 
    list[1] = new Customer("Bob Doe", 50); 
    list[2] = new Customer("Judge Doe", 70); 
    list[3] = new Premium("Boob Dooe", 201, 210);
    list[4] = new Premium("Joohn Dooe", 202, 20); 
    list[5] = new Premium("Joane Doe", 20, 5);  
    
    //prints out bill for each customer
    for(int i=0; i<6; i++) { 
        cout << "Customer " << list[i]->getName() << " owes " << list[i] -> Compute_Bill() << " dollars." << endl; 
    } 
    
    // code to compare plans for each of the premium customer and 
    for(int i=0; i<6; i++) { 
        if(list[i] -> getMonthly() == 20){
            double bill;
            bill = 10 + (list[i] -> getCalls() * .5);
            cout << endl;
            cout << list[i]->getName() << " : Basic Plan cost " << bill << " dollars Premium Plan cost " << list[i] -> Compute_Bill() << endl;
            string ans = "";
            
            if(bill > list[i] -> Compute_Bill()){
                ans = "premium plan";
            }else{
                ans = "basic plan";
            }
            cout << list[i]->getName() << " : Should opt for " << ans << endl;;
        }
    } 
    
    // delete all the customers     
    for(int i = 0; i < 6; i++){
        delete list[i];
    }
    return 1; 
};