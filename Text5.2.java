class Text52
{
public static void main(String[]args)
{
	int num,sum=0;
	for(int i=0;i<10;i++)
	{
		num=(int)(Math.random()*16);
		System.out.println(num);
		sum+=num;
	}
	System.out.println(sum);
}
}