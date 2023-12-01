#include <stdio.h>
#include <string.h> // strcpy

void main()
{
    int x = 0, *y;

        printf("%d", x);
        printf("%d", y);

    y = &x;
    *y = *y + 10;
    y++;
}