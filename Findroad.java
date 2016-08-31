
	package Computermouse;

	import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
	public class Findroad
	{
		private int startx,starty,endx,endy,row=8,con=8;
		private Stack<Point> stack = new Stack<>();
		//存储路线坐标
		private Point[][] point  =null;
		//用于存储从迷宫文件读取的迷宫信息
		public Findroad(int startx,int starty,int endx,int endy)
		{
			point = new Point[row][con];
			this.startx = startx;
			this.starty = starty;
			this.endx = endx;
			this.endy = endy;
		}
		//******************从迷宫文件获取迷宫信息*************************//
		public void mazeInformation() throws FileNotFoundException 
		{
			File file = Maze.getFile(); //读取那个迷宫文件就在那个迷宫中遍历和找路，Maze.getfFile()为静态方法
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
		
		
		//***************寻找起点到终点的路************//
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
				if(point[x][y].top=='0'&&!isinterviewed(point[x][y-1]))
					//房间上部是否无墙，且没被访问过
				{
					y=y-1;
					stack.push(point[x][y]);
					point[x][y].setinterviewed();  //入栈立即设置是否已被访问属性
					
				}
				else if(point[x][y].right=='0'&&!isinterviewed(point[x+1][y]))
					//房间右面是否无墙，且没被访问过
				{
					x=x+1;
					stack.push(point[x][y]);
					point[x][y].setinterviewed();
					
				}
				else if(point[x][y].bottom=='0'&&!isinterviewed(point[x][y+1]))
					//房间下面是否无墙，且没被访问过
				{
					y=y+1;
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
				else
					//此为走到了死路，让栈顶出栈，访问另一支路
				{
					stack.pop();
					x=stack.peek().x;
					y=stack.peek().y;
					
				}
			}
		}
		public Stack<Point> getStack()
		//获得路线图
		{
			return stack;
		}
		public boolean isinterviewed(Point p)
		//检测是否被访问过
		{
			if(p.isinterviewed)
				return true;
			else
				return false;
				
		}
	}
	
		
