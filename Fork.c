#include<stdio.h>
#include<fcntl.h>
#include<stdlib.h>
#include <sys/types.h>     /* defines types used by sys/stat.h */
     #include <unistd.h> 
void main() 
{ int return_value;
		 printf("Forking process\n");
		 fork();
		 printf("The process id is %d and return value is %d\n",
			getpid(), return_value);
}
