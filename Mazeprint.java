package Computermouse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Mazeprint extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		StackPane pan3 = new StackPane();
		BorderPane pan1 = new BorderPane();
		Pane pan2 = new Pane();
		//*********** �ڽ���������ı���ͱ�ǩ�������û����������յ�   ************//
		TextField text1 = new TextField("0");
		// ���x����
		settextfiled(text1);
		TextField text2 = new TextField("0");
		// ���Y����
		settextfiled(text2);
		Label lb1 = new Label("StartX");
		// ���x��ǩ
		lb1.setContentDisplay(ContentDisplay.LEFT);
		lb1.setTextFill(Color.BLUE);
		Label lb2 = new Label("StartY");
		lb2.setContentDisplay(ContentDisplay.LEFT);
		lb2.setTextFill(Color.BLUE);
		HBox hb1 = new HBox(10);
		hb1.getChildren().addAll(lb1, text1, lb2, text2);
		//���ı���ͱ�ǩˮƽ����
		
		TextField text3 = new TextField("7"); 
		// �յ�x����
		settextfiled(text3);
		// �����ı����С
		TextField text4 = new TextField("7"); 
		// �յ�Y����
		settextfiled(text4);
		// �����ı����С
		Label lb3 = new Label("EndX");
		// �յ�x��ǩ
		lb3.setContentDisplay(ContentDisplay.LEFT);
		lb3.setTextFill(Color.BLUE);
		Label lb4 = new Label("EndY");
		lb4.setContentDisplay(ContentDisplay.LEFT);
		lb4.setTextFill(Color.BLUE);
		HBox hb2 = new HBox(10);
		hb2.getChildren().addAll(lb3, text3, lb4, text4);
		//���ı���ͱ�ǩˮƽ����ʹ��hBOX
		
		//**************���ñ���ͼƬ***************//
		Image image = new Image("Background.jpg");
		ImageView background = new ImageView(image);
		background.fitHeightProperty();
		//�ñ���ͼƬ��Ӧ���ڴ�С
		background.fitWidthProperty();
		
		//****************Ϊ�Թ��������******************//
		Pane grid = new Pane();
		Text t3 = new Text("Y || X");
		t3.setStroke(Color.BLUE);
		t3.setX(15);
		t3.setY(15);
		grid.getChildren().add(t3);
		Text[] t1 = new Text[8];
		Text[] t2 = new Text[8];
		for(int i = 0;i<8;i++)
		{
			t1[i] = new Text(Integer.toString(i));
			t2[i] = new Text(Integer.toString(i));
		}
		for(int i = 0;i<8;i++)
			//�������������
		{
			t1[i].setX(i*50+55);
			t1[i].setY(15);
			t1[i].setStroke(Color.BLUE);
			t2[i].setY(i*50+55);
			t2[i].setX(15);
			t2[i].setStroke(Color.BLUE);
			grid.getChildren().add(t1[i]);
			grid.getChildren().add(t2[i]);
		}
		
		//*****************�����Ͽ�ѡ���ͼ****************//
		HBox map2 = new HBox(10);
		String[] map = {"ԭʼ�Թ�","ƽ���Թ�"};
		ComboBox<String> maps = new ComboBox<>();
		Label map1 = new Label("Choose Maze Map");
		map1.setTextFill(Color.BLUE);
		map1.setContentDisplay(ContentDisplay.LEFT);
		maps.getItems().addAll(map);
		maps.setValue(map[0]);
		map2.getChildren().addAll(map1,maps);
		


		VBox vb = new VBox(30);
		vb.getChildren().addAll(hb1, hb2);
		//�������յ��ǩ�ı�����ֱ����ʹ��VBOX
		
		//********     �ڽ�������Ӱ�ť        **************  //
		Button bt1 = new Button("��ʼ���Թ�");
		setbutton(bt1);
		Button bt2 = new Button("Ѱ��·��");
		setbutton(bt2);
		Button bt3 = new Button("�����Թ�");
		setbutton(bt3);
		Button bt4 = new Button("Ѱ�����·��");
		setbutton(bt4);
		Button bt5 = new Button("�˳�");
		setbutton(bt5);
		Button bt6 = new Button("CLEAR");
		setbutton(bt6);
		VBox vbox = new VBox(30);
		vbox.getChildren().addAll(bt1,bt2,bt3,bt4,bt6,bt5); 
		//����ť��ֱ����ʹ��VBOX
		
		VBox sumb = new VBox(30);
		sumb.getChildren().addAll(map2,vb,vbox);
		//**************// ��ⰴť�¼�����Ҫ���������//************//
		
		//*************ѡ���ͼ�¼�***************//
		maps.setOnAction(new EventHandler<ActionEvent>()
		{
			
			@Override
			public void handle(ActionEvent event)
			{
				
			}
		});
		//********���ı����л�ȡ�����յ�**********��//
		//�ж������յ��Ƿ����Թ���
		
			bt1.setOnAction(e ->{
				// ���ı����л�ȡ�����յ�
			    int startx = gettextfiled(text1);
				int starty = gettextfiled(text2);
				int endx = gettextfiled(text3);
				int endy = gettextfiled(text4);
				
				if(isinMaze(startx)&&isinMaze(starty)&&isinMaze(endx)&&isinMaze(endy))
				{
					Maze maze = new Maze(startx, starty, endx, endy, "Maze.txt");
					try
					{
						
						maze.printMaze();
						// ��ʼ���Թ������Թ���ʾ�������
				} catch (Exception e1)
					{
						e1.printStackTrace();
					}
					pan2.getChildren().add(maze);
					//������ʾ��㵽�յ��·��
					bt2.setOnAction(a ->{
						Road road1 = new Road(startx, starty, endx, endy);
						//���ü̳���Pane��Road�໭·��ͼ
						road1.Roadprint();
						pan2.getChildren().add(road1);
						
						
						//**************Ϊ·����Ӷ���*****************//
						
						PathTransition pt = new PathTransition();
						Circle circle = new Circle(5);
						circle.setFill(Color.GREEN);
						pt.setNode(circle);
						pt.setDuration(Duration.millis(8000));
						Path path = new Path();
						MoveTo move = new MoveTo();
						move.setX(startx*50+55);
						move.setY(starty*50+55);
						path.getElements().add(move);
						Stack<Point> stake = road1.stack;
						for(int i = 0; i<stake.size();i++)
						{
							LineTo lt = new LineTo();
							lt.setX(stake.get(i).x*50+55);
							lt.setY(stake.get(i).y*50+55);
							path.getElements().add(lt);
						}
						pt.setPath(path);
						pt.play();
						pan2.getChildren().addAll(circle,path);
					});
					//������ʾ����·��ͼ
					bt3.setOnAction(b ->{	
						//����ť4��������¼�
					Allroad road = new Allroad(startx, starty, endx, endy);
					//���ü̳���Pane��Allroad�໭·��ͼ
					road.Allroadprint();
					pan2.getChildren().add(road);
					ArrayList<Point> list = road.list;
					//Ϊ�������·�߶���
					PathTransition pt = new PathTransition();
					Circle circle = new Circle(5);
					circle.setFill(Color.RED);
					pt.setNode(circle);
					pt.setDuration(Duration.millis(15000));
					Path path = new Path();
					MoveTo move = new MoveTo();
					move.setX(startx*50+55);
					move.setY(starty*50+55);
					path.getElements().add(move);
					for(int i = 0; i<list.size();i++)
					{
						LineTo lt = new LineTo();
						lt.setX(list.get(i).x*50+55);
						lt.setY(list.get(i).y*50+55);
						path.getElements().add(lt);
					}
					pt.setPath(path);
					pt.play();
					pan2.getChildren().addAll(circle,path);
					}
				);
					//********��ť4�������Ѱ��**********************//
					bt4.setOnAction(c ->{
						bt4.setOnAction(d ->
						{
							Best road1 = new Best(startx, starty, endx, endy);
							road1.Roadprint();
							pan2.getChildren().add(road1);
						});
						
					});
				}
				//��������յ㲻���Թ��ڵ������洰��
				else
				{
					Stage stage = new Stage();
					BorderPane pan = new BorderPane();
					Text t = new Text("�õ㲻���Թ���");
					t.setStroke(Color.RED);
					pan.setCenter(t);
					stage.setTitle("Alerm");
					stage.setScene(new Scene(pan,100,20));
					stage.show();
			}
			});
		
		
		
			//********��ť5��������˳�**********************//
			bt5.setOnAction(e -> primaryStage.close() );
			//**************��ť6����������*****************//
			bt6.setOnAction(e ->{
				try
				{
					start(primaryStage);
				} catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		
		pan1.setRight(sumb);//pan1�����洢��ť�ı���
		pan1.setCenter(pan2);
		pan3.getChildren().addAll(background,grid,pan1);
		primaryStage.setTitle("Maze");
		primaryStage.setScene(new Scene(pan3, 700, 500));
		primaryStage.show();
	}
	
	
	
	//**************�����ı���Ĵ�С*************//
	public void settextfiled(TextField text)
	{
		text.setPrefWidth(30);//�ı���Ŀ��
		text.setPrefHeight(10);//�ı���ĸ߶�
	}
	
	
	//**************���ð�ť�Ĵ�С*************//
	public void setbutton(Button bt)
	
	{
		bt.setPrefWidth(100);//��ť�Ŀ��
		bt.setPrefHeight(20);//��ť�ĸ߶�
	}
	
	
	// ********��ȡ�ı�������******//
	public int gettextfiled(TextField text)
	{
		return Integer.parseInt(text.getText());
	}
	
	
	
	//*******�ж�����յ��Ƿ����Թ���*****//
	public boolean isinMaze(int x)
	{
		boolean flag = true;
		if(x<0||x>7)
			flag = false;
		return flag;
	}
}
//**********���������ʾ�Թ�**********************//
class Maze extends Pane
{
	private int count; 
	private int count1 = 0;
	private int length = 50;
	private static File file = null;
	private int startx,starty,endx,endy;
	public Maze()
	{
		this(0,0,7,7,"Maze.txt");
	}
	public Maze(int startx,int starty,int endx,int endy,String name)
	{
		this.startx = startx;
		this.starty = starty;
		this.endx = endx;
		this.endy = endy;
		Maze.file = new File(name);
	}
	
