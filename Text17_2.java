package part17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Text17_2
{
	public static void main(String[] args) 
	{
		try
		{
				File file = new File("Text17_2.dat");
				
				FileOutputStream output = new FileOutputStream(file);
				for(int i=0;i<100;i++)
				{
					int a = (int)(Math.random()*256);
					output.write(a);
				}
				output.close();
				FileInputStream input = new FileInputStream(file);
				int valu;
				while ((valu=input.read())!=-1)
				{
					System.out.print(valu);
		
				}
				input.close();
		}
		catch(Exception e)
		{
			System.out.print("123");
		}
				
	}

}
