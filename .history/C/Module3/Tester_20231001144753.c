#include <stdio.h>
#include <string.h> // strcpy

void main()
{
    int y = 10;
    int *yptr;
    int *xptr; // Is there a difference between int* vs. *xptr?
    yptr = &y;
    xptr = &y;  // Is this legal?
    *yptr = 20; // Dereferencing?
    *xptr = 30;

    printf("%d", y);
}