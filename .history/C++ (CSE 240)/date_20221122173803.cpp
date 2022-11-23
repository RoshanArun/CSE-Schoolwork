#include <iostream>
using namespace std;

class date{
    //instance varibles
    private: 
    int month;
    int day; 
    int year;
    
    public: 
    
    //set and get methods
    void setMonth(int mon){
        month = mon;
    }
    
    int getMonth(){
        return month;
    }
    
    void setDay(int da){
        day = da;
    }
    
    int getDay(){
        return day;
    }
    
    void setYear(int yea){
        year = yea;
    }
    
    int getYear(){
        return year;
    }
    
    //prints first part
    void print(){
        cout << month << "/" << day << "/" << year << endl;
    }
    
    //prints second part
    void print1(){
        if(month == 1){
            cout << "January" << " " << day << ", " << year << endl;
        }
        else if(month == 2){
            cout << "February" << " " << day << ", " << year << endl;
        }
        else if(month == 3){
            cout << "March" << " " << day << ", " << year << endl;
        }
        else if(month == 4){
            cout << "April" << " " << day << ", " << year << endl;
        }
        else if(month == 5){
            cout << "May" << " " << day << ", " << year << endl;
        }
        else if(month == 6){
            cout << "June" << " " << day << ", " << year << endl;
        }
        else if(month == 7){
            cout << "July" << " " << day << ", " << year << endl;
        }
        else if(month == 8){
            cout << "August" << " " << day << ", " << year << endl;
        }
        else if(month == 9){
            cout << "September" << " " << day << ", " << year << endl;
        }
        else if(month == 10){
            cout << "October" << " " << day << ", " << year << endl;
        }
        else if(month == 11){
            cout << "November" << " " << day << ", " << year << endl;
        }
        else if(month == 12){
            cout << "December" << " " << day << ", " << year << endl;
        }
    }
    
    //prints third part
    void print2(){
         if(month == 1){
            cout << day << " " << "January" << " " << year << endl;
        }
        else if(month == 2){
            cout << day << " " << "February" << " " << year << endl;
        }
        else if(month == 3){
            cout << day << " " << "March" << " " << year << endl;
        }
        else if(month == 4){
            cout << day << " " << "April" << " " << year << endl;
        }
        else if(month == 5){
            cout << day << " " << "May" << " " << year << endl;
        }
        else if(month == 6){
            cout << day << " " << "June" << " " << year << endl;
        }
        else if(month == 7){
            cout << day << " " << "July" << " " << year << endl;
        }
        else if(month == 8){
            cout << day << " " << "August" << " " << year << endl;
        }
        else if(month == 9){
            cout << day << " " << "September" << " " << year << endl;
        }
        else if(month == 10){
            cout << day << " " << "October" << " " << year << endl;
        }
        else if(month == 11){
            cout << day << " " << "November" << " " << year << endl;
        }
        else if(month == 12){
            cout << day << " " << "December" << " " << year << endl;
        }
    }
};

int main() {
    date* test1 = new date();
    int month;
    int day;
    int year;
    
    //gets user inputs
    cout << "Enter a month: " << endl;
    cin >> month;
    cout << "Enter a day: " << endl;
    cin >> day;
    cout << "Enter a year: " << endl;
    cin >> year;

    try{
        //throws months/day depending on info
        if(month <= 0){
            throw month;
        }
        if(month >= 13){
            throw month;
        }
        try{
            if(day <= 0){
                throw month;
            }
            
            if(month == 2){
                if(year % 4 == 0){
                    if(day >= 30){
                        throw day;
                    }
                    else if(day >= 29){
                        throw day;
                    }
                }
            }
            
            else if(month == 9 || month == 11 || month == 4 || month == 6) {
                if(day >= 31){
                    throw day;
                }
            }
            else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
                if(day >= 32){
                    throw day;
                }
            }
            
            test1->setMonth(month);
            test1->setDay(day);
            test1->setYear(year);
            test1->print();
            test1->print1();
            test1->print2();
        }
        catch(int day){
            cout << day << " is an invalid day number... Terminating...";
        }
    }
    catch(int month){
        cout << month << " is an invalid month number ... Terminating...";
    }
}


