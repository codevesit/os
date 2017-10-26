#include <stdio.h>
     #include <time.h>      /* may need to be  #include <sys/time.h> instead */
     int main()
     {
        long now, time();
        char *ctime();
        time (&now);
        printf("It is now %s\n", ctime (&now));
        exit (0);
     }
