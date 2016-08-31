package part17;

import java.io.*;

public class Text17_10
{
	public static void main(String[] args)
	{
		try
		{
			int num=0;
			for(int i=0;i<args[1].length();i++)
			{
				num=num*10+args[1].charAt(i)-'0';
			}
			Device(args[0],num);
		}
		catch(Exception e)
		{
			System.out.println("error");
		}
	}
	public static void Device(String name,int piece) throws Exception
	{
		File file = new File(name);
		int n = (int)(file.length()/piece);
		int m = (int)(file.length()%piece);
		try(DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(file))))
		{
			for(int i=0;i<n;i++)
			{
				byte[] b = new byte[n];
				input.read(b);
				int q = i+1;
				DataOutputStream out = new DataOutputStream(new FileOutputStream(file+"."+q));
				out.write(b);
				out.close();
			}
			if(m!=0)
			{
				byte[] c = new byte[m];
				input.read(c);
				int p = n+1;
				DataOutputStream out = new DataOutputStream(new FileOutputStream(file+"."+p));
				out.write(c);
				out.close();
			}
			
		}
		
	}

}
