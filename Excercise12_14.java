package part12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Excercise12_14
{
	public static void main(String[] args)
	{
		System.out.println("«Î ‰»Î");
		Scanner in =null;
		try
		{
			in=new Scanner(System.in);
			String name=in.nextLine();
			sum(name);
		}
		catch(Exception e)
		{
			System.out.println("123");
		}
		in.close();
	}
	public static void sum(String name) throws FileNotFoundException 
	{
		File file = new File(name);
		Scanner input = new Scanner(file);
		double sum=0;
		int count=0;
		while(input.hasNextLine())
		{
			String str=input.next();
			System.out.println(str);
			sum+=oder(str);
			count++;
		}
		input.close();
		System.out.println("sun"+sum);
		System.out.println("Average"+sum/count);
		System.out.println(count);
	}
	public static double oder(String str)
	{
		double m=0,n=0;
		int a=0;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='/')
				a=i;
		}
		for(int i=0;i<a;i++)
		{
			m=m*10+(str.charAt(i)-'0');
		}
		for(int j=a+1;j<str.length();j++)
		{
			n=n*10+(str.charAt(j)-'0');
		}
		return m/n;
	}

}
