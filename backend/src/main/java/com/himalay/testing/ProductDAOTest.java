package com.himalay.testing;

import static org.junit.Assert.*;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.himalay.DAO.ProductDAO;
import com.himalay.model.Product;

import org.junit.Test;

public class ProductDAOTest {
	public static AnnotationConfigApplicationContext context;	
	public static ProductDAO productDAO;	
	 static Product product;

	 @BeforeClass
		public static void init() {
			context = new AnnotationConfigApplicationContext();
			context.scan("com.himalay");
			context.refresh();
			product=new Product();
			productDAO = (ProductDAO)context.getBean("productDAO");
		}
	/*@Test
	public void addProduct()
	{
		product.setProdname("Iphone X");
		product.setProdDesc("This Mobile uses 4G technology.");
		product.setQuantity(60);
		product.setPrice(121000);
		System.out.println("Moving to DAO...");
		productDAO.insertUpdateProduct(product);
		assertNotNull(product);
	}*/
/*@Test
public void delete()
{
	Product product=productDAO.getProduct(1);
	productDAO.deleteProduct(product);
	System.out.println("The Product Deleted");
	assertNull(product);
	
}
*/
/*@Test
	 public void retrieve()
	 {
		 List<Product> list=productDAO.getProductDetails();
			
			for(Product product:list)
			{
				System.out.println(product.getProdid()+":"+product.getCatid()+":"+product.getSuppid()+":"+product.getProdname()+":"+product.getQuantity()+":"+product.getPrice()+":"+product.getProdDesc());
			}
	 }*/

	/* @Test
	 public void update()
	 {
		 Product product=productDAO.getProduct(2);
			product.setProdname("Samsung S9");
			productDAO.insertUpdateProduct(product);
			System.out.println("The Product Updated");
	 }*/
}
