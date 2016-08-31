package part11;
import java.util.Date;
import java.util.Scanner;
public class Text3
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.println("输入ID和存款");
		int id=in.nextInt();
		double ballance=in.nextDouble();
		Account account=new Account(id,ballance);
		System.out.println(account.toString());
		
		CheckingAccount checking=new CheckingAccount();
		System.out.println("输入id");
		int id1=in.nextInt();
		checking.setId(id1);
		System.out.println("输入存款");
		double ballance1=in.nextDouble();
		checking.setBallance(ballance1);
		System.out.println("输入透支额度");
		double money=in.nextDouble();
		checking.setMoney(money);
		checking.withDraw(500);
		System.out.println(checking.toString());
		SavingAccount saving=new SavingAccount();
		System.out.println("输入id");
		int id2=in.nextInt();
		 saving.setId(id2);
		System.out.println("输入存款");
		double ballance2=in.nextDouble();
		 saving.setBallance(ballance2);
		 System.out.println( saving.toString());		
		in.close();
	}

}
class Account
{
	int id=0;
	double ballance=0.0;
	static double annualIntrestRate=0.0;
	private static Date dateCreated;
	public Account()
	{
		this(0,0);
	}
	public Account(int newid,double newbranch)
	{
		id=newid;
		ballance=newbranch;
		dateCreated=new Date();
		
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
		Account.annualIntrestRate = annualIntrestRate;
	}
	public Date getDateCreated()
	{
		return dateCreated;
	}
	public double getMonthlyInterext()
	{
		return annualIntrestRate/12;
	}
	public double withDraw(double reduce)
	{
		ballance=ballance-reduce;
		return ballance;
	}
	public double deposit(double increase)
	{
		ballance = ballance+increase;
		return ballance;
	}
	public String toString()
	{
		return "ID :"+id+"  Datecreated :"+dateCreated+"  Balance :"+ballance;
	}

}
class CheckingAccount extends Account
{
	Scanner in=new Scanner(System.in);
	private double money;
	public CheckingAccount()
	{
		this(0);
	}
	public CheckingAccount(double money)
	{
		this.money=money;
		
		
	}
	
	public void setMoney(double money)
	{
		this.money = money;
	}
	public double withDraw(double reduce)
	{
		if(reduce>(super.ballance+money))
			System.out.println("超过最大透支金额");
	
		else
			super.ballance=super.ballance-reduce;
		return super.ballance;
		
	}
	public double deposit(double increase)
	{
		super.ballance = super.ballance+increase;
		return super.ballance;
	}
	public double getOverdraft()
	{
		if(super.ballance<0)
			money+=super.ballance;
		return money;
	}
	public String toString()
	{
		return super.toString()+"  overdraft:"+money;
	}
}
class SavingAccount extends Account
{
	Scanner in=new Scanner(System.in);
	public SavingAccount()
	{
		
	}
	public double withDraw(double reduce)
	{
		if(reduce>(super.ballance))
			System.out.println("余额不足");
	
		else
			super.ballance=super.ballance-reduce;
		return super.ballance;
		
	}
	public double deposit(double increase)
	{
		return super.deposit(increase);
	}
	public String toString()
	{
		return super.toString();
	}
}

