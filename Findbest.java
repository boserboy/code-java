package Computermouse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Findbest
{
	private int startx,starty,endx,endy,row=8,con=8;
	public Stack<Point> stack = new Stack<>();// ���ڴ洢Ѱ��·��
	public Point[][] point = null;//���ڴ洢�Թ���Ϣ
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
			File file =  Maze.getFile(); //��ȡ�Ǹ��Թ��ļ������Ǹ��Թ��б�������·
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
				//�����յ���ѭ����ֹ
			{
				break;
			}
			 
			 if(point[x][y].bottom=='0'&&!isinterviewed(point[x][y+1]))
				//���������Ƿ���ǽ����û�����ʹ�
			{
				y=y+1;
				stack.push(point[x][y]);
				point[x][y].setinterviewed();
				
			}
			else if(point[x][y].top=='0'&&!isinterviewed(point[x][y-1]))
				//���������Ƿ���ǽ����û�����ʹ�
			{
				y=y-1;
				stack.push(point[x][y]);
				point[x][y].setinterviewed();
				
			}
			else if(point[x][y].left=='0'&&!isinterviewed(point[x-1][y]))
				//���������Ƿ���ǽ����û�����ʹ�
			{
				x=x-1;
				stack.push(point[x][y]);
				point[x][y].setinterviewed();
				
			}
			else if(point[x][y].right=='0'&&!isinterviewed(point[x+1][y]))
				//���������Ƿ���ǽ����û�����ʹ�
				{
					x=x+1;
					stack.push(point[x][y]);
					point[x][y].setinterviewed();
					
				}
			else
			{//��Ϊ�ߵ�����·����ջ����ջ��������һ֧·
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
	// **************�����Թ���ͬһ��ĵ㣨����������ͬ�ĵ㣩*****************//
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
