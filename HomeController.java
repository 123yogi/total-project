package com.controller;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transaction;
import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController
{	
	@Autowired
	ChairService bs;
	@Autowired
	UserDAO us;
	@Autowired
	UserDAO1 us1;
	@Autowired
	SessionFactory sessionFactory;
	private boolean User;
	@RequestMapping("/")
	public ModelAndView helloWorld()
	{  
		       ModelAndView m1=new ModelAndView("index");
		       return m1; 
	}
	@RequestMapping("/home")
	public ModelAndView home()
	{  
		       
		       ModelAndView m1=new ModelAndView("home");
		       return m1; 
	}
	@RequestMapping("/login")
	public ModelAndView Login()
	{  
		       
		       ModelAndView m1=new ModelAndView("Login1");
		       return m1; 
	}
	@RequestMapping("/loginone")
	public ModelAndView LoginOne()
	{  
		       
		       ModelAndView m1=new ModelAndView("userLogin");
		       return m1; 
	}
	@RequestMapping("/search")
	public ModelAndView Enter()
	{  
		       
		       ModelAndView m1=new ModelAndView("search");
		       return m1; 
	}
	
	@RequestMapping("/ret")
	public ModelAndView retriveRecords()
	{  
		ModelAndView m1=new ModelAndView("retrive");
		return m1;
	} 
	@RequestMapping("/ret1")
	public ModelAndView retriveRecords1()
	{  
		System.out.println("yogi***********8retrive");
		ModelAndView m1=new ModelAndView("retrive1");
		System.out.println("################################");
		return m1;
	} 
	
	@RequestMapping("/view1")
	public ModelAndView viewOne()
	{  
		       
		       ModelAndView m1=new ModelAndView("view1");
		       return m1; 
	}
	 @RequestMapping("/newchair")
	    public ModelAndView showForm()
	    {
	    	ModelAndView m1=new ModelAndView("addChair");
	    	return m1;
	    }
	 @ModelAttribute("chair")
	    public Chair createChair()
	    {
	    	return new Chair();
	    }
	 @RequestMapping("/storechair")
	    public String addChairs(HttpServletRequest request,@Valid @ModelAttribute("chair")Chair chair,BindingResult result)
	           {
		 System.out.println("hello niit...........................");
	        	if(result.hasErrors())
	        	{
	        		return "addChair";
	        	}
	        	String filename=chair.getImg().getOriginalFilename();
	        	chair.setImage(filename);
	        	
	        	try{
	        		byte[] bytes=new byte[chair.getImg().getInputStream().available()];
	        		chair.getImg().getInputStream().read(bytes);
	        		BufferedInputStream buffer=new BufferedInputStream(chair.getImg().getInputStream());
	        		MultipartFile file=chair.getImg();
	        		String path=request.getServletContext().getRealPath("/")+"resources/images";
	        		File rootPath=new File(path);
	        		if(!rootPath.exists())
	        			rootPath.mkdirs();
	        		File store=new File(rootPath.getAbsolutePath()+"/"+filename);
	        		System.out.println("Image path :"+path);
	        		OutputStream os=new FileOutputStream(store);
	        		os.write(bytes);
	        	}
	        	catch(Exception e){
	        		System.out.println(e.getMessage());
	        	}
	        	bs.addChair(chair);
	        	//return "ViewAll";
	        	return "retrive";
	        }
	        
	        @RequestMapping("upload")
	        public ModelAndView upload(){
	        	
	        	return new ModelAndView("file");
	        }
	    	
		 @RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json")
	    public @ResponseBody String showList(){
	    	List blist=bs.getAllChairs();
	    	Gson x=new Gson();
	    	String json=x.toJson(blist);
	    	return json;
	    }
		 @RequestMapping("/delete")
		    public ModelAndView deleteChair(@RequestParam int id)
		    {
			 System.out.println("hello welcome to niit");
			    bs.deleteChair(id);
		    	ModelAndView model=new ModelAndView("retrive");
		    	return model;
		    }
		 @RequestMapping(value="editChair",method=RequestMethod.GET)
		    public ModelAndView editChair(@RequestParam int id){
			 System.out.println("hello niit.........................niit1............");	
			 Chair chair1=bs.getSingleChair(id);
			 System.out.println("hello niit.........................niit2............");
			 System.out.println("eeee "+chair1.getChairName());
		    	return new ModelAndView("editChair","chair",chair1);
		    }
		    
		    @RequestMapping(value="/update",method=RequestMethod.POST)
		    public ModelAndView updateChair(HttpServletRequest request,@Valid @ModelAttribute("chair")Chair chair,BindingResult result)
		    {
		    	
		    	String filename=chair.getImg().getOriginalFilename();
		    	
	        	chair.setImage(filename);
	        	
		    	try{
	        		byte[] bytes=new byte[chair.getImg().getInputStream().available()];
	        		chair.getImg().getInputStream().read(bytes);
	        		BufferedInputStream buffer=new BufferedInputStream(chair.getImg().getInputStream());
	        		MultipartFile file=chair.getImg();
	        		String path=request.getServletContext().getRealPath("/")+"resources/images";
	        		File rootPath=new File(path);
	        		if(!rootPath.exists())
	        			rootPath.mkdirs();
	        		File store=new File(rootPath.getAbsolutePath()+"/"+filename);
	        		System.out.println("Image path :"+path);
	        		OutputStream os=new FileOutputStream(store);
	        		os.write(bytes);
	        	}
	        	catch(Exception e){
	        		System.out.println(e.getMessage());
	        	}
	        		        
		    	bs.updateChair(chair);
		    	return new ModelAndView("retrive");
		    }
		    @ModelAttribute("chairs")
		    public Chair objChair(){
		    	return new Chair();
		    }
		    @RequestMapping(value="viewPro",method=RequestMethod.GET)
		    public ModelAndView viewPro(@RequestParam int id, @ModelAttribute Chair chairs){
		    	Chair chair=bs.getSingleChair(id);
		    	return new ModelAndView("ViewPro","chair",chair);
		    	//return new ModelAndView("ViewPro");
		    }
		    @RequestMapping("/newuser")
		    public String showUserForm()
		    {     
		    	return "Register";
		    	
		    //	return new ModelAndView("Register","user",new User());
		    	//return new ModelAndView("Register");
		    }
		    
		   @RequestMapping(value = "/storeUser", method = RequestMethod.POST)
		    public String addUser(@Valid @ModelAttribute("user")User user,BindingResult result, Model model){
		       	
		    	if(result.hasErrors()) {
		    		
		    		return "Register";
		    	}
		    	
		    	System.out.println("hello storeUser");
		    	System.out.println(user.getName()+ "hello @@@@@@");
		    	us.saveorUpdate(user);
		    	UserRoles u1=new UserRoles();
		    	u1.setId(user.getId());
		    	System.out.println(u1.getId());
		    	u1.setUsername(user.getName());
		    	System.out.println(u1.getUsername());
		    	u1.setPassword(user.getPassword());
		    	System.out.println(u1.getPassword());
		    	u1.setStatus(user.isEnabled());
		    	BillingAddress b1=new BillingAddress();
		    	b1.setApartmentNumber(user.getApartmentNumber());
		    	b1.setStreetName(user.getStreetName());
		    	b1.setState(user.getState());
		    	b1.setCity(user.getCity());
		    	b1.setCountry(user.getCountry());
		    	b1.setZipCode(user.getZipCode());
		    	ShippingAddress sd=new ShippingAddress();
		    	sd.setApartmentNumber(user.getApartmentNumber());
		    	sd.setStreetName(user.getStreetName());
		    	sd.setState(user.getState());
		    	sd.setCity(user.getCity());
		    	sd.setCountry(user.getCountry());
		    	sd.setZipCode(user.getZipCode());
		    	us1.save(u1);		    	
		    	return "index";
		       }

		    /*@RequestMapping(value="/listUser",method=RequestMethod.GET,produces="application/json")
		    public @ResponseBody String showUsers(){
		    	List blist=us.getAllUsers();
		    	Gson x=new Gson();
		    	String json=x.toJson(blist);
		    	return json;
		    }*/

		    @ModelAttribute("user")
		    public User createuser(){
		    	return new User();
		    }
		    
		    @RequestMapping("/checkuser")
		    public ModelAndView chackedUser(@Valid @ModelAttribute("user")User user,BindingResult result,@RequestParam("userName") String userName,@RequestParam("password")String password) 
		    { 
		    	System.out.println("UserName is............."+userName);
		    	System.out.println("Password is............."+password);
		    	System.out.println("hello1");
                   String uname;
                   String pwd;
                   System.out.println("hello2");
                   ModelAndView m3 = null;
		    	Session session=sessionFactory.openSession();
		    	System.out.println("hello3");
		    	org.hibernate.Transaction t=session.beginTransaction();
		    	System.out.println("hello4");
		    	System.out.println("hello5");
                Query<User> q=session.createQuery("from User");
                System.out.println("hello6");
                List<User> list=q.list();
               /* System.out.println("hello7");
                Iterator<User> it=list.iterator();
                System.out.println("hello8");
                while(it.hasNext())
                     {
    				System.out.println("this is iterator");
    				 uname=c.getName();
    				 System.out.println(it.next());
    				 System.out.println("uname is......."+uname);
    				 pwd=c.getPassword();
    				 System.out.println("password is......."+pwd);*/
                 for(User w1:list)
                 {
                	 uname=w1.getName();
                	 System.out.println("UserName is .........................."+uname);
                	 pwd=w1.getPassword();
                	 System.out.println("User Password is......................"+pwd);
    				if((uname.equals(userName))&&(pwd.equals(password)))			
    				 m3=new ModelAndView("retrive");
    	         }                
                return m3;
		    }
		    @RequestMapping("/accessde")
		    public ModelAndView stop()
		    {
		    	return new ModelAndView("accessdenied"); 
		    }
		    @RequestMapping("/h1")
			public ModelAndView display()
			{  
				       ModelAndView m1=new ModelAndView("index");
				       return m1; 
			}
		    @RequestMapping("viewde")
			public ModelAndView flow()
			{  
				       ModelAndView m1=new ModelAndView("viewdetails.jsp");
				       return m1; 
			}
		    @RequestMapping("/cont")
			public ModelAndView contactDetails()
			{  
				       ModelAndView m1=new ModelAndView("contact");
				       return m1; 
			}	    
		    @RequestMapping("/billing")
			public ModelAndView billingX()
			{  
				       ModelAndView m1=new ModelAndView("billing");
				       return m1; 
			}
		    
		    @RequestMapping("/orderConfirmed")
			public ModelAndView orderCon()
			{  
				       ModelAndView m1=new ModelAndView("orderConfirmed");
				       return m1; 
			}
		    
		    @RequestMapping("/orderCancel")
			public ModelAndView orderCal()
			{  
				       ModelAndView m1=new ModelAndView("orderCancel");
				       return m1; 
			}	
		    
		    @RequestMapping("/payment")
			public ModelAndView paym()
			{  
				       ModelAndView m1=new ModelAndView("payment");
				       return m1; 
			}	
		    
		    @RequestMapping("/shipping")
			public ModelAndView ship()
			{  
				       ModelAndView m1=new ModelAndView("shipping");
				       return m1; 
			}	
		    @RequestMapping(value="welcome", method=RequestMethod.GET)
		    public ModelAndView checkUserOne(HttpServletRequest request,HttpServletResponse response,HttpSession session)throws Exception
			{  
		    	if(request.isUserInRole("ROLE_ADMIN"))
		    	{
		    		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    	      String str = auth.getName(); //get logged in username
		    		session=request.getSession(true);
		    	session.setAttribute("loggedInUser",str);
		    	ModelAndView m1=new ModelAndView("retrive");
		    	//session.invalidate();
		    	return m1; 
		    	}	   
		    	else
		    	{
		    	//String str=request.getParameter("ROLE_USER");
		    	//String str1="viswam";
		    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	      String str1 = auth.getName(); //get logged in username
	    	      session=request.getSession(true);
	    	      System.out.println("-------------------------"+str1+"--------------------------");
			    	session.setAttribute("loggedInUser",str1);
			    	ModelAndView m1=new ModelAndView("retrive");
			    	//session.invalidate();
			    	return m1; 
                }
			}
		    @RequestMapping(value="/admin1", method = RequestMethod.GET)
			 public String adminOne() {
			 
			  return "admin";
			 
			 }
		    @RequestMapping(value="/au", method = RequestMethod.GET)
			 public String adminThree() {
			 
			  return "autho";
			 
			 }
		    @RequestMapping(value="/list1",method=RequestMethod.GET,produces="application/json")
		    public @ResponseBody String showList1()
		    {
		    	int id=49;
		    	Session session=sessionFactory.openSession();
		    	org.hibernate.Transaction t=session.beginTransaction();
		    	Query q=session.createQuery("from Chiar where chairid='"+id+"'");
                List<Chair> list=q.list();
                System.out.println(list);
		    	Gson x=new Gson();
		    	String json=x.toJson(list);
		    	return json;
		    }
		    @RequestMapping("/cart")
		    public ModelAndView don()
		    {
		    	return new ModelAndView("cart");
		    }
}
    				 