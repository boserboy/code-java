class Text26
{
	public static void main(String[]args)
	{
		double e=1.0,n=1;
		for(int i=1;i<=100000;i++)
		{
			if(i==1)
				n=1.0/i;
			else
				n=n/i;
		e+=n;
		if(i%10000==0)
			System.out.println(e);
		
		}
	}
}