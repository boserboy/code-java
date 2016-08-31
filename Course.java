package part11;

import java.util.ArrayList;
import java.util.Scanner;

public class Course
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Course course =new Course("English");
		int i=1;
		while(i<10)
		{
			String student=in.nextLine();
			course.addStudent(student);
			i++;
		}
		course.dropStudent("1");
		System.out.println(course.getCoursename()+course.getNumcberifstudents()+course.getStudents());
		in.close();
	}
	private String coursename;
    private ArrayList<String> students = new ArrayList<> ();
    private int numcberifstudents=0;
    public Course(String cousename)
    {
    	this.coursename=cousename;
    }
	public String getCoursename()
	{
		return coursename;
	}
	public ArrayList<String> getStudents()
	{
		return students;
	}
	public int getNumcberifstudents()
	{
		
		return numcberifstudents;
	}
    public void addStudent(String student)
    {
    	students.add(student);
    	numcberifstudents++;
    }
    public void dropStudent(String student)
    {
    	for(int i=0;i<students.size();i++)
		{
			if(student.equals(students.get(i)))
			{
				students.remove(i);
				numcberifstudents--;
				break;
			}					
		}
    	
    }

}
