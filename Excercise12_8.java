package part12;

import java.util.Scanner;

@SuppressWarnings("serial")
public class Excercise12_8 extends Exception
{
	public static void main(String[] args) 
	{
		in = new Scanner(System.in);
		String hex = in.nextLine();
		try
		{
			for(int  i=0;i<hex.length();i++)
			{
				if(!((hex.charAt(i)>='0'&&hex.charAt(i)<'9')||(hex.charAt(i)>='A'&&hex.charAt(i)<='F')))
				{
					throw new  Excercise12_8(hex);
				}
			}
		}
		catch(Excercise12_8 e)
		{
			System.out.println(e.getMesage());
		}
	}
	private String hex;
	private static Scanner in;
	public Excercise12_8(String hex)
	{
		super("invalid number"+hex);
		this.hex=hex;
	}
	
	public String getHex()
	{
		return hex;
	}

	public String getMesage()
	{
		return super.getMessage();
	}
	

}
