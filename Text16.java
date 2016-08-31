package part11;

import java.util.ArrayList;
import java.util.Scanner;

public class Text16
{
	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		int num1=(int)(Math.random()*10);
		int num2=(int)(Math.random()*10);
		System.out.println(num1+"+"+num2+" =  ?");
		int answer = in.nextInt();
		while((num1+num2)!=answer)
		{
			int flag=0;
			for (Integer integer : a)
			{
				if(integer==answer)
				{
					System.out.println("you already entered "+answer);
					flag=1;
				}
			}
			a.add(answer);
			if(flag==0)
				System.out.println("wrong");
			System.out.println("Try again.  "+num1+"+"+num2+" =  ?");
			answer=in.nextInt();
		}
		System.out.println("You got it"); 
		
		in.close();
	}
	

}
