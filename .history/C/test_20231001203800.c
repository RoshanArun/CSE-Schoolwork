#include <stdio.h>
#include <string.h>
struct Course
{
  int sln;
  char title[256];
  char instructor[250];
  int time;
};
struct Course ser222;

void main(){
  ser222.sln = 1774;
  strcpy(ser222.title, "Data Structures & Algorithms");
  strcat(ser222.instructor, "Acuna, Ruben");
  printf("Memory allocated for this structure is %d", sizeof(ser222));
}
