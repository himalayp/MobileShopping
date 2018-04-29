package com.himalay.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

    @Entity
    @Table
    public class Product {
     
    	@Id
    	@GeneratedValue (strategy=GenerationType.IDENTITY)
    	int prodid;
    	
   // 	@Size(min=5, max=10, message="Your name should be between 5 - 10 characters.")
    	String prodname;
    	
    	int catid,suppid;
    	int quantity,price;
    //	@Min(value=5, message="Please insert at least 5 characters")
    	String prodDesc;
    	
    	@Transient
        MultipartFile pimage;
    	
		public MultipartFile getPimage() {
			return pimage;
		}
		public void setPimage(MultipartFile pimage) {
			this.pimage = pimage;
		}
		
    	public int getProdid() {
			return prodid;
		}
		public void setProdid(int prodid) {
			this.prodid = prodid;
		}
		public String getProdname() {
			return prodname;
		}
		public void setProdname(String prodname) {
			this.prodname = prodname;
		}
		public int getCatid() {
			return catid;
		}
		public void setCatid(int catid) {
			this.catid = catid;
		}
		public int getSuppid() {
			return suppid;
		}
		public void setSuppid(int suppid) {
			this.suppid = suppid;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getProdDesc() {
			return prodDesc;
		}
		public void setProdDesc(String prodDesc) {
			this.prodDesc = prodDesc;
		}
    	
    }