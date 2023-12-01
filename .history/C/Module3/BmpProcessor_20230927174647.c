#include "BmpProcessor.h"
#include "PixelProcessor.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

struct BMP_Header *init_BMP_Header()
{
	struct BMP_Header *h = calloc(1, sizeof *h);
	return h;
}

struct DIB_Header *init_DIB_Header()
{

	struct DIB_Header *h = calloc(1, sizeof *h);
	return h;
}

// Read BMP Header
void readBMPHeader(FILE *file, struct BMP_Header *header)
{
	fread(&header->signature, sizeof(char) * 2, 1, file);
	fread(&header->filesize, sizeof(int), 1, file);
	fread(&header->reserved1, sizeof(int), 1, file);
	fread(&header->reserved2, sizeof(int), 1, file);
	fread(&header->pixelArrayOffset, sizeof(int), 1, file);
}

// Write BMP Header
void writeBMPHeader(FILE *file, struct BMP_Header *header)
{
	fwrite(&header->signature, sizeof(char) * 2, 1, file);
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
	struct BMP_Header *head = header;

	head->signature[0] = 'B';
	head->signature[1] = 'M';
	head->filesize = 69366;
	head->reserved1 = 0;
	head->reserved2 = 0;
	head->pixelArrayOffset = 54;
	header = head;
}

// Make DIB Header
void makeDIBHeader(struct DIB_Header *header, int width, int height)
{
	struct DIB_Header *head = header;

	head->size = 40;
	head->width = width;
	head->height = height;
	head->colorPlanes = 1;
	head->bitsPerPixel = 24;
	head->compression = 0;
	head->imageSize = width * height * 3;
	head->xResolution = 3780;
	head->yResolution = 3780;
	head->paletteColors = 0;
	head->importantColors = 0;
	header = head;
}

// Read Pixels from BMP file
void readPixelsBMP(FILE *file, struct Pixel **pArr, int width, int height)
{
	int count = 0;
	// Allocate memory for pixel array
	*pArr = (struct Pixel *)malloc(sizeof(struct Pixel) * width * height);

	struct Pixel *temp = *pArr;

	for (int x = 0; x < width; x++)
	{
		for (int y = 0; y < height; y++)
		{
			fread(&temp[count].blue, sizeof(char), 1, file);
			fread(&temp[count].green, sizeof(char), 1, file);
			fread(&temp[count].red, sizeof(char), 1, file);
			count++;
		}
	}
}

// Write Pixels to BMP file
void writePixelsBMP(FILE *file, struct Pixel **pArr, int width, int height)
{
	int count = 0;
	struct Pixel *temp = *pArr;

	// Iterate through each pixel in the array
	for (int y = 0; y < height; y++)
	{
		for (int x = 0; x < width; x++)
		{
			fwrite(&temp[count].blue, sizeof(char), 1, file);
			fwrite(&temp[count].green, sizeof(char), 1, file);
			fwrite(&temp[count].red, sizeof(char), 1, file);
			count++;
		}
		unsigned char paddingData[4] = {0}; // Padding bytes
		fwrite(paddingData, sizeof(unsigned char),
			   (4 - (width * sizeof(struct Pixel)) % 4) % 4, file); // Write padding
	}
}