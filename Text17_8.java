package part17;

import java.io.*;

public class Text17_8
{
	public static void main(String[] args) throws Exception
	{
		int count=0;
		File file = new File("Text17_8.data");
		if(file.exists())
		{
			try(DataInputStream input = new DataInputStream(new FileInputStream(file)))
			{
				count=input.readInt();
			}
			try(DataOutputStream out = new DataOutputStream(new FileOutputStream(file)))
			{
				out.writeInt(++count);
			}
		}
		else
		{
			try(DataOutputStream out = new DataOutputStream(new FileOutputStream(file)))
			{
				out.writeInt(++count);
			}
			
		}
	}

}
