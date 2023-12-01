#include <stdio.h>
#include <string.h> // strcpy

void main()
{
    int x = 0, *y;

        printf("%d", x);
        printf("%d", y);

    y = &x;

    printf("%d", x);
        printf("%d", y);
    *y = *y + 10;

    printf("%d", x);
        printf("%d", y);
    y++;

    printf("%d", x);
        printf("%d", y);
}