#ifndef PIXELPROCESSOR_H
#define PIXELPROCESSOR_H

/////////////////////////////////////////////////////////////
//  Include files
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


/////////////////////////////////////////////////////////////
//  Type definitions

struct Pixel{
    unsigned char r;
    unsigned char g;
    unsigned char b;

};
/////////////////////////////////////////////////////////////
//  Function definitions
     /*
 * Creates struct Pixel
 * @return pointer to new Pixel struct
 */ 
struct Pixel* init_Pixel();

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
 */

void colorShiftPixels(struct Pixel** pArr, int width, int height, int rShift, int gShift, int bShift);

#endif
