import java.util.Scanner;
class Paging
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of pages : ");
		int n = sc.nextInt();
		System.out.print("Enter page size : ");
		int size = sc.nextInt();
		System.out.println("\nPage Table : \nIndex \tBase Address");
		for(int i=0;i<n;i++)
			System.out.println(i+" \t"+(i*size));
		System.out.print("\nEnter Page and Offset : ");
		int p = sc.nextInt(), o = sc.nextInt();
		if(o>size)
			System.out.print("Invalid Address.");
		else
			System.out.println("\nPhysical Address : "+((p*size)+o));
	}
}
