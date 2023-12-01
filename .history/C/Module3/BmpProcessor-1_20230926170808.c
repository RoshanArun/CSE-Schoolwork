#include "bmpProcessor-1.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

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

// Write BMP Header
void writeBMPHeader(FILE *file, struct BMP_Header *header)
{
	fwrite(&header->signature1, sizeof(char), 1, file);
	fwrite(&header->signature2, sizeof(char), 1, file);
	fwrite(&header->filesize, sizeof(int), 1, file);
	fwrite(&header->reserved1, sizeof(int), 1, file);
	fwrite(&header->reserved2, sizeof(int), 1, file);
	fwrite(&header->pixelArrayOffset, sizeof(int), 1, file);
}