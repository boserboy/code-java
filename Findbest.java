package Computermouse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Findbest
{
	private int startx,starty,endx,endy,row=8,con=8;
	public Stack<Point> stack = new Stack<>();// 用于存储寻优路线
	public Point[][] point = null;//用于存储迷宫信息
	public Findbest(int startx,int starty,int endx,int endy)
	{
		this.startx = startx;
		this.starty = starty;
		this.endx = endx;
		this.endy = endy;
		point = new Point[row][con];
	}
	public void getMaze() throws FileNotFoundException
	{
			File file =  Maze.getFile(); //读取那个迷宫文件就在那个迷宫中遍历和找路
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
	public void BfS()
	{
		int x = startx;
		int y = starty; 
		stack.push(point[x][y]);
		while(x!=endx&&y!=endy)
		{
			if(point[x][y].length==1)
			{
				if(point[x][y].top=='0'&&!point[x][y-1].isinterviewed)
				{
					point[x][y-1].length = point[x][y].length+1;
					y=y-1;
					point[x][y].setinterviewed();
					stack.push(point[x][y]);
				}
				else if(point[x][y].bottom=='0'&&!point[x][y+1].isinterviewed)
				{
					point[x][y+1].length = point[x][y].length+1;
					y=y+1;
					point[x][y].setinterviewed();
					stack.push(point[x][y]);
				}
				else if(point[x][y].left=='0'&&!point[x-1][y].isinterviewed)
				{
					point[x-1][y].length = point[x][y].length+1;
					x=x-1;
					point[x][y].setinterviewed();
					stack.push(point[x][y]);
				}
				else if(point[x][y].right=='0'&&!point[x+1][y].isinterviewed)
				{
					point[x+1][y].length = point[x][y].length+1;
					x=x+1;
					point[x][y].setinterviewed();
					stack.push(point[x][y]);
				}
				
				else
				{
					stack.pop();
					x=stack.peek().x;
					y=stack.peek().y;
				}
			}
			else
			{
				ArrayList<Point> p1 = finddegree(point[x][y].length);
				for(int i = 0;i<p1.size();i++)
				{
					
					if(p1.get(i).top=='0'&&!point[p1.get(i).x][p1.get(i).y-1].isinterviewed)
					{
						point[p1.get(i).x][p1.get(i).y-1].length = point[x][y].length+1;
						if(p1.get(i).y-1==0)
							continue;
						y=p1.get(i).y-1;
						point[p1.get(i).x][y].setinterviewed();
						stack.push(point[x][y]);
					}
					else if(p1.get(i).left=='0'&&!point[p1.get(i).x-1][p1.get(i).y].isinterviewed)
					{
						point[p1.get(i).x-1][p1.get(i).y].length = point[x][y].length+1;
						if(p1.get(i).x-1==0)
							continue;
						x=p1.get(i).x-1;
						point[x][p1.get(i).y].setinterviewed();
						stack.push(point[x][y]);
					}
					else if(p1.get(i).right=='0'&&!point[p1.get(i).x+1][p1.get(i).y].isinterviewed)
					{
						point[p1.get(i).x+1][p1.get(i).y].length = point[x][y].length+1;
						if(p1.get(i).x+1==7)
							continue;
						x=p1.get(i).x+1;
						point[x][p1.get(i).y].setinterviewed();
						stack.push(point[x][y]);
					}
					else if(p1.get(i).top=='0'&&!point[p1.get(i).x][p1.get(i).y+1].isinterviewed)
					{
						point[p1.get(i).x][p1.get(i).y+1].length = point[x][y].length+1;
						if(p1.get(i).y+1==7)
							continue;
						y=p1.get(i).y+1;
						point[p1.get(i).x][y].setinterviewed();
						stack.push(point[x][y]);
					}
					else
					{
						
						stack.pop();
						x=stack.peek().x;
						y=stack.peek().y;
					}
				}
			}
		}
	}
	public void Find() 
	{
		stack.push(point[startx][starty]);
		point[startx][starty].setinterviewed();
		int x=startx;
		int y =starty;
		while(true)
		{
			if(x==endx && y==endy)
				//到达终点是循环终止
			{
				break;
			}
			 
			 if(point[x][y].bottom=='0'&&!isinterviewed(point[x][y+1]))
				//房间下面是否无墙，且没被访问过
			{
				y=y+1;
				stack.push(point[x][y]);
				point[x][y].setinterviewed();
				
			}
			else if(point[x][y].top=='0'&&!isinterviewed(point[x][y-1]))
				//房间上面是否无墙，且没被访问过
			{
				y=y-1;
				stack.push(point[x][y]);
				point[x][y].setinterviewed();
				
			}
			else if(point[x][y].left=='0'&&!isinterviewed(point[x-1][y]))
				//房间左面是否无墙，且没被访问过
			{
				x=x-1;
				stack.push(point[x][y]);
				point[x][y].setinterviewed();
				
			}
			else if(point[x][y].right=='0'&&!isinterviewed(point[x+1][y]))
				//房间右面是否无墙，且没被访问过
				{
					x=x+1;
					stack.push(point[x][y]);
					point[x][y].setinterviewed();
					
				}
			else
			{//此为走到了死路，让栈顶出栈，访问另一支路
				stack.pop();
				x=stack.peek().x;
				y=stack.peek().y;
				
			}
		}
	}
	
	public boolean isinterviewed(Point p)
	{
		if(p.isinterviewed)
			return true;
		else
			return false;
			
	}
	// **************检索迷宫的同一层的点（到起点距离相同的点）*****************//
	public ArrayList<Point> finddegree(int length)
	{
		ArrayList<Point> p  = new ArrayList<>();
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(this.point[i][j].length==length)
				{
					p.add(point[i][j]);
				}
				
			}
		}
		return p;
	}


}
