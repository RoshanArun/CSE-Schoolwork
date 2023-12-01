#include "PixelProcessor.h"


/////////////////////////////////////////////////////////////
//  Function definitions
     /*
 * Creates struct Pixel
 * @return pointer to new Pixel struct
 */ 
struct Pixel* init_Pixel(){
    struct Pixel *h = calloc(1, sizeof*h);
    return h;
}
/**
 * Shift color of Pixel array. The dimension of the array is width * height. The shift value of RGB is 
 * rShift, gShiftï¼ŒbShift. Useful for color shift.
 *
 * @param  pArr: Pixel array of the image that this header is for
 * @param  width: Width of the image that this header is for
 * @param  height: Height of the image that this header is for
 * @param  rShift: the shift value of color r shift
 * @param  gShift: the shift value of color g shift 
 * @param  bShift: the shift value of color b shift 
 */void colorShiftPixels(struct Pixel **pArr, int width, int height, int rShift, int gShift, int bShift) {
    struct Pixel *temp = *pArr;
    
    printf("Entering Pixel color shift..\n");

    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            int counter = y * width + x; // Calculate the index in the 1D array
            
            if (rShift != 0) {
                int r = temp[counter].red + rShift;
                temp[counter].red = (unsigned char)((r > 255) ? 255 : (r < 0) ? 0 : r);
            }
            if (gShift != 0) {
                int g = temp[counter].green + gShift;
                temp[counter].green = (unsigned char)((g > 255) ? 255 : (g < 0) ? 0 : g);
            }
            if (bShift != 0) {
                int b = temp[counter].blue + bShift;
                temp[counter].blue = (unsigned char)((b > 255) ? 255 : (b < 0) ? 0 : b);
            }
        }
    }

    printf("Pixel color shift success\n");
}
