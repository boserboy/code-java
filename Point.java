package Computermouse;

public class Point
{
	int x;//�Թ������x����
	int y;//�Թ������y����
	//�Թ������������Ϣ��0Ϊ��ǽ1λ��ǽ
	public char top='1';//��
	public char left='1';//��
	public char right='1';//��
	public char bottom='1';//��
	public int length = 1;//�����������ڽ����߱���ʹ��
	public boolean isinterviewed = false;//�Ƿ񱻷��ʹ�
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
	//���ø÷��䱻���ʹ�
	public void setinterviewed()
	{
		isinterviewed = true;
	}
}
