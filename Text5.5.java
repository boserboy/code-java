class Text55
{
	public static void main(String[]args)
	{
		final double g =2.2;
		System.out.println("Ç§¿Ë     °õ     °õ     Ç§¿Ë");
		double m1,m2;
		int i=1,j=20;
		while(true)
		{
			if(i>199)
				break;
			m1=i*g;
			m2=j/g;
			System.out.printf("%3d     %.1f     %3d     %.2f",i,m1,j,m2);
			i=i+2;
			j=j+5;
			System.out.println();
		}
	}
}