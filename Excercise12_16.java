package part12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Excercise12_16
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		if(args.length!=3)
		{
			System.out.println("Usage : java sourcefile oldStr newStr");
			System.exit(1);
		}
		File sourcefile=new File(args[0]);
		if(!sourcefile.exists())
			System.out.println("文件不存在");
		System.exit(2);
		ArrayList<String> list =new ArrayList<>();
		try
		{
		    Scanner input = new Scanner(sourcefile);
		    while(input.hasNextLine())
		    {
		    	list.add(input.next());
		    }
		    input.close();
		    System.out.println(args[0]);
		    PrintWriter write = new PrintWriter(sourcefile);
		    for (String string : list)
		    {
				String str = string.replaceAll(args[1], args[2]);
				write.println(str);
			}
		    write.close();
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}
