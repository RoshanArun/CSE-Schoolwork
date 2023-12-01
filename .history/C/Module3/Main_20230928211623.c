
#include "BmpProcessor.h"
#include "PpmProcessor.h"
#include <getopt.h>
#include <unistd.h>



int main(int argc, char *argv[])
{

    char *inputfile;
    char *outputfile;
    char *type;

    int opt;

    int rvalue = 0;
    int gvalue = 0;
    int bvalue = 0;

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
                inputfile = optarg;
                printf("filename: %s\n", inputfile);
                break;
            case ':':
                printf("Please enter a file name\n");
                break;
            case 'o':
                oFlag = 1;
                outputfile = optarg;
                printf("output filename: %s\n", outputfile);
                break;
            case 'r':
                rFlag = 1;
                rvalue = atoi(optarg);
                break;
            case 'g':
                gFlag = 1;
                gvalue = atoi(optarg);
                break;
            case 'b':
                bFlag = 1;
                bvalue = atoi(optarg);
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

    for (; optind < argc; optind++)
    {
        printf("Given extra arguments: %s\n", argv[optind]);
    }

    int dflen;
    int tlen;
    int otlen;

    // If inputfile is valid
    if (inputfile != NULL)
    {
        dflen = strlen(inputfile);
        if (dflen >= 5 &&
            ((strcmp(&inputfile[dflen - 4], ".bmp") == 0) ||
             (strcmp(&inputfile[dflen - 4], ".ppm") == 0)) &&
            (access(inputfile, F_OK) != -1))
        {
            printf("Opening file %s\n", inputfile);
            FILE *fileImport = fopen(inputfile, "r");
            struct Pixel *pixelBody = init_Pixel();
            int height = 0;
            int width = 0;

            if (strcmp(&inputfile[dflen - 4], ".bmp") == 0)
            {
                struct BMP_Header *bmpheader = init_BMP_Header();
                struct DIB_Header *dibheader = init_DIB_Header();
                readBMPHeader(fileImport, bmpheader);
                readDIBHeader(fileImport, dibheader);
                width = dibheader->width;
                height = dibheader->height;
                readPixelsBMP(fileImport, pixelBody, width, height);
            }

            if (strcmp(&inputfile[dflen - 4], ".ppm") == 0)
            {
                struct PPM_Header *ppmheader = init_PPM_Header();
                readPPMHeader(fileImport, ppmheader);
                width = ppmheader->width;
                height = ppmheader->height;
                readPixelsPPM(fileImport, pixelBody, width, height);
            }

            if (rFlag == 1 || bFlag == 1 || gFlag == 1)
            {
                colorShiftPixels(pixelBody, width, height, rvalue, gvalue, bvalue);
            }

            if (oFlag == 1)
            {
                printf("beginning file export\n");
                otlen = strlen(outputfile);
                printf("output filename: %s\nlength: %d\n", outputfile, otlen);
                if (otlen == 0)
                {
                    outputfile = strcat(inputfile, "-copy");
                    printf("output filename: %s\n", outputfile);
                }
                FILE *fileExport = fopen(outputfile, "w");
                if (tFlag == 1)
                {
                    tlen = strlen(type);
                    if (strcmp(&type[tlen - 3], "PPM") == 0)
                    {
                        struct PPM_Header *newppmheader = init_PPM_Header();
                        makePPMHeader(newppmheader, width, height);
                        writePPMHeader(fileExport, newppmheader);
                        writePixelsPPM(fileExport, pixelBody, width, height);
                        printf("exported as %s.ppm\n", outputfile);
                    }
                    // if type == BMP
                    if (strcmp(&type[tlen - 3], "BMP") == 0)
                    {
                        struct BMP_Header *newbmpheader = init_BMP_Header();
                        struct DIB_Header *newdibheader = init_DIB_Header();

                        makeBMPHeader(newbmpheader, width, height);
                        makeDIBHeader(newdibheader, width, height);
                        writeBMPHeader(fileExport, newbmpheader);
                        writeDIBHeader(fileExport, newdibheader);
                        writePixelsBMP(fileExport, pixelBody, width, height);
                        printf("exported as %s.bmp\n", outputfile);
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
            //
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