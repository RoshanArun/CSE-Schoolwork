#include <stdio.h>
#include <stdlib.h>

// Read BMP Header
void readBMPHeader(FILE *file, struct BMP_Header *header)
{
	fread(&header->signature1, sizeof(char), 1, file);
	fread(&header->signature2, sizeof(char), 1, file);
	fread(&header->filesize, sizeof(int), 1, file);
	fread(&header->reserved1, sizeof(int), 1, file);
	fread(&header->reserved2, sizeof(int), 1, file);
	fread(&header->pixelArrayOffset, sizeof(int), 1, file);
}