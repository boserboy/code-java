package part17;
import java.io.*;
import java.util.*;

public class Text17_4
{
	public static void main(String[] args)
	{
		try
		{
		translat(args[0],args[1]);
		}
		catch(Exception e)
		{
			
		}
	}
	public static void translat(String name1,String name2) throws Exception
	{
		File file1 = new File(name1);
		File file2 = new File(name2);
		try(Scanner input = new Scanner(file1);DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));)
		{
			while(input.hasNext())
			{
				String str=input.nextLine();
				output.writeUTF(str);
				
			}
		}
		System.out.println(file1.length());
		System.out.println(file2.length());
	   
	}

}
