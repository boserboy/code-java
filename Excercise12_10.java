package part12;
import java.util.Scanner;
public class Excercise12_10 



 {
	
public static void main(String[] args) {
 Scanner input=new Scanner(System.in);
 System.out.print("����һ����Ϊ0���� ");
 int number=input.nextInt();
 try
 {
	 moethod(number);
 }
 catch(OutOfMemoryError ex)
 {
	 System.out.println("OutOfMemoryError����������");
	 input.nextLine();
	 number=input.nextInt();
	 
 }
 System.out.println("������� "+number);

	 input.close();
}
static void moethod(int i)
{
	if(i==0)
		throw new OutOfMemoryError("��������");
	
}
}
