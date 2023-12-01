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
                if (r > 255) {
                    temp[counter].r = 255;
                }
                else if (r < 0) {
                    temp[counter].r = 0;
                }
                else {
                    temp[counter].r = r;
                }
            }
            if (gShift != 0) {
                int g = temp[counter].g + gShift;
                if (g > 255) {
                    temp[counter].g = 255;
                }
                else if (g < 0) {
                    temp[counter].g = 0;
                }
                else {
                    temp[counter].g = g;
                }
            }
            if (bShift != 0) {
                int b = temp[counter].b + bShift;
                if (b > 255) {
                    temp[counter].b = 255;
                }
                else if (b < 0) {
                    temp[counter].b = 0;
                }
                else {
                    temp[counter].b = b;
                }
            }
        }
    }
}
