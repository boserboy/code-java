package part12;
import java.util.Scanner;
public class Excercise12_10 



 {
	
public static void main(String[] args) {
 Scanner input=new Scanner(System.in);
 System.out.print("输入一个不为0的数 ");
 int number=input.nextInt();
 try
 {
	 moethod(number);
 }
 catch(OutOfMemoryError ex)
 {
	 System.out.println("OutOfMemoryError：重新输入");
	 input.nextLine();
	 number=input.nextInt();
	 
 }
 System.out.println("这个数是 "+number);

	 input.close();
}
static void moethod(int i)
{
	if(i==0)
		throw new OutOfMemoryError("输入有误");
	
}
}
