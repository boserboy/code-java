package part12;

import java.util.Scanner;

public class Excercise12_2
{
	public static void main(String[] args) 
	{
		Scanner in = null;
		boolean flag=true;
		while(flag)
		{
			in=new Scanner(System.in);
			try
			{
				int a = in.nextInt();
				int b = in.nextInt();
				System.out.println(a+b);
				flag=false;
			}
			catch(Exception e)
			{
				System.out.println("输入错误，重新输入");
			}
		 }
		  in.close();
	
		
	}

}
