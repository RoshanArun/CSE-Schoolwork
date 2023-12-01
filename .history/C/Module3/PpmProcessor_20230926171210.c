#include "BmpProcessor-1.h"
#include "PixelProcessor-1.h"
#include "PpmProcessor-1.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

// Read PPM Header
void readPPMHeader(FILE *file, struct PPM_Header *header)
{
	fread(&header->signature[0], sizeof(char), 1, file);
	fread(&header->signature[1], sizeof(char), 1, file);
	fread(&header->width, sizeof(int), 1, file);
	fread(&header->height, sizeof(int), 1, file);
	fread(&header->maxColorVal, sizeof(int), 1, file);
}

// Write PPM Header
void writePPMHeader(FILE *file, struct PPM_Header *header)
{
	fwrite(header->signature, sizeof(char), 2, file);
	fwrite(&header->width, sizeof(int), 1, file);
	fwrite(&header->height, sizeof(int), 1, file);
	fwrite(&header->maxColorVal, sizeof(int), 1, file);
}

// Make PPM Header
void makePPMHeader(struct PPM_Header *header, int width, int height)
{
	header->signature[0] = 'P';
	header->signature[1] = '6';
	header->width = width;
	header->height = height;
	header->maxColorVal = 255;
}

// Read Pixels from PPM file
void readPixelsPPM(FILE *file, struct Pixel **pArr, int width, int height)
{
	// Allocate memory for pixel array
	*pArr = malloc(sizeof(struct Pixel) * width * height);

	// Iterate through each pixel in the array
	for (int i = 0; i < width * height; i++) {
		// Read in each color value for the pixel
		fread(&((*pArr)[i].red), sizeof(char), 1, file);
		fread(&((*pArr)[i].green), sizeof(char), 1, file);
		fread(&((*pArr)[i].blue), sizeof(char), 1, file);
	}
}

// Write Pixels to PPM file
void writePixelsPPM(FILE *file, struct Pixel **pArr, int width, int height)
{
	// Iterate through each pixel in the array
	for (int i = 0; i < width * height; i++) {
		// Write each color value for the pixel
		fwrite(&((*pArr)[i].red), sizeof(char), 1, file);
		fwrite(&((*pArr)[i].green), sizeof(char), 1, file);
		fwrite(&((*pArr)[i].blue), sizeof(char), 1, file);
	}
}
