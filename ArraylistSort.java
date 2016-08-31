package part11;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.Scanner;

public class ArraylistSort
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list =new ArrayList<>();
		int i=0;
		while(i<5)
		{
			list.add(in.nextInt());
			i++;
		}
		// Collections.sort(list);
		
		ArraylistSort.sort(list);
		System.out.println(list);
		in.close();
	}
	public static void sort(ArrayList<Integer> list)
	{
		for(int i=0;i<list.size();i++)
		{
			for(int j=0;j<(list.size()-i-1);j++)
			{
				if(list.get(j)>list.get(j+1))
				{
				int t=list.get(j);
				list.set(j, list.get(j+1));
				list.set(j+1, t);
				}	
			}
		}
	//	System.out.println(list.toString());
	}
}
