package part11;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Person
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
    	System.out.println("Inpute Name,adress,Phone number,email：");
		String name=input.nextLine();
		
		String adress=input.nextLine();
		
		String num=input.nextLine();
		
		String email=input.nextLine();
		
		Person person=new Person(name,adress,num,email);
		System.out.println(person.toString());
		System.out.println("inpute Stedent grade");
		String grade=input.nextLine();
		
		Student student=new Student(grade);
		System.out.println(student.toString());
		System.out.println("inpute Employee workroom & salary");
		int room=input.nextInt();
		double salary=input.nextDouble();
		Employee employee=new Employee(room,salary);
		System.out.println(employee.toString());
		System.out.println("inpute Faculty workime ");
		input.nextLine();
		String time=input.nextLine();
		System.out.println("inpute Faculty  grade");
		int grade1=input.nextInt();
		Faculty faculty=new Faculty(time,grade1);
		System.out.println(faculty.toString());
		input.close();
	}
	private String name,adress,email,num;
	public Person()
	{
	}
	public Person(String name,String adress,String num,String email)
	{
		this.name=name;
		this.adress=adress;
		this.num=num;
		this.email=email;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getAdress()
	{
		return adress;
	}
	public void setAdress(String adress)
	{
		this.adress = adress;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getNum()
	{
		return num;
	}
	public void setNum(String num)
	{
		this.num = num;
	}
	@Override
	public String toString()
	{
		return "Name : "+name+"  Adress : "+adress+"  Phone number : "+num+" Email"+email;
	}

}
class Student extends Person
{
	Scanner in =new Scanner(System.in);
	public static final String grade1="大一",grade2="大二",grade3="大三",grade4="大四";
	private String grade;
	public Student()
	{
		this(grade1);
	}
	public Student(String grade)
	{
		this.grade=grade;
		System.out.println("Inpute Name,adress,Phone number,email：");
		String name=in.nextLine();
		String adress=in.nextLine();
		String num=in.nextLine();
		String email=in.nextLine();
		super.setName(name);
		super.setAdress(adress);
		super.setEmail(email);
		super.setNum(num);
		
	}
	
	public String getGrade()
	{
		return grade;
	}
	public void setGrade(String grade)
	{
		this.grade = grade;
	}
	@Override
	public String toString()
	{
		return super.toString()+" Student grade :"+grade;
	}
	
}
class Employee extends Person
{
	Scanner in =new Scanner(System.in);
	private int room;
	private Mydate date;
	private double salary;
	public Employee()
	{
		this(0,0);
	}
	public Employee(int room,double salary)
	{
		this.date=new Mydate();
		this.room=room;
		this.salary=salary;
		System.out.println("Inpute Name,adress,Phone number,email：");
		String name=in.nextLine();
		String adress=in.nextLine();
		String num=in.nextLine();
		String email=in.nextLine();
		super.setName(name);
		super.setAdress(adress);
		super.setEmail(email);
		super.setNum(num);
	}
	public int getRoom()
	{
		return room;
	}
	public void setRoom(int room)
	{
		this.room = room;
	}
	public double getSalary()
	{
		return salary;
	}
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	@Override
	public String toString()
	{
		return super.toString()+"; Employee  : room :"+room+"  Hire date"+date.getYear()+"年"+date.getMonth()+"月"+date.getDay()+"日   Salary"+salary;
	}
	
}
class Mydate
{
	public static int month,year,day;
	Mydate()
	{
		GregorianCalendar calendar = new GregorianCalendar();
		year=calendar.get(GregorianCalendar.YEAR);
		month=calendar.get(GregorianCalendar.MONTH);
		day=calendar.get(GregorianCalendar.DAY_OF_MONTH);
	}
	public int getMonth()
	{
		return month;
	}
	public int getYear()
	{
		return year;
	}
	public int getDay()
	{
		return day;
	}
		
}
class Faculty extends Employee
{
	Scanner in =new Scanner(System.in);
	private String worktime;
	private int grade;
	public Faculty()
	{
		this(null, 0);
	}
	public Faculty(String worktime,int grade)
	{
		this.worktime=worktime;
		this.grade=grade;
		System.out.println("Inpute Employee's room &salary");
		int room=in.nextInt();
		double salary=in.nextDouble();
		super.setRoom(room);
		super.setSalary(salary);
	}
	public String getWorktime()
	{
		return worktime;
	}
	public void setWorktime(String worktime)
	{
		this.worktime = worktime;
	}
	public int getGrade()
	{
		return grade;
	}
	public void setGrade(int grade)
	{
		this.grade = grade;
	}
	public String toString()
	{
		return super.toString()+";  Faclity worktime :"+worktime+"  Faclity grade:"+grade;
	}
	
}
class Staff extends Employee
{
	Scanner in =new Scanner(System.in);
	private String staffname;
	public Staff()
	{
		this(null);
	}
	public Staff(String staffname)
	{
		this.staffname=staffname;
		System.out.println("Inpute Employee's room &salary");
		int room=in.nextInt();
		double salary=in.nextDouble();
		super.setRoom(room);
		super.setSalary(salary);
	}
	public String getStaffname()
	{
		return staffname;
	}
	public void setStaffname(String staffname)
	{
		this.staffname = staffname;
	}
	public String toString()
	{
		return super.toString()+";  Staffname:"+staffname;  
	}

}