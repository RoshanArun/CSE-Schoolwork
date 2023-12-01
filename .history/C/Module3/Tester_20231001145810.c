#include <stdio.h>
#include <string.h> // strcpy

void main()
{
    int i = 137, *j, **k;
    printf("%d\n", i);
    printf("%d\n", j);
    printf("%d\n", k);

    j = &i;
     printf("%d\n", i);
    printf("%d\n", j);
    printf("%d\n", k);
    k = &j;
     printf("%d\n", i);
    printf("%d\n", j);
    printf("%d\n", k);
    **k = 0;
    printf("%d\n", i);
    printf("%d\n", j);
    printf("%d\n", k);


    
}