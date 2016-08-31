package part12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Excercise12_18
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("input");
		try
		{
			String name= in.nextLine();
			AddPacage(name);
		}
		catch(Exception e)
		{
			System.out.println("123");
		}
		in.close();
	} 
	public static void AddPacage(String name) throws FileNotFoundException 
	{
		File file = new File(name);
		String[] f = file.list();
		for(int i=0;i<f.length;i++)
		{
			File temp = new File(name+"/"+f[i]) ;
			ArrayList<String> fil = new ArrayList<>();
			Scanner input = new Scanner(temp);
			while(input.hasNext())
			{
				fil.add(input.nextLine());
			}
			input.close();	
			PrintWriter write = new PrintWriter(temp);
			write.println("pachage chapter"+(i+1));
			for (String string : fil)
			{
				write.println(string);
			}
			write.close();
		}
	}
}
