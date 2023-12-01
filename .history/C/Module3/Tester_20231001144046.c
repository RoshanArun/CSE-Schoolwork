#include <stdio.h>
#include <string.h> // strcpy

void main()
{
    int i;
    char s[6], s1[] = "hello";
    char s2[5] = "world";
    for (i = 0; i < 5; i++)
    {
        printf("%c", s1[i]);
    }
    printf("\ns1 = %s, size = %d\n\n", s1, sizeof(s1));
    for (i = 0; i < 5; i++)
    {
        printf("%c", s2[i]);
    }
    printf("\ns2 = %s, size = %d\n", s2, sizeof(s2));
    printf("\ns = %s, size = %d\n", s, sizeof(s));
}