
#include "BmpProcessor.h"
#include "PpmProcessor.h"
#include <getopt.h>
#include <unistd.h>

int main(int argc, char *argv[])
{

    char *input;
    char *output;
    char *type;
    int opt;
    int r = 0;
    int g = 0;
    int b = 0;
    int oFlag = 0;
    int rFlag = 0;
    int gFlag = 0;
    int bFlag = 0;
    int tFlag = 0;

    while ((opt = getopt(argc, argv, ":i:o:r:g:b::t:")) != -1)
    {
        switch (opt)
        {
            case 'i':
                input = optarg;
                printf("filename: %s\n", input);
                break;
            case ':':
                printf("Please enter a file name\n");
                break;
            case 'o':
                oFlag = 1;
                output = optarg;
                printf("output filename: %s\n", output);
                break;
            case 'r':
                rFlag = 1;
                r = atoi(optarg);
                break;
            case 'g':
                gFlag = 1;
                g = atoi(optarg);
                break;
            case 'b':
                bFlag = 1;
                b = atoi(optarg);
                break;
            case 't':
                tFlag = 1;
                type = optarg;
                break;
            case '?':
                printf("Unknown option: %c\n", optopt);
                break;
        }
    }

    int d;
    int t;
    int ot;

    if (input != NULL)
    {
        d = strlen(input);
        if (d >= 5 &&
            ((strcmp(&input[d - 4], ".bmp") == 0) ||
             (strcmp(&input[d - 4], ".ppm") == 0)) &&
            (access(input, F_OK) != -1))
        {
            printf("Opening file %s\n", input);
            FILE *fileImport = fopen(input, "r");
            struct Pixel *pixelBody = init_Pixel();
            int height = 0;
            int width = 0;

            if (strcmp(&input[d - 4], ".bmp") == 0)
            {
                struct BMP_Header *bmpheader = init_BMP_Header();
                struct DIB_Header *dibheader = init_DIB_Header();
                readBMPHeader(fileImport, bmpheader);
                readDIBHeader(fileImport, dibheader);
                width = dibheader->width;
                height = dibheader->height;
                readPixelsBMP(fileImport, pixelBody, width, height);
            }

            if (strcmp(&input[d - 4], ".ppm") == 0)
            {
                struct PPM_Header *ppmheader = init_PPM_Header();
                readPPMHeader(fileImport, ppmheader);
                width = ppmheader->width;
                height = ppmheader->height;
                readPixelsPPM(fileImport, pixelBody, width, height);
            }

            if (rFlag == 1 || bFlag == 1 || gFlag == 1)
            {
                colorShiftPixels(pixelBody, width, height, r, g, b);
            }

            if (oFlag == 1)
            {
                ot = strlen(output);
                if (ot == 0)
                {
                    output = strcat(output, "-copy");
                }
                FILE *fileExport = fopen(output, "w");
                if (tFlag == 1)
                {
                    t = strlen(type);
                    if (strcmp(&type[t - 3], "PPM") == 0)
                    {
                        struct PPM_Header *newppmheader = init_PPM_Header();
                        makePPMHeader(newppmheader, width, height);
                        writePPMHeader(fileExport, newppmheader);
                        writePixelsPPM(fileExport, pixelBody, width, height);
                    }
                    if (strcmp(&type[t - 3], "BMP") == 0)
                    {
                        struct BMP_Header *newbmpheader = init_BMP_Header();
                        struct DIB_Header *newdibheader = init_DIB_Header();

                        makeBMPHeader(newbmpheader, width, height);
                        makeDIBHeader(newdibheader, width, height);
                        writeBMPHeader(fileExport, newbmpheader);
                        writeDIBHeader(fileExport, newdibheader);
                        writePixelsBMP(fileExport, pixelBody, width, height);
                    }
                }
                else
                {
                    struct BMP_Header *newbmpheader = init_BMP_Header();
                    struct DIB_Header *newdibheader = init_DIB_Header();
                    makeBMPHeader(newbmpheader, width, height);
                    writeBMPHeader(fileExport, newbmpheader);
                    writeDIBHeader(fileExport, newdibheader);
                    writePixelsBMP(fileExport, pixelBody, width, height);
                }
            }
            
            fclose(fileImport);
        }
        else
        {
            exit(1);
        }
    }
    else
    {
        exit(1);
    }
    return 0;
}