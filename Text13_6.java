package part13;

import java.util.Arrays;

public class Text13_6
{
	public static void main(String[] args)
	{
		ComparableCircle[] circle = new ComparableCircle[3] ;
		circle[0]=new ComparableCircle(1.2);
		circle[1]=new ComparableCircle(5.2);
		circle[2]=new ComparableCircle(5.2);
		Arrays.sort(circle);
		for(int j=0;j<3;j++)
		{
			System.out.println(circle[j].toString());
		}
	}
	
	

}
class Circle
{
	private double radius=1;
	public Circle()
	{
		
	}
	public Circle(double radius)
	{
		this.radius=radius;
	}
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	public double getPerimeter()
	{
		return radius*2*Math.PI;
	}
	public double getArea()
	{
		return radius*radius*Math.PI;
	}
	public String toString()
	{
		return "Area "+this.getArea()+ " Perimeter "+this.getPerimeter()+" Radius "+radius;
	}
}
class ComparableCircle extends Circle implements Comparable<Circle>
{
	ComparableCircle(double r)
	{
		super.setRadius(r);
	}

	@Override
	public int compareTo(Circle o)
	{
		int flag=0;
		if(super.getArea()>o.getArea())
			flag=1;
		if(super.getArea()<o.getArea())
			flag=-1;
		
		return flag;
	}
	
}