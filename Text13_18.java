package part13;

import java.math.BigDecimal;

public class Text13_18  
{
	public static void main(String[] args)
	{
		BigDecimal sum = new BigDecimal("0");
		for(int i=1;i<100;i++)
		{
			int j=i+1;
			BigDecimal numerator=new BigDecimal(j);
			BigDecimal denoninator=new BigDecimal(i);
			Rational ra = new Rational(numerator, denoninator);
			sum=sum.add(ra.dicide());
		}
		System.out.println(sum);
	}
	
}
class Rational
{
	private BigDecimal numerator=new BigDecimal("0");
	private BigDecimal denoninator=new BigDecimal("1");
	public Rational()
	{
	}
	public Rational(BigDecimal numerator,BigDecimal denoninator)
	{
		this.numerator=numerator;
		this.denoninator=denoninator;
	}
	public BigDecimal dicide()
	{
		return this.denoninator.divide(this.numerator,20,BigDecimal.ROUND_UP);
	}
}
