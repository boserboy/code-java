package part17;

import java.io.*;
import java.util.*;

public class Text17_6
{
	public static void main(String[] args) throws Exception
	{
		Loan[] loan = new Loan[5];
		for(int i=0;i<5;i++)
		{
			loan[i] = new Loan(2.5,5,10000);
			loan[i].Serializable();
		}
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
	public void Serializable() throws Exception
	{
		File file = new File("Text17_6.data");
		if(file.exists())
		{
			ArrayList<String> list = new ArrayList<> ();
			try(Scanner input = new Scanner(file))
				{
					while(input.hasNextLine())
					{
						list.add(input.nextLine());
					}
				}
			try(DataOutputStream output= new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file))))
			{
				for (String string : list)
				{
					output.writeUTF(string);
				}
				output.writeUTF(this.toString());
			}
		}
		else
		{
			try(DataOutputStream output= new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file))))
			{
				output.writeUTF(this.toString());
			}
		}
	}
}