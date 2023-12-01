#define PIXELPROCESSOR_H
#ifndef PIXELPROCESSOR_H

#include "PixelProcessor.h"

struct Pixel* init_Pixel(){
    struct Pixel *h = calloc(1, sizeof*h);
    return h;
}


void colorShiftPixels(struct Pixel **pArr, int width, int height, int rShift, int gShift, int bShift) {
    struct Pixel *temp = *pArr;
    
    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            int counter = y * width + x; 
            
            if (rShift != 0) {
                int r = temp[counter].r + rShift;
                temp[counter].r = (unsigned char)((r > 255) ? 255 : (r < 0) ? 0 : r);
            }
            if (gShift != 0) {
                int g = temp[counter].g + gShift;
                temp[counter].g = (unsigned char)((g > 255) ? 255 : (g < 0) ? 0 : g);
            }
            if (bShift != 0) {
                int b = temp[counter].b + bShift;
                temp[counter].b = (unsigned char)((b > 255) ? 255 : (b < 0) ? 0 : b);
            }
        }
    }

    printf("Pixel color shift success\n");
}
