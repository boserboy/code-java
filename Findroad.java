
	package Computermouse;

	import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
	public class Findroad
	{
		private int startx,starty,endx,endy,row=8,con=8;
		private Stack<Point> stack = new Stack<>();
		//�洢·������
		private Point[][] point  =null;
		//���ڴ洢���Թ��ļ���ȡ���Թ���Ϣ
		public Findroad(int startx,int starty,int endx,int endy)
		{
			point = new Point[row][con];
			this.startx = startx;
			this.starty = starty;
			this.endx = endx;
			this.endy = endy;
		}
		//******************���Թ��ļ���ȡ�Թ���Ϣ*************************//
		public void mazeInformation() throws FileNotFoundException 
		{
			File file = Maze.getFile(); //��ȡ�Ǹ��Թ��ļ������Ǹ��Թ��б�������·��Maze.getfFile()Ϊ��̬����
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
		
		
		//***************Ѱ����㵽�յ��·************//
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
				if(point[x][y].top=='0'&&!isinterviewed(point[x][y-1]))
					//�����ϲ��Ƿ���ǽ����û�����ʹ�
				{
					y=y-1;
					stack.push(point[x][y]);
					point[x][y].setinterviewed();  //��ջ���������Ƿ��ѱ���������
					
				}
				else if(point[x][y].right=='0'&&!isinterviewed(point[x+1][y]))
					//���������Ƿ���ǽ����û�����ʹ�
				{
					x=x+1;
					stack.push(point[x][y]);
					point[x][y].setinterviewed();
					
				}
				else if(point[x][y].bottom=='0'&&!isinterviewed(point[x][y+1]))
					//���������Ƿ���ǽ����û�����ʹ�
				{
					y=y+1;
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
				else
					//��Ϊ�ߵ�����·����ջ����ջ��������һ֧·
				{
					stack.pop();
					x=stack.peek().x;
					y=stack.peek().y;
					
				}
			}
		}
		public Stack<Point> getStack()
		//���·��ͼ
		{
			return stack;
		}
		public boolean isinterviewed(Point p)
		//����Ƿ񱻷��ʹ�
		{
			if(p.isinterviewed)
				return true;
			else
				return false;
				
		}
	}
	
		
