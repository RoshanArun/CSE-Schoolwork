#include "BmpProcessor-1.h"
#include "PixelProcessor-1.h"
#include "PpmProcessor-1.h"

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

// Make BMP Header
void makeBMPHeader(struct BMP_Header *header, int width, int height)
{
	header->signature1 = 'B';
	header->signature2 = 'M';
	header->filesize = width * height * 3;
	header->reserved1 = 0;
	header->reserved2 = 0;
	header->pixelArrayOffset = 54;
}

// Make DIB Header
void makeDIBHeader(struct DIB_Header *header, int width, int height)
{
	header->size = 69366;
	header->width = width;
	header->height = height;
	header->colorPlanes = 1;
	header->bitsPerPixel = 24;
	header->compression = 0;
	header->imageSize = width * height * 3;
	header->xResolution = 3780;
	header->yResolution = 3780;
	header->paletteColors = 0;
	header->importantColors = 0;
}

// Read Pixels from BMP file
void readPixelsBMP(FILE *file, struct Pixel **pArr, int width, int height)
{
	// Allocate memory for pixel array
	*pArr = malloc(sizeof(struct Pixel) * width * height);

	// Iterate through each pixel in the array
	for (int i = 0; i < width * height; i++) {
		// Read in each color value for the pixel
		fread(&((*pArr)[i].blue), sizeof(char), 1, file);
		fread(&((*pArr)[i].green), sizeof(char), 1, file);
		fread(&((*pArr)[i].red), sizeof(char), 1, file);
	}
}

// Write Pixels to BMP file
void writePixelsBMP(FILE *file, struct Pixel **pArr, int width, int height)
{
	// Iterate through each pixel in the array
	for (int i = 0; i < width * height; i++) {
		// Write each color value for the pixel
		fwrite(&((*pArr)[i].blue), sizeof(char), 1, file);
		fwrite(&((*pArr)[i].green), sizeof(char), 1, file);
		fwrite(&((*pArr)[i].red), sizeof(char), 1, file);
	}
}