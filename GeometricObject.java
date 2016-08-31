package part11;
import java.util.Date;
import java.util.Scanner;

public class GeometricObject
{
	public static void main(String[] args)
	{
		System.out.println("Enter three sides : ");
		in1 = new Scanner(System.in);
		double side1=in1.nextDouble(),side2=in1.nextDouble(),side3=in1.nextDouble();
		Triangle triangle=new Triangle(side1,side2,side3);
		System.out.println(triangle.toString());
	}
	private String color;
	private boolean fillted;
	static Date dateCreated;
	private static Scanner in1;
	public GeometricObject()
	{
		
		this("white",false);
		
	}
	public GeometricObject(String color,boolean fillted)
	{
		this.color=color;
		this.fillted=fillted;
		dateCreated=new Date();
	}
	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	public boolean isFillted()
	{
		return fillted;
	}
	public void setFillted(boolean fillted)
	{
		this.fillted = fillted;
	}
	public static Date getDateCreated()
	{
		return dateCreated;
	}
	@Override
	public String toString()
	{
		return " color "+color+";   "+"datecreated"+dateCreated+";  "+" wether filled  : "+fillted;
	}

}
class Triangle extends  GeometricObject
{
	Scanner in = new Scanner(System.in);
	private double side1,side2,side3;
	public Triangle()
	{
		this(1.0,1.0,1.0);
	}
	public Triangle(double side1,double side2,double side3)
	{
		this.side1=side1;
		this.side2=side2;
		this.side3=side3;
		in.nextLine();
		System.out.println("Enter color : ");
		String str=in.next();
		System.out.println("whether it filled : ");
		boolean fill=in.nextBoolean();
		super.setColor(str);
		super.setFillted(fill);
		
	}
	public double getSide1()
	{
		return side1;
	}
	public double getSide2()
	{
		return side2;
	}
	public double getSide3()
	{
		return side3;
	}
	public double getArea()
	{
		double s=(side1+side2+side3)/2.0;
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));	
	}
	public double getPerimeter()
	{
		return side1+side2+side3;
	}
	@Override
	public String toString()
	{
		return "The Triangle : side1 ="+side1+ " side2 = "+side2+" side3 = "+side3+";   "+super.toString();
	}
	
}
