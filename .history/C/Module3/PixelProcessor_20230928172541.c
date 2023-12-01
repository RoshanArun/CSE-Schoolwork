#include "PixelProcessor.h"

struct Pixel* init_Pixel(){
    struct Pixel *h = calloc(1, sizeof*h);
    return h;
}

// Shift color of pixel
void colorShiftPixels(struct Pixel **pArr, int width, int height, int rShift, int gShift, int bShift)
{
	struct Pixel *temp = *pArr;

	for (int y = 0; y < height; y++)
	{
		for (int x = 0; x < width; x++)
		{
			int counter = y * width + x; 

			if (rShift != 0)
			{
				int r = temp[counter].red + rShift;
				temp[counter].red = (unsigned char)((r > 255) ? 255 : (r < 0) ? 0
																			  : r);
			}
			if (gShift != 0)
			{
				int g = temp[counter].green + gShift;
				temp[counter].green = (unsigned char)((g > 255) ? 255 : (g < 0) ? 0
																				: g);
			}
			if (bShift != 0)
			{
				int b = temp[counter].blue + bShift;
				temp[counter].blue = (unsigned char)((b > 255) ? 255 : (b < 0) ? 0
																			   : b);
			}
		}
	}
}