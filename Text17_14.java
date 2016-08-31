package part17;

import java.io.*;

public class Text17_14
{
	public static void main(String[] args)
	{
		try
		{
			lock("text1.txt","text1.dat");
		}
		catch(Exception e)
		{
			System.out.println("123");
		}
	}
	public static void lock(String name1,String name2) throws Exception
	{
		File file1 = new File(name1);
		File file2 = new File(name2);
		try(DataInputStream input = new DataInputStream(new FileInputStream(file1));
				DataOutputStream out = new DataOutputStream(new FileOutputStream(file2)))
		{
			int a;
			while((a=input.read())!=-1)
				out.writeByte(a+5);
		}
		
	}

}
