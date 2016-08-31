package part12;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Excercise12_20
{
	public static void main(String[] args) throws Exception
	{
		
		System.out.println("input");
		try
		{
			deletPacage(args[0]);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public static void deletPacage(String name) throws Exception 
	{
		File file = new File(name);
		String[] f = file.list();
		for(int i=0;i<f.length;i++)
		{
			File temp = new File(name+"/"+f[i]) ;
			ArrayList<String> fil = new ArrayList<>();
			try
			{
				Scanner input = new Scanner(temp);
				while(input.hasNext())
				{
					fil.add(input.nextLine());
				}
				input.close();	
				PrintWriter write = new PrintWriter(temp);
				for(int j=1;j<fil.size();j++)
				{
					write.println(fil.get(j));
				}
				write.close();
			}
			catch(Exception e)
			{
				throw new Exception("´íÎó");
			}
		}
	}
}
