package part12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Excercise12_28
{
	public static void main(String[] args)
	{
		Scanner in =new Scanner(System.in);
		String name= in.nextLine();
		try
		{
			rename(name);
		}
		catch(Exception e)
		{
			System.out.println("´íÎó");
		}
		in.close();
	}
	public static void rename(String name) throws FileNotFoundException
	{
		File file = new File(name);
		String[] fi = file.list();
		for(int i=0;i<file.length();i++)
		{
			int index=0;
			for(int j=0;j<fi[i].length();j++)
			{
				if(fi[i].charAt(j)=='_')
				{
				 index = j;
				 break;
				}
				
			}
			int num=0;
			for(int j=0;j<index;j++)
			{
				if(fi[i].charAt(j)>='1'&&fi[i].charAt(j)<='9')
				{
					num=num*10+(fi[i].charAt(j)-'0');
				}
			}
			if(num>=1&&num<=9)
			{
				ArrayList<String> list = new ArrayList<> ();
				File file1=new File(name+"/"+fi[i]);
				Scanner input = new Scanner(file1);
				while(input.hasNext())
				{
					list.add(input.nextLine());
				}
				input.close();
				char[] ch = new char[fi[i].length()+1]; 
				for(int m=0;m<fi[i].length();m++)
				{
					ch[m]=fi[i].charAt(m);
				}
				for(int n=ch.length-1;n>index;n--)
				{
					
					char t=ch[n-1];
					ch[n]=t;	
				}
				ch[index]='0';
				String newname = ch.toString();
				if(file1.delete())
				{
				
					File file2= new File(name+"/"+newname);
					file2.mkdirs();
					PrintWriter write = new PrintWriter(file2);
					for(int j=1;j<list.size();j++)
					{
						write.println(list.get(j));
					}
					write.close();
				}
			}
		}
	}

}
