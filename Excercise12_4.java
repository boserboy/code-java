package part12;

import java.util.Scanner;

public class Excercise12_4
{
	public static void main(String[] args)
	{
		Scanner in =null;
		boolean flag=true;
		System.out.println("input");
		while(flag)
		{
			in = new Scanner(System.in);
			try
			{
				double annualInterestRate = in.nextDouble();
				int numberOfYears = in.nextInt();
				double loanAmount = in.nextDouble();
				Loan loan = new Loan(annualInterestRate,numberOfYears,loanAmount);
				System.out.println(loan.toString());
				flag=false;
			}
			catch(Exception e)
			{
				if(e.equals(null))
					System.out.println(e.getMessage());
				else
					System.out.println("ȷ������������ȷ");
			}
			
		}
		in.close();
	}
}
class Loan 
{
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;
	public Loan() throws Exception
	{
		this(2.5,1,1000);
	}
	public Loan(double annualInterestRate,int numberOfYears,double loanAmount) throws Exception
	{
		if(annualInterestRate<=0)
			throw new Exception("���ʲ���С���㣬��������");
		else if(loanAmount<=0)
			throw new Exception("������С���㣬��������");
		else if(numberOfYears<=0)
			throw new Exception("������������С���㣬��������");
		else
		{
		this.annualInterestRate=annualInterestRate;
		this.numberOfYears=numberOfYears;
		this.loanAmount=loanAmount;
		this.loanDate=new java.util.Date();
		}
	}
	public double getAnnualInterestRate()
	{
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) throws Exception
	{
		if(annualInterestRate>0)
			this.annualInterestRate = annualInterestRate;
		else
			throw new Exception("���ʲ���С���㣬��������");
	}
	public int getNumberOfYears()
	{
		return numberOfYears;
	}
	public void setNumberOfYears(int numberOfYears) throws Exception
	{
		if( numberOfYears>0)
			this.numberOfYears = numberOfYears;
		else
			throw new Exception("�����������С���㣬��������");
	}
	public double getLoanAmount()
	{
		return loanAmount;
	}
	public java.util.Date getLoanDate()
	{
		return loanDate;
	}
	public void setLoanAmount(double loanAmount) throws Exception
	{
		if( loanAmount>0)
			this.loanAmount = loanAmount;
		else
			throw new Exception("������С���㣬��������");
			
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
		return "����� "+this.loanAmount+" ������  "+this.annualInterestRate+" ��������  "+this.numberOfYears+"  �������� "+this.getLoanDate()+"  ��֧��"+this.gerMonthlyPayment()+"  ��֧��"+this.getTotalPayment();
	}
}