	public static  File getFile()
	{
		return file;
	}
	public void printMaze() throws FileNotFoundException
	{
		Circle c1 = new Circle(startx*length+55, starty*length+55, 10);
		c1.setFill(Color.GREEN);
		Circle c2 = new Circle(endx*length+55, endy*length+55, 10);
		c2.setFill(Color.GREEN);
		try (Scanner input = new Scanner(file);)
		{
			count = (input.nextLine()).split(" ").length;
		}
		int startx = 30, starty = 30, endx = 30, endy = 30;
		try (Scanner input1 = new Scanner(file))
		{
			while (input1.hasNext())
			{
				String str = input1.next();
				// Point �� 1λǽ 0 λ�հ�
				if (str.charAt(3) == '1')
				{
					Line L = new Line(startx, starty, endx, endy + length);
					getChildren().add(L);
				}
				if (str.charAt(0) == '1')
				{
					Line L = new Line(startx, starty, endx + length, endy);

					getChildren().add(L);
				}
				if (str.charAt(1) == '1')
				{
					Line L = new Line(startx + length, starty, endx + length, endy + length);
					getChildren().add(L);
				}
				if (str.charAt(2) == '1')
				{
					Line L = new Line(startx, starty + length, endx + length, endy + length);
					getChildren().add(L);
				}
				count1++;
				//ÿ������startx��starty��ֵΪ��һ��L���յ�����
				startx = (count1 % count) * length + 30;
				starty = (count1 / count) * length + 30;
				endx = startx;
				endy = starty;
				
			}
		}
		getChildren().addAll(c1,c2);
	}
}
//*****************Ѱ··��********************//
class Road extends Pane
{
	private Findroad road = null;
	private int length = 50;;
	public Stack<Point> stack = null;
	public Road(int startx,int starty,int endx,int endy) 
	{
		road = new Findroad(startx,starty,endx,endy);
		try
		{
			road.mazeInformation();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		road.Find();
		stack = road.getStack();
	}
// *****************�������������Թ���ͼ��
	public void Roadprint() 
	{
		for (int i = 0; i < stack.size() - 1; i++)
		{
			Line L = new Line();
			L.setStartX(stack.get(i).x * length + 55);
			L.setStartY(stack.get(i).y * length + 55);
			L.setEndX(stack.get(i + 1).x * length + 55);
			L.setEndY(stack.get(i + 1).y * length + 55);
			L.setStroke(Color.BLUE);
			getChildren().add(L);
		}
	}
}
//***********����·��**************//
class Allroad extends Pane
{
	public ArrayList<Point> list = null;
	private int length = 50;
	public Allroad(int startx,int starty,int endx,int endy) 
	{
		Overroad road1 = new Overroad();
		try
		{
			road1.mazeInformation();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		road1.overfind();
		list = road1.getInterviewed();
	}
	// *****************������������������·��*****************//
	public void Allroadprint() 
	{
		for (int i = 0; i < list.size() - 1; i++)
		{
			Line L = new Line();
			L.setStartX(list.get(i).x * length + 55);
			L.setStartY(list.get(i).y * length + 55);
			L.setEndX(list.get(i + 1).x * length + 55);
			L.setEndY(list.get(i + 1).y * length + 55);
			L.setStroke(Color.RED);
			getChildren().add(L);
		}
	}
}
//*******************Ѱ��·��***********************
class Best extends Pane
{
	private Findbest road = null;
	private int length = 50;;
	public Stack<Point> stack = null;
	public Best(int startx,int starty,int endx,int endy) 
	{
		road = new Findbest(startx,starty,endx,endy);
		try
		{
			road.getMaze();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		road.Find();
		stack = road.stack;
	}

	public void Roadprint() 
	{
		for (int i = 0; i < stack.size() - 1; i++)
		{
			Line L = new Line();
			L.setStartX(stack.get(i).x * length + 55);
			L.setStartY(stack.get(i).y * length + 55);
			L.setEndX(stack.get(i + 1).x * length + 55);
			L.setEndY(stack.get(i + 1).y * length + 55);
			L.setStroke(Color.BLUE);
			getChildren().add(L);
		}
	}
}


