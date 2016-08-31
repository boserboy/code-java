package part12;

import java.io.File;
import java.util.*;

public class Excercise12_26
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("ÊäÈëÄ¿Â¼");
		String direct = in.nextLine();
		File file = new File(direct);
		if(file.exists())
			System.out.println("Directory already exists");
		else
		{
			file.mkdirs();
			System.out.println("Directory created successfully");
		}
		in.close();
	}
	
	

}
