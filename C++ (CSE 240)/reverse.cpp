#include <iostream>
#include<string.h>
using namespace std;

int main(){
    char *head, *tail; //head and tail pointer
    char temp; //temp variable

    //gets input from user
    string input3;
    cout << "Enter the input String: " << endl;
    cin >> input3;

    //create array of character with the string length
    char input[input3.length()];
    //convert string to char array 
    strcpy(input, input3.c_str());

    //tail points to end, and head opints to front of string
    tail = input + strlen(input) - 1;
    head = input;

    //loop until head reaches the tail
    while(head <= tail){
        temp = *head;
        *head++= *tail;
        *tail --= temp;
    }
    cout << "Reversed String: " << input << endl;
}