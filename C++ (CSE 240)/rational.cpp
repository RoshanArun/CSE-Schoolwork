#include <iostream>
#include<string.h>
using namespace std;

class rational{
    private: 
    //declaring private varibles 
    int num;
    int den;


    public:
    //standard constructor
    rational(){
        num = 0;
        den = 1;
    }

    //constructor taking whole number
    rational(int whole){
        num = whole;
        den = 1;
    }

    //constructor using a numerator and denominator 
    rational(int numer, int denom){
        num = numer;
        den = denom;
    }



    //overloads == operator
    bool operator ==(const rational& test){
        return (num == test.num && den == test.den);
    }

    //overloads > operator
    bool operator >(const rational& test){
        return ((num * test.den) > (den * test.num));
    }

    //overloads < operator
    bool operator <(const rational& test){
        return ((num * test.den) < (den * test.num));
    }



    //overloads != operator
    bool operator !=(const rational& test){
        return !(*this == test);
    }

    //overloads <= operator
    bool operator <=(const rational& test){
        return (*this < test || *this == test);
    }

    //overloads >= operator
    bool operator >=(const rational& test){
        return (*this > test || *this == test);
    }



    //overloads + operator
    rational operator +(const rational& test){
        int newNum = (num * test.den) + (den * test.num);
        int newDen = den * test.den;
        rational one(newNum, newDen);
        return one;
    }   

    //overloads - operator
    rational operator -(const rational& test){
        int newNum = (num * test.den) - (den * test.num);
        int newDen = den * test.den;
        rational one(newNum, newDen);
        return one;
    }

    //overloads * operator
    rational operator *(const rational& test){
        int newNum = num * test.num;
        int newDen = den * test.den;
        rational one(newNum, newDen);
        return one;
    }

    //overloads / operator
    rational operator /(const rational& test){
        int newNum = num * test.den;
        int newDen = den * test.num;
        rational one(newNum, newDen);
        return one;
    }



    //overloads << operator
    friend ostream& operator <<(ostream& outputStream, const rational& amount){
        outputStream << amount.num << "/" << amount.den;
        return outputStream;
    }

    //overloads >> operator
    friend istream& operator >>(istream& inputStream, rational& amount){
        char x;
        inputStream >> amount.num;
        inputStream >> x;
        inputStream >> amount.den;
        amount.normal();
        return inputStream;
    }

    //normalizes the fraction
    rational normal(){
        rational temp; 
        int one; 
        int two;
        int three; 

        one = num;
        two = den;
        three = (one * one < two * two)? (three = one):(three = two);
        for(int i = 2; i*i < three*three; i++){
            while((one % i) == 0 && (two % i) == 0){
                one = one / i;
                two = two / i;
                three = three / i;
            }
        }
        if (two < 0){
            temp.num = -one;
            temp.den = -two;
        }else{
            temp.num = one;
            temp.den = two;
        }
        return temp;
    }
};

//tests all funcitons
int main(){
    rational num;
    rational num2;
    rational num3;

    cout << "Enter the first number: ";
    cin >> num;

    cout << "Enter the second number: ";
    cin >> num2;

    cout << "First number is: " << num << endl;
    cout << "Second number is: " << num2 << endl;
    cout << "First number normalized is: " << num.normal() << endl;
    cout << "Second number normalized is: " << num2.normal() << endl;
    cout << endl;

    num3 = num.operator+(num2);
    cout << "Addition: " << num3 << endl;
    cout << "Normalized Sum: " << num3.normal() << endl;
    cout << endl;

    num3 = num.operator-(num2);
    cout << "Subtraction: " << num3 << endl;
    cout << "Normalized Difference: " << num3.normal() << endl;
    cout << endl;

    num3 = num.operator*(num2);
    cout << "Multiplication: " << num3 << endl;
    cout << "Normalized Product: " << num3.normal() << endl;
    cout << endl;

    num3 = num.operator/(num2);
    cout << "Division: " << num3 << endl;
    cout << "Normalized Quotient: " << num3.normal() << endl;
    cout << endl;

    cout << "Is " << num << " < " << num2 << "? " << (num.operator<(num2) ? "yes" : "no") << endl;
    cout << "Is " << num << " > " << num2 << "? " << (num.operator>(num2) ? "yes" : "no") << endl;
    cout << endl;

    cout << "Is " << num << " <= " << num2 << "? " << (num.operator<=(num2) ? "yes" : "no") << endl;
    cout << "Is " << num << " >= " << num2 << "? " << (num.operator>=(num2) ? "yes" : "no") << endl;
    cout << endl;

    cout << "Is " << num << " == " << num2 << "? " << (num.operator==(num2) ? "yes" : "no") << endl;
    cout << "Is " << num << " != " << num2 << "? " << (num.operator!=(num2) ? "yes" : "no") << endl;
}