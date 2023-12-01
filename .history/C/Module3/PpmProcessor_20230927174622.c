#include "BmpProcessor.h"
#include "PixelProcessor.h"
#include "PpmProcessor.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

struct PPM_Header *init_PPM_Header()
{

	struct PPM_Header *h = calloc(1, sizeof *h);
	return h;
}

// Read PPM Header
void readPPMHeader(FILE *file, struct PPM_Header *header)
{
	fread(&header->signature, sizeof(char) * 2, 1, file);
	fread(&header->width, sizeof(int), 1, file);
	fread(&header->height, sizeof(int), 1, file);
	fread(&header->maxColorVal, sizeof(int), 1, file);
}

// Write PPM Header
void writePPMHeader(FILE *file, struct PPM_Header *header)
{
	fwrite(&header->signature, sizeof(char) * 2, 1, file);
	fwrite(&header->width, sizeof(int), 1, file);
	fwrite(&header->height, sizeof(int), 1, file);
	fwrite(&header->maxColorVal, sizeof(int), 1, file);
}

// Make PPM Header
void makePPMHeader(struct PPM_Header *header, int width, int height)
{
	struct PPM_Header *head = header;

	header->signature[0] = 'P';
	header->signature[1] = '6';
	header->width = width;
	header->height = height;
	header->maxColorVal = 255;
	header = head;
}

// Read Pixels from PPM file
void readPixelsPPM(FILE *file, struct Pixel **pArr, int width, int height)
{
	int counter = 0;
	struct Pixel *temp = pArr;

	for (int x = 0; x < width; x++)
	{
		// printf("entering for layer 1, loop: %d\n", x);
		for (int y = 0; y < height; y++)
		{
			// printf("entering for layer 2, loop: %d\n", y);
			fscanf(file, "%c", &temp[counter].red);
			fscanf(file, "%c", &temp[counter].green);
			fscanf(file, "%c", &temp[counter].blue);

			counter++;
		}
		fseek(file, sizeof(unsigned char) * width, SEEK_CUR);
	}
}

// Write Pixels to PPM file
void writePixelsPPM(FILE *file, struct Pixel **pArr, int width, int height)
{
	int counter = 0;
	struct Pixel *temp = pArr;
	printf("Entering Write PPM Pixels..\n");
	for (int x = 0; x < width; x++)
	{
		for (int y = 0; y < height; y++)
		{
			counter++;
		}
		fseek(file, sizeof(unsigned char) * width, SEEK_CUR);
	}
}
