package com.cg.placementmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.placementmanagement.entities.User;
import com.cg.placementmanagement.service.IUserService;

@Controller

public class UserController {
	@Autowired
	IUserService userservice;
	
	
	@RequestMapping("/userreg")
	public String userRegister()
	{
		return "/ui/userregidetail.jsp";
	}
	
	@RequestMapping("/registerUserpara")
	public ModelAndView registerUserpara(String uname,String upassword,String uemail,@RequestParam("umobno") long mobno)
	{
		User user=new User();
		user.setUname(uname);
		user.setUpassword(upassword);
		user.setUemail(uemail);
		user.setUmobno(mobno);
		ModelAndView mv=new ModelAndView();
		mv.addObject("userVal", user);
		mv.setViewName("/ui/userregistration.jsp");
		
		return mv;
	}
	
	@RequestMapping("/registeruser")
	public ModelAndView registerUser(User user)
	{
		ModelAndView mv=new ModelAndView();
		if(userservice.insertUser(user.getUname(),user.getUpassword(),user.getUemail(),user.getUmobno())==true);
		{
			
			mv.setViewName("/ui/userregistration.jsp");
			mv.addObject("userVal", user);
			mv.addObject("statement", "user Registrartion successful");
		}
		
		return mv;
	}
	
	@RequestMapping("/userloginhref")
	public String login()
	{
		return "/ui/userlogin.jsp";
	}
	
	
	
	@RequestMapping("/userlogin")
	public ModelAndView userLogin(User user)
	{
		ModelAndView mv=new ModelAndView();
		if(userservice.loginUser(user.getUname(),user.getUpassword()).equals("success"))
		{
			mv.setViewName("/ui/userlogindetails.jsp");
			mv.addObject("userVal", user);
			mv.addObject("statement", "Login Successfull !!");
		}
		else
		{
			mv.setViewName("/ui/error.jsp");
			mv.addObject("statement", "invalid credentials... please login again!!");
		}
		return mv;
	}
	
	@RequestMapping("/menuhomepage")
	public String menuHomePage()
	{
		return "/ui/menuhomepage.jsp";
	}
	
	@RequestMapping("/backbutton")
	public String backPage()
	{
		return "/ui/indexpage.jsp";
	}
	
	
//	@RequestMapping("/userexception")
//	public ModelAndView userException(User user)
//	{
//		ModelAndView mv=new ModelAndView();
//		if(user.getUpassword())
//		
	
//	@PostMapping(path="/user",consumes= {"application/json"})
//	public User addUser(@RequestBody User user)
//	{
//		userepo.save(user);
//		return user;
//	}
}



