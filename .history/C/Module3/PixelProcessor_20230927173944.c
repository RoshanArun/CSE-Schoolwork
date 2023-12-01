#include "BmpProcessor.h"
#include "PixelProcessor.h"
#include "PpmProcessor.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

struct Pixel* init_Pixel(){
    struct Pixel *h = calloc(1, sizeof*h);
    return h;
}

// Shift color of pixel
void colorShiftPixel(struct Pixel *p, int rShift, int gShift, int bShift)
{
	// Add the corresponding shift value to each color value, making sure to keep the values between 0 and 255
	p->red = (p->red + rShift) % 256;
	p->green = (p->green + gShift) % 256;
	p->blue = (p->blue + bShift) % 256;
}

// Print Pixel
void printPixel(struct Pixel *p)
{
	printf("(%d, %d, %d)\n", p->red, p->green, p->blue);
}

// Shift color of Pixels
void colorShiftPixels(struct Pixel **arr, int width, int height, int rShift, int gShift, int bShift)
{
	// Iterate through each pixel in the array
	for (int i = 0; i < width * height; i++) {
		// Shift the color of each individual pixel
		colorShiftPixel(&(*arr)[i], rShift, gShift, bShift);
	}
}