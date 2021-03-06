package com.himalay.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.himalay.model.*;

@Repository("cartDAO")
public class CartDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CartDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void addToCart(Cart cartitem)
	{
		Session session=sessionFactory.getCurrentSession();    /// this both can also
		session.saveOrUpdate(cartitem);                        //  be in one line...
	}
    
	public List<Cart> getCartItems(String username)
	{
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Query query=session.createQuery("from Cart where username=:username and status='N'");
		query.setParameter("username",username);
		List<Cart> list=query.list();
		return list;
		
	}
	
	@Transactional
	public void deleteCartItem(Cart cart)
	{
		sessionFactory.getCurrentSession().delete(cart);
	}
	
	public Cart getCartItem(int citemid)
	{
		Session session=sessionFactory.openSession();
		Cart cart=(Cart)session.get(Cart.class,citemid);
		return cart;
	}
	
	@Transactional
	public void updateCartItem(Cart cart)
	{
		sessionFactory.getCurrentSession().update(cart);
	}
}