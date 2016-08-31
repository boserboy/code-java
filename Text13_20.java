package part13;

public class Text13_20
{
public static void main(String[] args)
{
	equationRoots root1 = new equationRoots(1,2,3);
	root1.roots();
}
	
}
class equationRoots
{
	private double a,b,c;
	public equationRoots()
	{
		this(0,0,0);
	}
	public equationRoots(double a,double b,double c)
	{
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public double judge()
	{
		return b*b-4*a*c;
	}
	public void roots()
	{
		if(this.judge()<0)
		{
			double s=Math.pow(-this.judge(),0.5)/(2*a);
			System.out.println(-b/(2*a)+"+"+s+"i");
			System.out.println(-b/(2*a)+"-"+s+"i");
		}
		else
		{
			if(this.judge()==0)
				System.out.println(-b/(2*a));
			else
			{
				System.out.println((-b-Math.pow(this.judge(), 0.5))/(2*a));
				System.out.println((-b+Math.pow(this.judge(), 0.5))/(2*a));
			}
		}
	}
}