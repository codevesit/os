#include<dos.h>

void main()
{
 union REGS in, out;
 in.x.ax=0;
 int86(0x33,&in,&out);
 if (out.x.ax==0)
 {
  printf("Mouse not found");
  exit();
 }
 in.x.ax=1;
 int86(0x33,&in,&out);
 gotoxy(30,30);
 printf("Press any key to exit");

 while (!kbhit())
 {
 in.x.ax=3;
 int86(0x33,&in,&out);
 gotoxy(25,25);
 printf("Coordinates are (%d,%d)", out.x.cx,out.x.dx);

 }
 in.x.ax=2;
 int86(0x33,&in,&out);
}
