import java.util.*;
class Text29
{
	public static void main(String[]args)
	{
		Scanner input=new Scanner(System.in);
		int year=input.nextInt();
		int day=input.nextInt();
		int days=0,days1=0,num=day,count=0;
		for(int i=1;i<=12;i++)
		{
			printHead(year,i);
			System.out.println("Sun  Mom  Tue  Wed  Thu  Fri  Sat");
			days=monthDays(year,i);
			days1=monthDays(year,i-1);
			count=0;	
			if(i==1)
			{
				for(int k=1;k<=num;k++)
				   System.out.printf("     ");
			}
			else
				{
			
						num=(days1+num)%7;//用上个月的总天数
						{
						for(int j=1;j<=num;j++)
							  System.out.printf("     ");
						}
				}
			for(int m=1;m<=days;m++)
			{
				System.out.printf("%3d  ",m);
				count++;
				if((count+num)%7==0)
				  System.out.println();
			}
			System.out.println();
			System.out.println();
			
		}
	}	
	static void printHead(int year,int month )
 {
 	switch(month)
 	{
 		case 1: System.out.printf("\tJanuary %d\n",year);
 		break;
 		case 2: System.out.printf("\tFeburary %d\n",year);
 		break;
 		case 3: System.out.printf("\tMarch%d\n",year);
 		break;
 		case 4: System.out.printf("\tApril %d\n",year);
 		break;
 		case 5: System.out.printf("\tMay %d\n",year);
 		break;
 		case 6: System.out.printf("\tJune %d\n",year);
 		break;
 		case 7: System.out.printf("\tJuly %d\n",year);
 		break; 
 		case 8: System.out.printf("\tAuguest %d\n",year);
 		break;
 		case 9: System.out.printf("\tSeptember %d\n",year);
 		break;
 		case 10: System.out.printf("\tOctober %d\n",year);
 		break;
 		case 11: System.out.printf("\tNovember %d\n",year);
 		break;
 		case 12: System.out.printf("\tDesember %d\n",year);
 		break;
 	}
}
 public	static int monthDays(int year,int i)
 	{
 		int days=0;
 		switch(i)
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