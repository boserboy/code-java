package part13;

import java.util.*;

public class Text13_4
{

	public static void main(String[] args)
	{
		PrintCalendar calendar = new PrintCalendar();
		calendar.print();
	}
}
class PrintCalendar
{
	private int year,month;
	Calendar calendar;
	public PrintCalendar()
	{
		Calendar ca = new GregorianCalendar();
		this.year =ca.get(Calendar.YEAR);
		this.month =ca.get(Calendar.MONTH)+1;
		this.calendar =  new GregorianCalendar(year, month-1, 1);
	}
	public PrintCalendar(int year,int month)
	{
		this.year= year;
		this.month=month;
		this.calendar = new GregorianCalendar(year, month-1, 1);
	}
	public void print()
	{
		int dayofweek  = calendar.get(Calendar.DAY_OF_WEEK)-1;
		int days = monthDays(this.year,this.month);
		System.out.println("	" +this.year+" " +this.month);
		System.out.println("sun  mon  Tue  Wed  Thu  Fri  Sat");
		for(int j=0;j<dayofweek;j++)
		{
			System.out.print("     ");
		}
		for(int i=1;i<=days;i++)
		{
			System.out.printf("%3d  ",i);
			if((i+dayofweek)%7==0)
				System.out.println();
		}
		
	}
	public	static int monthDays(int year,int month)
 	{
 		int days=0;
 		switch(month)
 		{
 			case 1:
 			case 3:
 			case 5:
 			case 7:
 			case 8:
 			case 10:
 			case 12: days=31;
 			break;
 			case 4:
 			case 6:
 			case 9:
 			case 11:days=30;
 			break;
 			
 			case 2:
 			{
 				if((year%4==0&&year%100==0)||year%400==0)
 					days=28;
 					else 
 					days=29;
 			};
 			break;
 			
 		}
 		return days;
 	}
 }
