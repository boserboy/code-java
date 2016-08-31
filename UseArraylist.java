package part11;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class UseArraylist
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Loan> loan = new ArrayList<> ();
		System.out.println("Loan");
		for(int i=0;i<2;i++)
		{
			System.out.println("input double annualInterestRate,int numberOfYears,double loanAmount");
			double annualInterestRate=in.nextDouble();
			int numberOfYears=in.nextInt();
			double loanAmount=in.nextDouble();
			loan.add(new Loan(annualInterestRate,numberOfYears,loanAmount));
		}
		for (Loan loan2 : loan)
		{
			System.out.println(loan2.toString());
		}
		ArrayList<Date> date= new  ArrayList<> ();
		System.out.println("Date");
		date.add(new Date());
		date.add(new Date());
		System.out.println(date.toString());
		ArrayList<String> string = new ArrayList<> ();
		System.out.println("String");
		string.add("123");
		string.add("453");
		for(Iterator<String> it=string.iterator();it.hasNext();)
		{
			System.out.println(it.next().toString());
		}
		ArrayList<Circle> circle = new ArrayList<> ();
		System.out.println("Circle");
		circle.add(new Circle(3.25));
		circle.add(new Circle(4));
		System.out.println(circle);
		
		in.close();
	}

}
class Loan
{
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;
	public Loan()
	{
		this(2.5,1,1000);
	}
	public Loan(double annualInterestRate,int numberOfYears,double loanAmount)
	{
		this.annualInterestRate=annualInterestRate;
		this.numberOfYears=numberOfYears;
		this.loanAmount=loanAmount;
		this.loanDate=new java.util.Date();
	}
	public double getAnnualInterestRate()
	{
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate)
	{
		this.annualInterestRate = annualInterestRate;
	}
	public int getNumberOfYears()
	{
		return numberOfYears;
	}
	public void setNumberOfYears(int numberOfYears)
	{
		this.numberOfYears = numberOfYears;
	}
	public double getLoanAmount()
	{
		return loanAmount;
	}
	public java.util.Date getLoanDate()
	{
		return loanDate;
	}
	public void setLoanAmount(double loanAmount)
	{
		this.loanAmount = loanAmount;
	}
	public double gerMonthlyPayment()
	{
		double monthluInterestRate = annualInterestRate / 1200;
		double monthlyPayment =  loanAmount *  monthluInterestRate / (1-(1/Math.pow(1+monthluInterestRate, numberOfYears * 12)));
		return monthlyPayment;
	}
	public double getTotalPayment()
	{
		double totalPayment = gerMonthlyPayment() * numberOfYears * 12;
		return totalPayment;
	}
	public String toString()
	{
		return "贷款额 "+this.loanAmount+" 年利率  "+this.annualInterestRate+" 贷款年数  "+this.numberOfYears+"  贷款日期 "+this.getLoanDate()+"  月支付"+this.gerMonthlyPayment()+"  总支付"+this.getTotalPayment();
	}
}
class Circle
{
	private double radius=1;
	public Circle()
	{
		
	}
	public Circle(double radius)
	{
		this.radius=radius;
	}
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	public double getPerimeter()
	{
		return radius*2*Math.PI;
	}
	public double getArea()
	{
		return radius*radius*Math.PI;
	}
	public String toString()
	{
		return "Area "+this.getArea()+ " Perimeter "+this.getPerimeter()+" Radius "+radius;
	}
}

