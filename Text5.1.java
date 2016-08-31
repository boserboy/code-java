import java.util.*;
class Text51

{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		double num, sum=0 ,average;
		int count1=0 ,count2=0;
		while(true)
		{
			num=input.nextDouble();
			sum+=num;
			if(num==0)
				break;
			else if(num>0)
				count1++;
			else
				count2++;
			
		}
		average=sum/(count1+count2);
		System.out.println(sum);
		System.out.println(average);
		System.out.println("positives"+count1);
		System.out.println("nagatives"+count2);
	}
}
