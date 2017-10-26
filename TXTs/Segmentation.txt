import java.util.Scanner;
class Segmentation
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of segments : ");
		int n = sc.nextInt(),table[][] = new int[n][2];
		for(int i=0;i<n;i++)
		{
			System.out.print("\nEnter segment "+(i+1)+" limit : ");
			table[i][0] = sc.nextInt();
			System.out.print("Enter segment "+(i+1)+" base address : ");
			table[i][1] = sc.nextInt();
		}
		System.out.println("\nSegment Table :\nIndex \tLimit \tBase Address");
		for(int i=0;i<n;i++)
			System.out.println(i+" \t"+table[i][0]+" \t"+table[i][1]);
		System.out.print("\nEnter Segment Number and Offset : ");
		int s = sc.nextInt(), o = sc.nextInt();
		if(table[s][0]<o)
			System.out.println("Invalid Address.");
		else
			System.out.println("Physical Address : "+(table[s][1]+o));
	}
}