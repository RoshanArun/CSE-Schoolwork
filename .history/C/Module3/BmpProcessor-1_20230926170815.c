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

// Read DIB Header
void readDIBHeader(FILE *file, struct DIB_Header *header)
{
	fread(&header->size, sizeof(int), 1, file);
	fread(&header->width, sizeof(int), 1, file);
	fread(&header->height, sizeof(int), 1, file);
	fread(&header->colorPlanes, sizeof(short), 1, file);
	fread(&header->bitsPerPixel, sizeof(short), 1, file);
	fread(&header->compression, sizeof(int), 1, file);
	fread(&header->imageSize, sizeof(int), 1, file);
	fread(&header->xResolution, sizeof(int), 1, file);
	fread(&header->yResolution, sizeof(int), 1, file);
	fread(&header->paletteColors, sizeof(int), 1, file);
	fread(&header->importantColors, sizeof(int), 1, file);
}

// Write DIB Header
void writeDIBHeader(FILE *file, struct DIB_Header *header)
{
	fwrite(&header->size, sizeof(int), 1, file);
	fwrite(&header->width, sizeof(int), 1, file);
	fwrite(&header->height, sizeof(int), 1, file);
	fwrite(&header->colorPlanes, sizeof(short), 1, file);
	fwrite(&header->bitsPerPixel, sizeof(short), 1, file);
	fwrite(&header->compression, sizeof(int), 1, file);
	fwrite(&header->imageSize, sizeof(int), 1, file);
	fwrite(&header->xResolution, sizeof(int), 1, file);
	fwrite(&header->yResolution, sizeof(int), 1, file);
	fwrite(&header->paletteColors, sizeof(int), 1, file);
	fwrite(&header->importantColors, sizeof(int), 1, file);
}