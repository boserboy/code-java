package part11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DisorderArrayList
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer> ();
		while(true)
		{
			int a = in.nextInt();
			if(a==0)
				break;
			list.add(a);
		}
		DisorderArrayList.shuffle(list);
		in.close();
		
	}
	public static void shuffle(ArrayList<Integer> list)
	{
		 Collections.shuffle(list);
		 for (Integer integer : list)
		{
			System.out.println(integer.toString());
		}
	}
}
