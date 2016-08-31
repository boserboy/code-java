package part12;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Excercise12_22
{
	public static void main(String[] args) throws Exception 
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
		String[] file=sourcefile.list();
		for(int i=0;i<file.length;i++)
		{
			File temp = new File(sourcefile+"/"+file[i]) ;
			ArrayList<String> list =new ArrayList<>();
			try
			{
			    Scanner input = new Scanner(temp);
			    while(input.hasNextLine())
			    {
			    	list.add(input.next());
			    }
			    input.close();
			    PrintWriter write = new PrintWriter(temp);
			    for (String string : list)
			    {
					String str = string.replaceAll(args[1], args[2]);
					write.println(str);
				}
			    write.close();
			}
			catch(Exception e)
			{
				throw new Exception("错误");
			}
		}
	}

}
