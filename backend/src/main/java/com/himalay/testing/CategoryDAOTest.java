package com.himalay.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.himalay.DAO.CategoryDAO;
import com.himalay.DAO.UserDAO;
import com.himalay.model.Category;
import com.himalay.model.User;

public class CategoryDAOTest {

	public static AnnotationConfigApplicationContext context;	
	static Category category;
	CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.himalay");
		context.refresh();
	}

	/*@Test
	public void insert() {

		Category category=new Category();		
		category.setCatname("WIFIMobile");
		category.setCatdesc("This Mobile is WIFI Enabled. You can Enjoy Internet");
		categoryDAO.insertUpdateCategory(category);		
		System.out.println("Category Inserted");
		assertNotNull(true);
	}*/
	
	/*@Test
	public void retrieve()
	{
		Category category=categoryDAO.getCategory(1);
		System.out.println("Category Name:"+category.getCatname());
		System.out.println("Category Description:"+category.getCatdesc());
		assertNotNull(true);
	}*/

	/*@Test
	public void delete()
	{
		//Deletion TestCase
	Category category=categoryDAO.getCategory(11);
	categoryDAO.deleteCategory(category);
	System.out.println("The Category Deleted");
	}*/
	
	/*@Test
	public void list()
	{
	//Retrieving the Data
	
	List<Category> list=categoryDAO.getCategoryDetails();
	
	for(Category category:list)
	{
		System.out.println(category.getCatid()+":"+category.getCatname()+":"+category.getCatdesc());
	}*/
	
	@Test
	public void update()
	{
		//Update the Category
	Category category=categoryDAO.getCategory(12);
	category.setCatname("WifiEnMobile");
	categoryDAO.insertUpdateCategory(category);
	System.out.println("The Category Updated");
	}
}

