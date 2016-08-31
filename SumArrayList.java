package part11;

import java.util.ArrayList;
import java.util.Scanner;

public class SumArrayList
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Double> list =new ArrayList<>();
		int i=0;
		while(i<5)
		{
			list.add(in.nextDouble());
			i++;
		}
		System.out.println(SumArrayList.Sum(list));
		in.close();
	}
	public static double Sum(ArrayList<Double> list)		
	{
		double sum=0;
		for (Double double1 : list)
		{
			sum+=double1;
		}
		return sum;
	}

}
