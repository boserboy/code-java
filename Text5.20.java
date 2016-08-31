import java.util.*;
class Prime
{
	public static void main(String []args0)
	{
		Scanner inpute = new Scanner(System.in);
		int num = inpute.nextInt();
		int sum = 0;
		for(int i =2;i<=num;i++)
		{
			if(isPrime(i)== true)
			{
				sum++;
			System.out.println(i);
		  }
		 
		} 
		System.out.println(sum);
	}
	public static boolean isPrime(int num)
	{
		boolean flag = true;
		for(int i=2;i<num;i++)
		{
			if(num%i == 0)
			{
				flag = false;
				break;
			}
		}
		return flag;
	} 
}