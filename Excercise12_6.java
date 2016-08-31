package part12;

import java.util.Scanner;

public class Excercise12_6
{
	public static void main(String[] args)
	{
		Scanner in = null;
		boolean flag=true;
		System.out.println("请输入");
		do
		{
			try
			{
			in=new Scanner(System.in);
			System.out.println(hexToDecmal(in.nextLine()));
			flag=false;
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		while(flag);
		in.close();
	}
	public static int hexToDecmal(String hex) throws Exception
	{
		int decimalValue=0;
		for(int  i=0;i<hex.length();i++)
		{
			char ch = hex.charAt(i);
			decimalValue=decimalValue*16+hexCharToDecmal(ch);
		}
		return decimalValue;
	}
	public static int hexCharToDecmal(char ch) throws Exception
	{
		if(!((ch>='0'&&ch<'9')||(ch>='A'&&ch<='F')))
				throw new Exception("输入错误，不是16进制数，请重新输入");	
		else if(ch >= 'A' && ch <= 'F')
			return 10+ ch -'A';
		else 
			return ch;
	}

}
