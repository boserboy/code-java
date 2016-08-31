package part11;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class NewAccount
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		NewAccount account =new NewAccount("Gorge",1122,1000);
		NewAccount.setAnnualIntrestRate(0.015);
		while(true)
		{
			char type=in.nextLine().charAt(0);
			double amount=in.nextDouble();
			in.nextLine();
			String describe=in.nextLine();
				account.withDrawdeposit(type,amount,describe);
			System.out.println("是否继续交易");
			char m =in.nextLine().charAt(0);
			if(m == 'y')
				continue;
			else
				break;
		}
		System.out.println(account.list.toString());
		System.out.println();
		System.out.println(account.toSring());
		in.close();
	}
	Scanner in = new Scanner(System.in);
	private String name;
	private int id;
	private double ballance;
	static double annualIntrestRate=0.0;
	private  Date dateCreated;
	int i=0;
	ArrayList<Transaction> list=new ArrayList<> ();
	public NewAccount()
	{
		this(null,0,0);
	}
	public NewAccount(String name,int id,double ballance)
	{
		this.name=name;
		this.id=id;
		this.ballance =ballance;
	    dateCreated = new Date();
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public double getBallance()
	{
		return ballance;
	}
	public void setBallance(double ballance)
	{
		this.ballance = ballance;
	}
	public static double getAnnualIntrestRate()
	{
		return annualIntrestRate;
	}
	public static void setAnnualIntrestRate(double annualIntrestRate)
	{
		NewAccount.annualIntrestRate = annualIntrestRate;
	}
	public double withDrawdeposit(char type,double amount,String describe)
	{
		
	
		list.add(new Transaction(type,amount,this.ballance,describe));
		i++;
		if(type=='w')
		{
			this.ballance+=amount;
			return list.get(i-1).withDraw();
		}
		else 
		{
			if(amount<this.ballance)
				this.ballance=ballance-amount;
			return list.get(i-1).deposit();
		}
	}
	public String toSring()
	{
		return "Ballance :"+(list.get(i-1).getBallance())+" Datecreates"+this.dateCreated+" ID "+this.id+" 利率"+NewAccount.getAnnualIntrestRate();
	}

}
class Transaction
{
	Date date;
	private char type;
	private double amount;
	private double ballance;
	private String description;
	Transaction(char type,double amont,double ballance,String description)
	{
		this.date=new Date();
		this.type=type;
		this.amount=amont;
		this.ballance =ballance;
		this.description=description;
	}
	public char getType()
	{
		return type;
	}
	public void setType(char type)
	{
		this.type = type;
	}
	public double getAmount()
	{
		return amount;
	}
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	public double getBallance()
	{
		return ballance;
	}
	public void setBallance(double ballance)
	{
		this.ballance = ballance;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Date getDate()
	{
		return date;
	}
	public double withDraw()
	{
		ballance=ballance+amount;
		return ballance;
	}
	public double deposit()
	{
	if(amount>ballance)
		System.out.println("余额不足");
	else
		ballance=ballance-amount;
	return ballance;
	}
	public String toString()
	{
		if(this.type=='w')
			return " 存款  ："+this.amount+" 日期  "+this.date+" 描述 "+this.description;
		else
			return " 取款  ："+this.amount+" 日期  "+this.date+" 描述 "+this.description;
	}
	
}
