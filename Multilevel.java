import java.util.Scanner;
class Multilevel
{	public static void main(String args[])
{	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the number of processes : ");
	int n = sc.nextInt(),a[] = new int[n],w[] = new int[n],t[] = new int[n],i,q8[][]= new int[n][2],q16[][] = new int[n][2],n8=0,n16=0,fcfs[][] = new int[n][2],nfcfs=0;
	System.out.print("Enter the Burst Time for\n");
	for(i=0;i<n;i++)
	{	
		System.out.print("Process "+(i+1)+" : ");
		a[i]=sc.nextInt();
		if(a[i]<=8)
			{
				q8[n8][0]=i+1;
				q8[n8++][1]=a[i];
			}
		else if(a[i]<16)
			{	
				q16[n16][0]=i+1;
				q16[n16++][1]=a[i];
			}
		else
			{
				fcfs[nfcfs][0]=i+1;
				fcfs[nfcfs++][1]=a[i];
			}
	}
	System.out.println("\nQuantum 8 Queue - ");
	if(n8==0)
		System.out.print("Queue Empty");
	else
		for(i=0;i<n8;i++)
			System.out.print("Process : "+q8[i][0]+" \t Burst Time : "+q8[i][1]+"\n");
	System.out.println("\nQuantum 16 Queue - ");
	if(n16==0)
		System.out.print("Queue Empty");
	else
	for(i=0;i<n16;i++)
		System.out.print("Process : "+q16[i][0]+" \t Burst Time : "+q16[i][1]+"\n");
	System.out.println("\nFCFS Queue - ");
	if(nfcfs==0)
		System.out.print("Queue Empty");
	else
	for(i=0;i<nfcfs;i++)
		System.out.print("Process : "+fcfs[i][0]+" \t Burst Time : "+fcfs[i][1]+"\n");
	}	}
