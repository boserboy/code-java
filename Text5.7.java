class Text57
{
	public static void main(String[]args)
	{
		int begain = 10000;
		double end=begain*(1+0.05);
		for(int i=1;i<=10;i++)
		{
			if(i==1)
				end=begain*(1+0.05);
			else
				end=end*(1+0.05);
		}
		System.out.println(end);
		double sum=0;
		for(int j=1;j<=4;j++)
		{
			sum+=end;
			end=end*(1+0.05);
			
		}
		System.out.println(sum);
	}
}