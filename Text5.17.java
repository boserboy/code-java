import java.util.*;
class Text17
{
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of lines : ");
		int line = in.nextInt();
		for(int i=1;i<=line;i++)
		{
			for(int j=1;j<=line-i;j++)
				System.out.printf("   ");
			for(int k=i;k>=1;k--)
				System.out.printf("%3d",k);
			for(int m=2;m<=i;m++)
			  System.out.printf("%3d",m);
		System.out.println();
		}
	}
}