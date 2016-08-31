package part11;

import java.util.Scanner;

public class Text15
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("«Î ‰»În £∫");
		int n=in.nextInt();
		double[] x = new double[n];
		double[] y = new double[n];
		for(int i =0;i<x.length&&i<y.length;i++)
		{
			x[i]=in.nextDouble();
			y[i]=in.nextDouble();
		}
		System.out.println( Area(x,y));
		in.close();
	}
	public static double Area(double[] x,double[] y)
	{
		double s=0;
		for(int i=0;i<x.length&&i<y.length;i++)
		{
			if(i==x.length-1)
			{
				s+=(x[i]+x[0])*(y[i]-y[0])/2;
			}
			else
			{
				s+=(x[i]+x[i+1])*(y[i]-y[i+1])/2;
			}
		}
		return s;
	}

}

