#include <stdio.h>
#include <string.h> // strcpy

void main()
{
    int x = 0, *y;

        printf("%d\n", x);
        printf("%d\n", y);

    y = &x;

    printf("%d\n", x);
        printf("%d\n", y);
    *y = *y + 10;

    printf("%d\n", x);
        printf("%d\n", y);
    y++;

    printf("%d\n", x);
        printf("%d\n", y);
}