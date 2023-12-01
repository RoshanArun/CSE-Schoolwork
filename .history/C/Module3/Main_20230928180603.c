
#include "BmpProcessor.h"
#include "PpmProcessor.h"
#include <getopt.h>
#include <unistd.h>

void print_usage()
{

  printf("USAGE:\n./MaImageProcessor -i <input_file_name(char*)> \n");
  printf("-o exports to output file, optional argument following to specify "
         "file name\n");
  printf("-r, -g, -b refers to color shift options, followed by an integer "
         "argument");
  printf("-t followed by options 'PPM' or 'BMP' to specify export file type");
}

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

  while ((opt = getopt(argc, argv, ":r:g:b::o:t:")) != -1)
  {
    int order = optind;

    switch (opt)
    {
    case 'o':
      oFlag = 1;
      outputfile = optarg;
      printf("output filename: %s\n", outputfile);
      break;
    case 'r':
      rFlag = 1;
      rvalue = atoi(argv[order]);
      // printf("r shift: %d", rvalue);
      break;
    case 'g':
      gFlag = 1;
      gvalue = atoi(argv[order]);
      // printf("g shift: %d", gvalue);
      break;
    case 'b':
      bFlag = 1;
      bvalue = atoi(argv[order]);
      // printf("b shift: %d", bvalue);
      break;
    case 't':
      tFlag = 1;
      type = optarg;
      // printf("type: %s\n", type);
      break;
    case ':':
      printf("You need to specify an option after -t. You must provide a value "
             "to -t <value>\n");
      break;
    case '?':
      printf("Invalid option. Options are either o, r, g, b or t followed by a "
             "valid argument\n");
      printf("Your selection was -%s\n", argv[order]);
      break;
    }
    order = order + 1;
  }
  // rintf("oFlag = %d, rFlag = %d, gFlag = %d, bFlag = %d, tFlag = %d\n",
  // oFlag, rFlag, gFlag, bFlag, tFlag); printf("Values:\nrshift = %d, gshift =
  // %d, bshift = %d\n", rvalue, gvalue, bvalue);
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

      // check to see what type of file it is (ppm/bmp) before performing
      // read/write actions

      // if bmp, performs read actions
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
      // if ppm, performs read actions
      if (strcmp(&inputfile[dflen - 4], ".ppm") == 0)
      {
        struct PPM_Header *ppmheader = init_PPM_Header();
        readPPMHeader(fileImport, ppmheader);
        width = ppmheader->width;
        height = ppmheader->height;
        readPixelsPPM(fileImport, pixelBody, width, height);
      }
      // if any of the r/g/b options are flagged
      if (rFlag == 1 || bFlag == 1 || gFlag == 1)
      {
        colorShiftPixels(pixelBody, width, height, rvalue, gvalue, bvalue);
      }
      // if output file name is flagged
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
        // if type if flagged
        if (tFlag == 1)
        {
          tlen = strlen(type);
          // if type == PPM
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

          printf("signature: %c%c\n", newbmpheader->signature[0],
                 newbmpheader->signature[1]);
          printf("size: %d\n", newbmpheader->filesize);
          printf("reserved1: %d\n", newbmpheader->reserved1);
          printf("reserved2: %d\n", newbmpheader->reserved2);
          printf("offset: %d\n", newbmpheader->pixelArrayOffset);
          makeDIBHeader(newdibheader, width, height);

          printf("size: %d\n", newdibheader->size);
          printf("width: %d\n", newdibheader->width);
          printf("height: %d\n", newdibheader->height);
          printf("planes:: %d\n", newdibheader->colorPlanes);
          printf("bits_per_pix: %d\n", newdibheader->bitsPerPixel);
          printf("compression: %d\n", newdibheader->compression);
          printf("image_size: %d\n", newdibheader->imageSize);
          printf("x_pix_per_m: %d\n", newdibheader->xResolution);
          printf("y_pix_per_m: %d\n", newdibheader->yResolution);
          printf("colors: %d\n", newdibheader->paletteColors);
          printf("impColors: %d\n", newdibheader->importantColors);

          writeBMPHeader(fileExport, newbmpheader);
          writeDIBHeader(fileExport, newdibheader);
          writePixelsBMP(fileExport, pixelBody, width, height);
          printf("no type selected - exported as .bmp\n");
        }
        printf("file export complete: %s\n", outputfile);
      }
      //
      printf("closing file %s\n", inputfile);
      fclose(fileImport);
    }
    else
    {
      printf("Data file has an invalid name or does not exist\n");
      print_usage();
      exit(1);
    }
  }
  else
  {
    printf("No data file name provided.  This is a required field\n");
    print_usage();
    exit(1);
  }

  return 0;
}