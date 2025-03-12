package CRUD_Oparaions_Using_SPring.SPring_JDBC;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.resources.Springconfig;
import com.rowmapper.StudentRowMapper;
import com.student.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	static Scanner sc=new Scanner(System.in);
    public static void main( String[] args )
    {
        ApplicationContext context= new AnnotationConfigApplicationContext(Springconfig.class);
        JdbcTemplate jd=context.getBean(JdbcTemplate.class);
        System.out.println("Choose Below One Option");
        System.out.println("1.INSERT    2.UPDATE    3.DELETE    4.RETRIVE");
        int n=sc.nextInt();
        if(n==1)
        {
        	insertStudent(jd);
        }
        else if(n==2)
        {
        	updateStudent(jd);
        }
        else if(n==3)
        {
        	deletStudent(jd);
        }
        else if(n==4)
        {
        	retriveStudent(jd);
        }
        else
        {
        	System.out.println("Invalid-Option");
        	invalidCase(jd);
        }
    }
    public static void invalidCase(JdbcTemplate jd)
    {
    	 System.out.println("Choose Below One Option");
         System.out.println("1.INSERT    2.UPDATE    3.DELETE    4.RETRIVE");
         int n=sc.nextInt();
         if(n==1)
         {
         	insertStudent(jd);
         }
         else if(n==2)
         {
         	updateStudent(jd);
         }
         else if(n==3)
         {
         	deletStudent(jd);
         }
         else if(n==4)
         {
         	retriveStudent(jd);
         }
         else
         {
         	System.out.println("Invalid-Option");
         	invalidCase(jd);
         }
    }
    public static void insertStudent(JdbcTemplate jd)
    {
    	try {
    	String qry="insert into student values(?,?,?)";
    	System.out.println("Enter Student id:");
    	int n=sc.nextInt();
    	System.out.println("Enter Student Name:");
    	String name=sc.next();
    	System.out.println("Enter Student Marks:");
    	float m=sc.nextFloat();
    	int n1=jd.update(qry,n,name,m);
    	if(n1>0)
    	{
    		System.out.println("Data Insert Succesfully");
    	}
    	else
    	{
    		System.out.println("Data Insertion Failed");
    		System.out.println("Enter Data  Reagin.");
    		insertStudent(jd);
    	}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
   
    		
    	}
    }
    public static void updateStudent(JdbcTemplate jd)
    {
    	System.out.println("Enter Update name:");
    	String name=sc.next();
    	System.out.println("Enter Update Marks:");
    	float f=sc.nextFloat();
    	System.out.println("Enter Update Coloumn Id:");
    	int n=sc.nextInt();
    	String qry="update student SET s_name=?,s_marks=? where s_id=?";
    	int n1=jd.update(qry,name,f,n);
    	if(n1>0)
    	{
    		System.out.println("Data Update Succesfully");
    	}
    	else
    	{
    		System.out.println("Data Updation Failed");
    	}
    }
    public static void deletStudent(JdbcTemplate jd)
    {
    	System.out.println("Enter Delete cColoumn ID:");
    	int n=sc.nextInt();
    	String qry="delete from student where s_id=?";
    	int n1=jd.update(qry,n);
    	if(n1>0)
    	{
    		System.out.println("Delete Row Successfully");
    	}
    	else
    	{
    		System.out.println("Deletion failed");
    	}
    }
    public static void retriveStudent(JdbcTemplate jd) {
        String qry = "select * from student";
        List<Student> ls = jd.query(qry, new StudentRowMapper());
        System.out.println("----------------------------------");
        String format = "%-5s %-10s %-6s%n"; // Adjust format as needed
        for (Student s : ls) {
            System.out.printf(format, s.getId(), s.getName(), s.getMarks());
        }
        System.out.println("----------------------------------");
    }

}
