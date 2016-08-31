package part13;

import java.util.*;

public class Text13_2
{
	public static void main(String[] args)
	{
		ArrayList<Number> list = new ArrayList<>();
		for(int i=0;i<10;i++)
			list.add(i);
		shufle(list);
		System.out.println(list);
		
	}
	public static void shufle(ArrayList<Number> list)
	{
		int size = list.size();
		Random random = new Random();
		for(int i=0;i<size;i++)
		{
			int randompos = random.nextInt(size);
			Number t=list.get(i);
			
			list.set(i, list.get(randompos));
			
			list.set(randompos, t);
		}
	}

}
