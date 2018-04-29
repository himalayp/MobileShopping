package com.himalay.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.himalay.DAO.SupplierDAO;
import com.himalay.DAO.UserDAO;
import com.himalay.model.Supplier;
import com.himalay.model.User;

public class SupplierDAOTest {

	public static AnnotationConfigApplicationContext context;
	 static Supplier supplier;
	 SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.himalay");
		context.refresh();
	}

	/*@Test
	public void insert() 
	{

		Supplier supplier=new Supplier();
		supplier.setSuppname("Aneesh");
		supplier.setAddress("Andheri - I.C. Colony");
		supplierDAO.insertUpdateSupplier(supplier);		
		System.out.println("Supplier Inserted");
		assertNotNull(true);
	}*/
	
	/*@Test
	public void retrieve()
	{
		Supplier supplier=supplierDAO.getSupplier(5);
		System.out.println("Supplier Name:"+supplier.getSuppname());
		System.out.println("Supplier Address:"+supplier.getAddress());
		assertNotNull(true);
	}*/

	/*@Test
	public void delete()
	{
		Supplier supplier=supplierDAO.getSupplier(5);
		supplierDAO.deleteSupplier(supplier);
		System.out.println("The Supplier Deleted");
	}*/
	
	/*@Test
	public void list()
	{

		List<Supplier> list=supplierDAO.getSupplierDetails();
		
		for(Supplier supplier:list)
		{
			System.out.println(supplier.getSuppid()+":"+supplier.getSuppname()+":"+supplier.getAddress());
		}
	}*/
	
	@Test
	public void update()
	{
		Supplier supplier=supplierDAO.getSupplier(8);
		supplier.setSuppname("Srinidhi");
		supplier.setAddress("kandivali");	
		supplierDAO.insertUpdateSupplier(supplier);
		System.out.println("The Supplier Updated");
	}
}
