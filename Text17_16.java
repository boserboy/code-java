package part17;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Text17_16
{
	public static void main(String[] args)
	{
		try
		{
			total("text.txt");
		}
		catch(Exception e)
		{
			System.out.println("123");
		}
		
	}
	public static void total(String name) throws Exception
	{
		File file  = new File(name);
		ArrayList<Character> list = new ArrayList<>();
		try(DataInputStream input = new DataInputStream(new FileInputStream(file)))
		{
			int n;
			while((n = input.read())!=-1)
			{
				list.add((char) n);		
			}
		
		}
		ArrayList<Character> list1 = new ArrayList<>();
		for ( Character character : list)
		{
			list1.add(character);
		}
		int count;
		for(int i=0;i<list.size();i++)
		{
			for(int j=i;j<list.size();j++)
			{
				if(list.get(i).equals(list.get(j))&&i!=j)
					list.remove(j);
					
			}
		}
		System.out.println(list1);
		for(int i=0;i<list.size();i++)
		{
			count=0;
			for(int j=0;j<list1.size();j++)
			{
				if(list.get(i).equals(list1.get(j)))
					count++;
			}
			System.out.println(list.get(i)+"  "+count);
		}
	}

}
