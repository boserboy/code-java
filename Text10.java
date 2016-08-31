package part11;

import java.util.ArrayList;
import java.util.Scanner;

public class Text10
{
	public static void main(String[] args)
	{	
		Scanner in = new Scanner(System.in);
		Stack stack = new Stack();
		for(int i=0;i<5;i++)
		{
			String str=in.nextLine();
			stack.push(str);
		}
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.toString());
		in.close();
	}
}
class Stack extends ArrayList<Object>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Stack()
	{
	}
	public boolean isEmpty()
	{
		return super.isEmpty();
	}
	public int getSize()
	{
		return super.size();
	}
	public Object peek()
	{
		return super.get(super.size()-1);
	}
	public Object pop()
	{
		Object o=super.get(super.size()-1);
		super.remove(super.size()-1);
		return o;
	}
	public void push(Object o)
	{
		super.add(o);
	}
	public String toString()
	{
		return super.toString();
	}
}