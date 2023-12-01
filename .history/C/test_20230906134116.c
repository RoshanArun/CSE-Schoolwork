struct point_2d {
    int x;
    int y;
    Color col;
};

void main() {
  point_2d* data[5];
  for(int i = 0; i < 5; i++) {
    point_2d tmp;
    tmp.x = i;
    tmp.y = i * i;
    data[i] = &tmp;
  }
  for(int i = 0; i < 5; i++)
    printf("Point #%d: %d, %d", i, data[i]->x, data[i]->y);
}