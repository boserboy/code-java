package part12;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Excercise12_30
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		try
		{
			String name=in.nextLine();
			numberchar(name);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		in.close();
	}
	public static void numberchar(String name) throws Exception
	{
		File file= new File(name);
		if(!file.exists())
			throw new Exception("文件不存在");
		Scanner input = new Scanner(file);
		ArrayList<String> list = new ArrayList<>();
		while(input.hasNextLine())
		{
			list.add(input.nextLine());
		}
		input.close();
		
		char ch1='A';
		for(char ch='a';ch<='z';ch++)
		{
			int count1=0,count2=0;
			for(int i=0;i<list.size();i++)
			{
				for(int j=0;j<list.get(i).length();j++)
				{
					if(list.get(i).charAt(j)==ch)
						count1++;
					if(list.get(i).charAt(j)==ch1)
						count2++;
				}
			}
			
			System.out.println("number of "+ch+count1);
			System.out.println("number of "+ch1+count2);
			ch1++;
		}
	}
	

}
