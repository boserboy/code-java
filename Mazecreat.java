package Computermouse;

import java.io.File;
import java.io.PrintWriter;
import java.util.Random;

public class Mazecreat
{
	public static void main(String[] args)
	{
		Mazecreat creat = new Mazecreat();
		creat.Creat();
		try
		{
			creat.printintfile();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private int con = 8,row = 8;
	private Random random = new Random();
	private Point[][] point = null;
	public Mazecreat()
	{
		point = new Point[row][con];
		for(int i=0;i<point.length;i++)
		{
			for(int j=0;j<point[i].length;j++)
			{
				point[i][j] = new Point(i, j) ;
			}
		}
	}
	public void Creat()
	{
		int x = 4;
		int y = 3;
		point[0][0].setinterviewed();
		while(!isAllinterviewed())
		{
			if(x>0&&x<7&&y>0&&y<7)
			{
				switch(random.nextInt(4))
				{
				case 0:{
					point[x][y].top = '0';
					x=x-1;
					
					point[x][y].bottom = '0';
					point[x][y].setinterviewed();
				};break;
				case 1 :{
					point[x][y].right = '0';
					y=y+1;
					
					point[x][y].left = '0';
					point[x][y].setinterviewed();
				};break;
				case 2:
				{
					point[x][y].bottom = '0';
					x=x+1;
					
					point[x][y].top = '0';
					point[x][y].setinterviewed();
				}
				case 3:{
					point[x][y].left = '0';
					y = y-1;
					
					point[x][y].right = '0';
					point[x][y].setinterviewed();
					
				};break;
				}
			}
				
		else if(x==0&&y==0)
		{
			switch(random.nextInt(2))
			{
			case 0:
			{	point[x][y].bottom = '0';
			x=x+1;
			
			point[x][y].top = '0';
			point[x][y].setinterviewed();
			
			};break;
			case 1:
			{
				point[x][y].bottom = '0';
				x=x+1;
				
				point[x][y].top = '0';
				point[x][y].setinterviewed();
			}
			
			}
		}
		else if(x==0&&y==7)
		{
			switch(random.nextInt(2))
			{
			case 0:
			{
				point[x][y].bottom = '0';
				x=x+1;
				
				point[x][y].top = '0';
				point[x][y].setinterviewed();
			};break;
			case 1:
			{
				point[x][y].left = '0';
				y = y-1;
				
				point[x][y].right = '0';
				point[x][y].setinterviewed();
			};break;
			
			}
		}
		else if(x==7&&y==0)
		{
			switch(random.nextInt(2))
			{
			case 0:
			{
				point[x][y].top = '0';
				x=x-1;
				
				point[x][y].bottom = '0';
				point[x][y].setinterviewed();
			};break;
//			case 1:
//			{
//				point[x][y].right = '0';
//				y=y+1;
//				
//				point[x][y].left = '0';
//				point[x][y].setinterviewed();
//			}
			
			}
		}
		else if(x==7&&y==7)
		{
			switch(random.nextInt(2))
			{
			case 0:
			{
				point[x][y].top = '0';
				x=x-1;
				
				point[x][y].bottom = '0';
				point[x][y].setinterviewed();
			};break;
			case 1:
			{
				point[x][y].left = '0';
				y=y-1;
				
				point[x][y].right = '0';
				point[x][y].setinterviewed();
			}
			
			}
		}
		else if(x==0&&y<7&&y>0)
		{
			switch(random.nextInt(3))
			{
//			case 0:{
//				point[x][y].left = '0';
//				y =y-1;
//				point[x][y].right = '0';
//				point[x][y].setinterviewed();
//			};break;
			case 1:{
				point[x][y].bottom = '0';
				x=x+1;
				
				point[x][y].top = '0';
				point[x][y].setinterviewed();
			};break;
			case 2:{
				point[x][y].right = '0';
				y=y+1;
				
				point[x][y].right = '0';
				point[x][y].setinterviewed();
	
			};break;
			}
		}
			else if(x==7&&y<7&&y>0)
			{
				switch(random.nextInt(3))
				{
				case 0:{
					point[x][y].right = '0';
					y=y+1;
					
					point[x][y].right = '0';
					point[x][y].setinterviewed();
				};break;
				case 1:{
					point[x][y].top = '0';
					x=x-1;
					
					point[x][y].bottom = '0';
					point[x][y].setinterviewed();
				};break;
				case 2:{
					point[x][y].right = '0';
					y=y+1;
					
					point[x][y].right = '0';
					point[x][y].setinterviewed();
				};break;
				}
			}
			else if(y==0&&x<7&&x>0)
			{
				switch(random.nextInt(3))
				{
				case 0:{
					point[x][y].bottom = '0';
					x=x+1;
					
					point[x][y].top = '0';
					point[x][y].setinterviewed();
				};break;
				case 1:{
					point[x][y].right = '0';
					y=y+1;
					
					point[x][y].left = '0';
					point[x][y].setinterviewed();
				};break;
				case 2:{
					point[x][y].top = '0';
					x=x-1;
					
					point[x][y].bottom = '0';
					point[x][y].setinterviewed();
				};break;
				}
			}
			else 
			{
				switch(random.nextInt(3))
				{
				case 0:{
					point[x][y].top = '0';
					x=x-1;
					
					point[x][y].bottom = '0';
					point[x][y].setinterviewed();
				};break;
				case 1:{
					point[x][y].left = '0';
					y=y-1;
					point[x][y].right = '0';
					point[x][y].setinterviewed();
				};break;
			}
			
		}
		}
			
			
	
}
	public void printintfile() throws Exception 
	{
		File file = new File("Maze2.txt");
	    try(PrintWriter print = new PrintWriter(file);)
	    {
	    
			for(int i = 0 ;i<8 ;i++)
			{
				for(int j=0;j<8;j++)
				{
					String str = point[i][j].toString();
					print.print(str);
					print.print(" ");
				}
				print.println();
			}
	    }
	}
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
