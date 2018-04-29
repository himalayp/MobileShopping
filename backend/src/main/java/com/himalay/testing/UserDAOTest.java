package com.himalay.testing;





import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.himalay.DAO.UserDAO;
import com.himalay.model.User;

public class UserDAOTest {
	public static AnnotationConfigApplicationContext context;	
//	public static UserDAO userDAO;	
	 static User user;
	 UserDAO userDAO=(UserDAO)context.getBean("userDAO");
	 @BeforeClass
		public static void init() {
			context = new AnnotationConfigApplicationContext();
			context.scan("com.himalay");
			context.refresh();
			//user=new User();
			
	 }
			//Inserting User
	/*	@Test
		public void insert()
		{
			User user=new User();
			
			user.setUsername("Himalay");
			user.setPassword("abc@123");
			user.setCustname("himalay");
			user.setEmail("himalay@gmail.com");
			user.setEnabled(true);
			user.setCustaddress("303,Pavsha,kandivali(w)");
			userDAO.insertUpdateUser(user);		
			System.out.println("Username Inserted");
			assertNotNull(true);
			
		}*/
		
		/*@Test
		public void retrieve()
		{
		User user=userDAO.getUser(3);
		System.out.println("User Name:"+user.getUsername());
		System.out.println("User Password:"+user.getPassword());
		assertNotNull(true);

		}*/
	 
	 /*@Test
	 public void delete()
	 {
		 User user=userDAO.getUser(3);
			userDAO.deleteUser(user);
			System.out.println("The Username Deleted");
			assertNotNull(user);
	 }*/
	 
	/* @Test
	 public void list()
	 {
		 List<User> list=userDAO.getUserDetails();
		 for(User user:list)
			{
				System.out.println(user.getUserid()+":"+user.getUsername()+":"+user.getPassword());
			}
	 }*/
	 
	 @Test
	 public void update()
	 {
		 User user=userDAO.getUser(4);
			user.setUsername("himalayp");
			userDAO.insertUpdateUser(user);
			System.out.println("The Username Updated");
	 }
	 }

