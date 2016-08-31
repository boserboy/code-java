package part11;

import java.util.ArrayList;
import java.util.Scanner;

public class BigestArraylist
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<>();
		System.out.println("ÊäÈëArraylist ÒÔ0½áÊø ");
		while(true)
		{
			int m=in.nextInt();
			list.add(m);
			if(m==0)
				break;
		}
	System.out.println(BigestArraylist.max(list));
		in.close();
	}
	public static Integer max(ArrayList<Integer> list)
	{
		Integer max=list.get(list.size()-1);
		for (Integer integer : list)
		{
			if(integer>max)
				max=integer;
				
		}
		return max;
	}

}
