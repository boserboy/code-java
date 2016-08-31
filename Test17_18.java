package part17;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Test17_18
{
	public static void main(String[] args) throws Exception
	{
		File file = new File("Exercise17_18.txt");
		DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
		int c = -1;
		while ((c = input.read()) != -1)
		{
			System.out.print(getBits(c));
		}
		input.close();
	}

	public static String getBits(int value)
	{
		return Integer.toBinaryString(value);
	}
}
