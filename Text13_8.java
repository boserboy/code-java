package part13;

import java.util.ArrayList;

public class Text13_8
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Mystack stack = new Mystack();
		for(int i=0;i<10;i++)
			stack.push(i);
		Mystack stack1 = (Mystack)stack.clone();
		System.out.println(stack1.tostring());
	}
}
class Mystack implements Cloneable
{
	private ArrayList<Object> list = new ArrayList<>();
	public boolean isempty()
	{
		return list.isEmpty();
	}
	public int getSize()
	{
		return list.size();
	}
	public Object peek()
	{
		return list.get(list.size()-1);
	}
	public Object pop()
	{
		Object o = list.get(list.size()-1);
		list.remove(list.size()-1);
		return o;
	}
	public void push(Object o)
	{
		list.add(o);
	}
	public String tostring()
	{
		return "Stack :" +list.toString();
	}
	@Override
	public Object clone() throws CloneNotSupportedException 
	{
		return super.clone();
	}
}
