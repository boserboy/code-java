package part12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Excercise12_12
{
	public static void main(String[] args) 
	{
		Scanner in=null;
		System.out.println("file name");
	
		try
		{
			in=new Scanner(System.in);
			String name=in.nextLine();
			codeStyle(name);
		}
		catch(Exception e)
		{
			System.out.println("123");
		}
		in.close();
	}
	public static void codeStyle(String name) throws FileNotFoundException
	{
		File file = new File(name);
		Scanner input = new Scanner(file);
		ArrayList<String> list = new ArrayList<>();
		while(input.hasNext())
		{
	
			list.add(input.nextLine());
		}
		input.close();
		PrintWriter write = new PrintWriter(new File(name));
		for(int i=0;i<(list.size()-1);i++)
		{
			boolean flag=false;
			for(int j=0;j<(list.get(i+1)).length();j++)
			{
				if((list.get(i+1)).charAt(j)=='{')
					flag=true;
			}
			if(flag)
			{
				write.print(list.get(i));
			}
			else 
				write.println(list.get(i));
		}
		write.println(list.get(list.size()-1));
		write.close();
	}

}
