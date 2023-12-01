#include <stdio.h>
#include <string.h> // strcpy


void main() {
const int i = 5;
int *j;
// i = i + 2; // What would happen? Why?
j = &i;
printf("i = %d\n", i);
*j = *j + 2; // What would happen? Why?
printf("i = %d\n", i); return 0;
}
