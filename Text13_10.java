package part13;

import java.util.*;

public class Text13_10
{

	public static void main(String[] args)
	{
		Rectangle[] re = new Rectangle[3];
		re[0]=new Rectangle(2.5,6);
		re[1]=new Rectangle(6,2.3);
		re[2]=new Rectangle(1.8,4);
		Arrays.sort(re);
		for(int i=0;i<3;i++ )
		{
			System.out.println(re[i]);
		}
			
	}
}
abstract class GeometricObject 
{
	private String color = "white";
	private boolean filled;
	private Date dateCreated; 
	protected GeometricObject()
	{
		dateCreated = new Date();
	}
	protected GeometricObject(String color,boolean filled)
	{
		dateCreated = new Date();
		this.color = color;
		this.filled = filled;
	}
	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	public boolean isFilled()
	{
		return filled;
	}
	public void setFilled(boolean filled)
	{
		this.filled = filled;
	}
	public Date getDateCreated()
	{
		return dateCreated;
	}
	public String toString()
	{
		return "created on"+dateCreated+" \ncolor"+color+"and filled"+filled;
	}
	public abstract double getArear();
	public abstract double getPerimeter();
}
class Rectangle extends GeometricObject implements Comparable<Rectangle>
{
	private double width;
	private double height;
	public Rectangle()
	{
	}
	public Rectangle(double width,double height)
	{
		this.height=height;
		this.width= width;
	}
	public Rectangle(double width,double height,String color,boolean filled)
	{
		this.height=height;
		this.width=width;
		super.setColor(color);
		super.setFilled(filled);
	}
	

	public double getWidth()
	{
		return width;
	}
	public void setWidth(double width)
	{
		this.width = width;
	}
	public double getHeight()
	{
		return height;
	}
	public void setHeight(double height)
	{
		this.height = height;
	}
	@Override
	public double getArear()
	{
		
		return width*height;
	}

	@Override
	public double getPerimeter()
	{
		
		return 2*(width+height);
	}
	@Override
	public String toString()
	{
		return super.toString()+"\nheight"+this.height+" width"+this.width+"\nArear"+this.getArear()+"\n Perimeter"+this.getPerimeter();
	}
	@Override
	public int compareTo(Rectangle o)
	{
		if(this.getArear()>o.getArear())
			return 1;
		else if(this.getArear()<o.getArear())
			return -1;
		else
			return 0;
	}
	
}