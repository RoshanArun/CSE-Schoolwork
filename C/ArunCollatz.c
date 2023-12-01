/**
* (This program returns the number of loops for a positive integer that satisfies the collatz conjecture)
*
* Completion time: (20 minutes)
*
* @author (Roshan Arun),
* @version (1)
*/
////////////////////////////////////////////////////////////////////////////////

#include <stdio.h>
int termination(int x){
    int count = 0;

    while(x != 1){
        if(x % 2 == 0){
            x /= 2;
        }else{
            x = (3 * x) + 1;
        }
        count++;
    }
    return count;
}

int main(void){
    int input;
    printf("Please Enter Integer: ");
    scanf("%d", &input);

    printf("Number of Iterations: %d\n", termination(input));
    return 0;
}