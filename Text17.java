package part11;

import java.util.ArrayList;
import java.util.Scanner;

public class Text17
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> s = new ArrayList<> ();
		ArrayList<Integer> w = new ArrayList<> ();
		System.out.println("Enter M");
		int m=in.nextInt();
		int q=m;
		int i=2;
		while(m!=1)
		{
			
			while(m%i==0)
			{
				s.add(i);
				m=m/i;
			}
			i++;
		}
		System.out.println(s.toString());
		int count1=0;
		for(int j=0;j<s.size();j++)
		{
			int count=0;
			for(int k=count1;k<s.size();k++)
			{
				if(s.get(j).equals(s.get(k)))
					count++;
			}
			if(count%2!=0)
				w.add(s.get(j));
			count1+=count;
		}
		System.out.println(w.toString());
		int sum=1;
		for (Integer integer : w)
		{
			sum*=integer;
		}
		System.out.println("N "+sum+"  M*n "+sum*q);
		in.close();
	}
	

}
