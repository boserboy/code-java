package part11;

import java.util.ArrayList;
import java.util.Scanner;

public class BigestRowandColumn
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the array size n : ");
		int n = in.nextInt();
		int[][] radom = new int[n][n];
		for (int row = 0; row < radom.length; row++)
		{
			for (int column = 0; column < radom[row].length; column++)
			{
				radom[row][column] = (int) (Math.random() * 2);
			}
		}
		for (int row = 0; row < radom.length; row++)
		{
			for (int column = 0; column < radom[row].length; column++)
			{
				System.out.print(radom[row][column]);
			}
			System.out.println();
		}
		BigestRowandColumn.bigest(radom);
		in.close();
	}

	public static void bigest(int[][] radom)
	{
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		for (int row = 0; row < radom.length; row++)
		{
			int count1 = 0;
			for (int column = 0; column < radom[row].length; column++)
			{
				if (radom[row][column] == 1)
					count1++;
			}
			list1.add(count1);
		}
		//ÐÐÁÐ×ª»»
		for (int row = 0; row < radom.length; row++)
		{
			
			for (int column = 0; column < radom[row].length; column++)
			{	
			radom[row][column]=radom[column][row];
						
			}
		}
		for (int row= 0; row < radom.length; row++)
		{
			int count2 = 0;
			for (int column = 0; column < radom[row].length; column++)
			{
				if (radom[row][column] == 1)
					count2++;
			}
			list2.add(count2);
		}
		int max1 = 0;
		for (int i = 0; i < list1.size(); i++)
		{
			if (list1.get(i) > max1)
				max1 = list1.get(i);
		}
		int max2 = 0;
		for (int i = 0; i < list2.size(); i++)
		{
			if (list2.get(i) > max2)
				max2 = list1.get(i);
		}
		
		
		  System.out.print("The largest row index : "); 
		  for(int i=0;i<list1.size();i++)
		  {
			  if(list1.get(i)==max1)
				  System.out.println(i+" ");
		  }
		  
		 System.out.print("The largest column index : "); 
		 for(int i=0;i<list2.size();i++)
		  {
			  if(list2.get(i)==max1)
				  System.out.println(i+" ");
		  }
		
	}
}
