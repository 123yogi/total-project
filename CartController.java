package com.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;

@Controller

public class CartController 
{
	@Autowired
	ChairService bsss;
	@Autowired
	CartDAO cd1;
	@Autowired
	UserDAO ua;
	@Autowired
	SessionFactory sf;
		
	   @ModelAttribute("cartItem")
	    public CartItem fun100()
	    {
	    	return new CartItem();
	    }
	
	 @RequestMapping(value="viewcart",method=RequestMethod.GET)
		public String vcHello(@RequestParam int chairId)
		{  
	    System.out.println("Id..........."+chairId);
	    System.out.println("hello my sweet heart.................");
	    Chair chair=bsss.getSingleChair(chairId);
	    CartItem cartItem=new CartItem();
	    // cart.setGrandTotal(chair.getChairPrice());
	   	System.out.println(chair.getChairId());
	   	List list=cd1.getAllItems();
	   	System.out.println("List size......."+list.size());
	   	for(int i=0;list.size()>i;i++)
	   	{
	   	  CartItem cti=(CartItem)list.get(i);
	   	  if(chairId==cti.getChairId())
	   	  {
	   		    		  
	   		  System.out.println("yogi");
	    cartItem.setChairId(chair.getChairId());
	    cartItem.setChairName(chair.getChairName());
	    cartItem.setChairPrice(chair.getChairPrice());
	    cartItem.setChairDesc(chair.getChairDesc());
	   cartItem.setChairStyle(chair.getChairStyle());
	   cartItem.setQuantity(cartItem.getQuantity()+1+cti.getQuantity());
	   System.out.println("#######"+cartItem.getQuantity());
	    cartItem.setChairPrice(chair.getChairPrice()*cartItem.getQuantity());
	     System.out.println("#######"+cartItem.getChairPrice());
	    cd1.add(cartItem);
        int count=cartItem.getCartItemId();
        cd1.remove(--count);
       
	    
	    return "viewCart";
	   	}
	   	}
	   	System.out.println("reddy");
	   	cartItem.setChairId(chair.getChairId());
	    cartItem.setChairName(chair.getChairName());
	    cartItem.setChairPrice(chair.getChairPrice());
	    cartItem.setChairDesc(chair.getChairDesc());
	    cartItem.setChairStyle(chair.getChairStyle());
	    cartItem.setQuantity(cartItem.getQuantity()+1);
	    System.out.println("#######"+cartItem.getQuantity());
	    cartItem.setChairPrice(chair.getChairPrice()*cartItem.getQuantity());
	    System.out.println("#######"+cartItem.getChairPrice());
	    cd1.add(cartItem);    
		  
	    return "viewCart";
	    }
		  
	 @RequestMapping(value="/listone",method=RequestMethod.GET,produces="application/json")
	    public @ResponseBody String showListOne(){
	    	List blist=cd1.getAllItems();
	    	Gson x=new Gson();
	    	String json=x.toJson(blist);
	    	return json;
	    }
	 @RequestMapping("/deleteItemCart")
	    public ModelAndView deleteChair(@RequestParam int id)
	    {
		 System.out.println("------------"+id+"-----------");
		 System.out.println("hello welcome to cart");
         cd1.remove(id);
	    	return new ModelAndView("viewCart");
	    }
	 @RequestMapping("/removeAll")
	 public ModelAndView removeAllItem()
	 {
		 cd1.removeAll();
		 return new ModelAndView("viewCart");
	 }
	 @RequestMapping("/alert")
	 public ModelAndView dis()
	 {
		  return new ModelAndView("alert");
	 }
	 @RequestMapping("/v1")
	 public ModelAndView disp()
	 {
		  return new ModelAndView("ViewPro");
	 }
	 @RequestMapping(value="hello")
	    public ModelAndView createOrder(HttpSession session,Model m1)
		{
		 String name=(String)session.getAttribute("loggedInUser");
		 Session s1=sf.openSession();
		 Transaction t=s1.beginTransaction();
		 Query q=s1.createQuery("from User where name='"+name+"'");
	     List<User> li=q.list();
	      User count=li.get(0);
	     User user=(User)s1.get(User.class,count.getId());
		 System.out.println(user.getName()+"hello hello");
		 System.out.println("#########################"+name+"@@@@@@@@@@@@@@@@@@@@@@"); 
		 BillingAddress ba=new BillingAddress();
		 ba.setStreetName(user.getStreetName());
		 ba.setApartmentNumber(user.getApartmentNumber());
		 ba.setCity(user.getCity());
		 ba.setState(user.getState());
		 ba.setCountry(ba.getCountry());
		 ba.setZipCode(user.getZipCode());
		 ShippingAddress sa=new ShippingAddress();
		 sa.setStreetName(user.getStreetName());
		 sa.setApartmentNumber(user.getApartmentNumber());
		 sa.setCity(user.getCity());
		 sa.setState(user.getState());
		 sa.setCountry(ba.getCountry());
		 sa.setZipCode(user.getZipCode());	
		 m1.addAttribute("user1",new User());
		 System.out.println(ba.getApartmentNumber());
		 System.out.println(ba.getState());
		 ModelAndView m3=new ModelAndView("collectCustomerInfo","User",user);
		 return m3;
			
	    }
	 @RequestMapping(value="collectCustomerInfo",method=RequestMethod.GET)
	    public ModelAndView fun1001()
	    {
	    	return new ModelAndView ("collectCustomerInfo");
	    }
	 @ModelAttribute("User")
	    public User fun1002()
	    {
	    	return new User();
	    }
	 @RequestMapping(value="orderConfirmation",method=RequestMethod.GET)
	    public ModelAndView fun1009()
	    {
	    	return new ModelAndView ("orderConfirmation");
	    }
	 @RequestMapping(value="hellohi")
	 public ModelAndView fun1003(HttpSession session,Model m1)
	 {
		 String name=(String)session.getAttribute("loggedInUser");
		 Session s1=sf.openSession();
		 Transaction t=s1.beginTransaction();
		 Query q=s1.createQuery("from User where name='"+name+"'");
	     List<User> li=q.list();
	      User count=li.get(0);
	     User user=(User)s1.get(User.class,count.getId());
	     System.out.println(user.getApartmentNumber());
	     System.out.println(user.getMail());
		 return new ModelAndView("orderConfirmation","User",user);
	 }
	 
	 @RequestMapping(value="viewCart1",method=RequestMethod.GET)
	    public ModelAndView fun1090()
	    {
	    	return new ModelAndView ("viewCart1");
	    }
	 @RequestMapping(value="checkOutCancelled",method=RequestMethod.GET)
	    public ModelAndView fun1091()
	    {
	    	return new ModelAndView ("checkOutCancelled");
	    }
	 @RequestMapping(value="thankCustomer",method=RequestMethod.GET)
	    public ModelAndView fun1092()
	    {
	    	return new ModelAndView ("thankCustomer");
	    }
	
	
	 
	 
}
