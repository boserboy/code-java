package part12;

import java.util.Scanner;

public class Bug
{
	public static void main(String[] args)
	{
		Scanner in = null;
		for(int i=0;i<5;i++)
		{
			in=new Scanner(System.in);
			try
			{
				int a = in.nextInt();
				int b = in.nextInt();
				System.out.println(a/b);
			}
			catch(Exception w)
			{
				System.out.println("error");
			}
			
		}
		in.close();
		
	}
}
