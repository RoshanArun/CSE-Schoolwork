/**
* (This program computes teh total volume for a number of cylinders, specifications are given by the user)
*
* Completion time: (20 minutes)
*
* @author (Roshan Arun),
* @version (1)
*/
////////////////////////////////////////////////////////////////////////////////

#include <stdio.h>
#include <math.h>
int main(void){
    int cylinders;
    float total = 0;

    //Add a prompt for the number of cylinders to sum. Make sure to use the control symbol for integers. [2 points]
    printf("Enter the number of cylinders: ");
    scanf("%d", &cylinders);

    //Create a loop based on the number of cylinders the user enters. [2 points]
    //Within the loop, prompt for height and radius parameters (allow floating point numbers)
    //Calculate the volume for that particular cylinder. [4 points]
    for(int i = 0; i < cylinders; i++){
        float height;
        float radius;

        printf("Enter the height of the cylinder: ");
        scanf("%f", &height);

        printf("Enter the radius of the cylinder: ");
        scanf("%f", &radius);

        total = total + (M_PI * (radius * radius) * height);
    }
    //Display the total volume sum back to the user. Make sure to use the right control
    //symbol. [2 points]

    printf("Total Volume of cylinders: %f", total);
    return 0;
}