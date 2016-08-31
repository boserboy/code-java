package part13;

public class Text13_16
{
	public static void main(String[] args)
	{
		System.out.println(pasent("3/4+1/5"));
	}
	public static String pasent(String s)
	{
		int a,b,c,d;
		try
		{
			
			String[] str = s.split("[+]");//转译字符要使用[]括起来
			if(str.length!=2)
				throw new Exception();
			String[] str1=str[0].split("/");
			a=Integer.parseInt(str1[0]);
			b=Integer.parseInt(str1[1]);
			String[] str2=str[1].split("/");
			c=Integer.parseInt(str2[0]);
			d=Integer.parseInt(str2[1]);
			int e=a*d+c*b;
			int f=b*d;
			return a+"/"+b+"+"+c+"/"+d+"="+e+"/"+f;
		}
		catch(Exception e)
		{
			return "错误";
	
		}
	}
}
