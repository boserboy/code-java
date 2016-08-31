package Computermouse;

public class Point
{
	int x;//迷宫房间的x坐标
	int y;//迷宫房间的y坐标
	//迷宫房间的四面信息，0为无墙1位有墙
	public char top='1';//上
	public char left='1';//左
	public char right='1';//友
	public char bottom='1';//下
	public int length = 1;//长度属性用于建立高表是使用
	public boolean isinterviewed = false;//是否被访问过
	public Point(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	public Point(int x,int y,String str)
	{
		this.x=x;
		this.y=y;
		this.top = str.charAt(0);
		this.right = str.charAt(1);
		this.bottom = str.charAt(2);
		this.left = str.charAt(3);
	}
	//设置该房间被访问过
	public void setinterviewed()
	{
		isinterviewed = true;
	}
}
