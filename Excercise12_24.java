package part12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Excercise12_24
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File file=new File("Salary.txt");
		String[] grade={"assistant", "associate","full"};
		PrintWriter write = new PrintWriter(file);
		for(int i=0;i<1000;i++)
		{
			int m=(int)(Math.random()*3);
			double salary=0;
			if(m==0)
				salary=50000+Math.random()*30000;
			if(m==1)
				salary=60000+Math.random()*50000;
			if(m==2)
				salary=75000+Math.random()*55000;
			write.printf("fistname%d Lastname %d %s %.2f\r\n",i+1,i+1,grade[m],salary);
		
		}
		write.close();
	}

}
