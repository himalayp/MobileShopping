package com.himalay.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.himalay.DAO.CartDAO;
import com.himalay.model.Cart;
import com.himalay.model.Category;

public class CartDAOTest {
	public static AnnotationConfigApplicationContext context;	
	static Cart cart;
	CartDAO cartDAO=(CartDAO)context.getBean("cartDAO");
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.himalay");
		context.refresh();
	}
//insert
/*@Test
public void insert()
{
	Cart cart=new Cart();
	cart.setCartid(1001);
	cart.setProdid(4);
	cart.setProdname("Samsung OnNxt");
	cart.setPrice(15000);
	cart.setQuantity(7);
	cart.setStatus("N");
	cart.setUsername("Vineet");
	
	cartDAO.addToCart(cart);
	System.out.println("Added to the Cart");
	assertNotNull(true);
}	*/
	
/*	@Test
	public void delete()
	{
	//Deleting TestCase
	Cart cart=cartDAO.getCartItem(2);
	cartDAO.deleteCartItem(cart);
	System.out.println("The Cart Deleted");
	}*/	
	//Displaying TestCase
	/*@Test
	public void list()
	{

	List<Cart> list=cartDAO.getCartItems("Vineet");
	
	for(Cart cart:list)
	{
		System.out.println(cart.getCartid() +":::");
		System.out.println(cart.getProdid()+":::");
		System.out.println(cart.getProdname()+":::");
		System.out.println(cart.getPrice()+":::");
		System.out.println(cart.getQuantity()+":::");
	}
	
	System.out.println("Cart item Displayed:");
	}
	*/
	// Update TestCase
	@Test
	public void update()
	{
	Cart cart=cartDAO.getCartItem(13);
	cart.setProdname("Samsung 8");
	cartDAO.updateCartItem(cart);
	System.out.println("The Cart Updated");
}
}
