package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.himalay.DAO.CategoryDAO;
import com.himalay.DAO.ProductDAO;
import com.himalay.model.Category;
import com.himalay.model.Product;

@Controller
public class ProductController 
{
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;
	@RequestMapping("/Product")
	public String showProduct(Model m)
	{
		Product product=new Product();
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("product",product);
		List<Product> prodlist=productDAO.getProductDetails();
		
		m.addAttribute("prodlist",prodlist);
		return "Product";
	}
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product") Product product,Model m,@RequestParam("pimage") MultipartFile filedet,BindingResult result)
	{
		System.out.println("---Product Inserted---");
		System.out.println(product.getProdid());
		productDAO.insertUpdateProduct(product);
		
		 //started multipath image adding 
		System.out.println("---Images Storing Started -------");
		String path="D:\\MyDEVOP_Project\\MobiWorld\\src\\main\\webapp\\resources\\images\\";
		String fileinfo=path+product.getProdid()+".jpg";
		File f=new File(fileinfo);
		
		if(!filedet.isEmpty())
		{
			try
			{
				byte buff[]=filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(f);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buff);
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised " );
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("---File uploading problem---");
		}
		
		System.out.println("---Images Stored----");
		// done for multipath image adding completed 
		
		List<Product> prodlist=productDAO.getProductDetails();

		m.addAttribute("prodlist",prodlist);
		return "Product";
	}
	@RequestMapping(value="/updateProduct/{prodid}")
	public String updateProduct(@PathVariable("prodid")int prodid,Model m)
	{
		System.out.println("Updating product with id : "+prodid);
		Product product=productDAO.getProduct(prodid);
		m.addAttribute("product",product);
		System.out.println("product : "+product);
		m.addAttribute("catlist",this.getCatList());
		List<Product> prodlist=productDAO.getProductDetails();
		
		m.addAttribute("prodlist",prodlist);
		return "Product";
	}

	
	@RequestMapping(value="/deleteProduct/{prodid}")
	public String deleteProduct(@PathVariable("prodid")int prodid,Model m)
	{
		Product product=productDAO.getProduct(prodid);
		productDAO.deleteProduct(product);
		Product product1=new Product();
		m.addAttribute("product",product1);
		m.addAttribute("catlist",this.getCatList());
		List<Product> prodlist=productDAO.getProductDetails();
		
		
		m.addAttribute("prodlist",prodlist);
		return "Product";
	}
	public LinkedHashMap<Integer,String> getCatList()
	{
		List<Category> list=categoryDAO.getCategoryDetails();
		LinkedHashMap<Integer,String> catlist=new LinkedHashMap<Integer,String>();
		for(Category cat:list)
		{
			catlist.put(cat.getCatid(),cat.getCatname());
		}
		return catlist;
	}
	// added to display the product with image
	@RequestMapping(value="/displayProduct")
	public String displayProduct(Model m)
	{
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		return "UserHome"; //wrote productdesc instead of ProductPage
	}

	
	@RequestMapping(value="/ProdDesc/{prodid}")
	public String showProductDesc(@PathVariable("prodid") int prodid, Model m)
	{
		System.out.println("Cart product with id : "+prodid);
		Product product=productDAO.getProduct(prodid);
		m.addAttribute("product",product);
		System.out.println("product : "+product);
		m.addAttribute("catlist",this.getCatList());
		List<Product> prodlist=productDAO.getProductDetails();
		
		m.addAttribute("prodlist",prodlist);
		return "ProductDesc";
	}
}
		