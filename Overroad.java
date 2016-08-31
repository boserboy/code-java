package Computermouse;

import java.io.File;
import java.util.*;

public class Overroad
{
	private int con=8,row=8;
	private Point[][] point = null;//存储迷宫信息
	private Stack<Point> stack = new Stack<>();
	private ArrayList<Point> interviewed = new ArrayList<>();//存储遍历迷宫似时的路线
	
	public Overroad()
	{
		
		point = new Point[con][row];
		
	}
	
	public ArrayList<Point> getInterviewed()
	//获取遍历时的路线
	{
		return interviewed;
	}
	//**************从迷宫文件获取迷宫信息并存于二维数组中**************//
	public void mazeInformation() throws Exception
	{
		File file = Maze.getFile();
		int count = 0;
		try(Scanner input = new Scanner(file))
		{
			while(input.hasNext())
			{
				point[count%con][count/row]=new Point(count%con,count/row,input.next());
				count++;
			}
		}
	}
	
	public void overfind()
	{
		int x=0,y=0;
		stack.push(point[x][y]);
		point[x][y].setinterviewed();
		interviewed.add(point[x][y]);
		while(!isAllinterviewed())
		{
			if(point[x][y].top=='0'&&!isinterviewed(point[x][y-1]))
			{
				y=y-1;
				stack.push(point[x][y]);
				point[x][y].setinterviewed();
				interviewed.add(point[x][y]);
			}
			else if(point[x][y].right=='0'&&!isinterviewed(point[x+1][y]))
			{
				x=x+1;
				stack.push(point[x][y]);
				point[x][y].setinterviewed();
				interviewed.add(point[x][y]);
			}
			else if(point[x][y].bottom=='0'&&!isinterviewed(point[x][y+1]))
			{
				y=y+1;
				stack.push(point[x][y]);
				point[x][y].setinterviewed();
				interviewed.add(point[x][y]);
			}
			else if(point[x][y].left=='0'&&!isinterviewed(point[x-1][y]))
			{
				x=x-1;
				stack.push(point[x][y]);
				point[x][y].setinterviewed();
				interviewed.add(point[x][y]);
			}
			else
			{
				interviewed.add(stack.pop());
				x=stack.peek().x;
				y=stack.peek().y;
				interviewed.add(point[x][y]);
			}
		}
	}
	// 检测迷宫中的某点是否被访问过
	public boolean isinterviewed(Point p)
	{
		if(p.isinterviewed)
			return true;
		else
			return false;
			
	}
	//**************判断所以坐标是否被访问过*********************//
	public boolean isAllinterviewed()
	{
		boolean flag = true;
		for(int i=0;i<point.length;i++)
		{
			for(int j=0;j<point[i].length;j++)
			{
				if(!point[i][j].isinterviewed)
				{
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

}
