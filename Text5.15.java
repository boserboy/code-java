import java.util.*;
class Text15
{
	public static void main(String[]args)
	{
		int count=0;
		Scanner in = new Scanner(System.in);
		String ar=in.nextLine();
		char ch1 = ar.charAt(0);
		String ar1=in.nextLine();
		char ch2 = ar1.charAt(0);
		for(char ch=ch1;ch<=ch2;ch++)
		{
		  System.out.printf("%c ",ch);
		  count++;
		  if(count%5==0)
		  	System.out.println();
		}
	}
}