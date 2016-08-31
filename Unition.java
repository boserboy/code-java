package part11;

import java.util.ArrayList;

public class Unition
{
	public static void main(String[] args)
	{
		ArrayList<Integer> list1 = new ArrayList<> ();
		ArrayList<Integer> list2 = new ArrayList<> ();
		list1.add(4);
		list1.add(3);
		list1.add(3);
		list2.add(4);
		list2.add(3);
		list2.add(3);
		System.out.println(list1);
		System.out.println(Unition.unition(list1, list2).toString());

	}
	public static ArrayList<Integer> unition(ArrayList<Integer> list1,ArrayList<Integer> list2)
	{
		for(int i=0;i<list1.size();i++)
		{
			list2.add(list1.get(i));
		}
		return list2;
	}
}
