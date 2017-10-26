#include<stdio.h>
#include<graphics.h>
#include<conio.h>
#include<dos.h>

void main()
{
	//clrscr();
	union REGS in,out;
	int gd=DETECT, gm;
	clrscr();
	initgraph(&gd, &gm, "C:\\TC\\BGI");
	in.x.ax=0;
	int86(0x33,&in,&out);
	if(out.x.ax==0)
	{
		printf("No Mouse Available.....");
		exit();
	}
	in.x.ax=1;
	int86(0x33,&in,&out);
	in.x.ax=3;
	int86(0x33,&in,&out);
	while(!kbhit())
{
	int86(0x33,&in,&out);
	if(out.x.bx == 1)
	{
		printf("Left Button\n");
	}
	if(out.x.bx == 2)
	{
		printf("Right Button\n");
	}
	if(out.x.bx == 3)
	{
		printf("Center Button\n");
	}
	delay(100);
}
	getch();
	closegraph();
}
