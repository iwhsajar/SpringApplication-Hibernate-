package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		
        /*
		 * Student student = new Student(13812, "Rajashwi Shrestha", "Kathmandu");
		 * 
		 * int r = studentDao.insert(student); System.out.println("Done   " +r);
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go=true;
        while(go) {
    	   
           System.out.println("PRESS 1 for add new student");
           System.out.println("PRESS 2 for display all students");
           System.out.println("PRESS 3 for get detail of single student");
           System.out.println("PRESS 4 for for delete students");
           System.out.println("PRESS 5 for update student");
           System.out.println("PRESS 6 for add exit");
           
           try {
        	   int input = Integer.parseInt(br.readLine());
        	   switch (input) {
			case 1:
				//add a new student
				System.out.println("Enter user id:");
				int uId=Integer.parseInt(br.readLine());
				
				//Taking input from student
				System.out.println("Enter user name:");
				String uName = br.readLine();
				
				System.out.println("Enter user city:");
				String uCity = br.readLine();
				
				Student s = new Student();
				s.setStudentId(uId);
				s.setStudentName(uName);
				s.setStudentCity(uCity);
				
				int r = studentDao.insert(s);
				System.out.println(r+" :Student with given id is added");
				System.out.println("***********************************");
				System.out.println();
				
				break;
			case 2:
				//display all student
				System.out.println("***********************************");
				List<Student> allStudents = studentDao.getAllStudents();
				for(Student st:allStudents)
				{
					System.out.println("Id: "+st.getStudentId());
					System.out.println("Name: "+st.getStudentName());
					System.out.println("City: "+st.getStudentCity());
					System.out.println("___________________________________________");
				}
				System.out.println("***********************************");
				break;
			case 3:
				//get single student data
				System.out.println("Enter user id: ");
				int userId = Integer.parseInt(br.readLine());
				Student student = studentDao.getStudent(userId);
				System.out.println("Id: "+student.getStudentId());
				System.out.println("Name: "+student.getStudentName());
				System.out.println("City: "+student.getStudentCity());
				System.out.println("___________________________________________");
				
				break;
			case 4:
				//delete student
				System.out.println("Enter user id: ");
				int id = Integer.parseInt(br.readLine());
				studentDao.deleteStudent(id);
				System.out.println("Student details deleted.....");
				break;
			case 5:
				System.out.println("********************************************");
    			System.out.println("Enter Id of the Student to be update:");
    			int sId = Integer.parseInt(br.readLine());
    			System.out.println("Enter the Student Name to be update:");
    			String sName = br.readLine();
    			System.out.println("Enter the Student City to be update:");
    			String sCity = br.readLine();
    			
    			Student std = new Student();
    			std.setStudentId(sId);
    			std.setStudentName(sName);
    			std.setStudentCity(sCity);
    			studentDao.updateStudent(std);
    			System.out.println("Student details Updated....");
    			System.out.println("***********************************************");
    			break;
			case 6:
				//exit
				go = false;
				break;
			}
           }catch(Exception e){
        	   System.out.println("Invalid Input Try with another one!!");
        	   System.out.println(e.getMessage());
           }
        }
        System.out.println("Thank you for using my application");
        System.out.println("See ya soon!");
    }
}
