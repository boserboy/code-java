package part11;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicate
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
		RemoveDuplicate.removeDouplicate(list);
		System.out.println(list.toString());
		in.close();
	}
	public static void removeDouplicate(ArrayList<Integer> list)
	{
		for(int i=0;i<list.size();i++)
		{
			for(int j=list.size()-1;j>i;j--)
			{
				if(list.get(i).equals(list.get(j)))
				{
					list.remove(j);
				}
			}
		}
		
	}

}
