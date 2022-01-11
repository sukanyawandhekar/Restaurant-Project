package com.cg.placementmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.placementmanagement.entities.Admin;
import com.cg.placementmanagement.service.IAdminService;

@Controller
public class AdminController {
	
	@Autowired
	IAdminService adminservice;
	
	@RequestMapping("/")
	public String indexShow()
	{
		return "/ui/index.jsp";
	}
	
	@RequestMapping("/indexpage")
	public String homeShow()
	{
		return "/ui/indexpage.jsp";
	}
	
	@RequestMapping("/adminlogindetails")
	public String adminLoginDetails()
	{
		
		return "/ui/adminlogindetails.jsp";
	}
	
	
	@RequestMapping("/adminloginpara")
	public ModelAndView adminLoginPara(@RequestParam("adname") String name,@RequestParam("adpassword") String password)
	{
		ModelAndView mv=new ModelAndView();
		Admin admin=new Admin();
		admin.setAdname(name);
		admin.setAdpassword(password);
		mv.addObject("adminVal", admin);
		
		mv.setViewName("/ui/adminlogindetails.jsp");
		return mv;
	}
	
	@RequestMapping("/loginadmin")
	public ModelAndView adminLogin(Admin admin)
	{
		ModelAndView mv=new ModelAndView();
		if(adminservice.insertAdmin(admin.getAdname(),admin.getAdpassword())==true)
		{
			mv.setViewName("/ui/adminlogin.jsp");
			mv.addObject("statment", "Data Inserted Successfully");
			mv.addObject("adminVal", admin);
		}
		else
		{
			mv.setViewName("/ui/error.jsp");
			mv.addObject("statement", "unable to insert data");
		}
		//mv.addObject("adminVal", admin);
		//mv.setViewName("/ui/adminlogindetails.jsp");
		return mv;
	}
	
	@RequestMapping("/adminloginformdetails")
	public String adminLoginFormDetails()
	{
		return "/ui/adminloginformdetails.jsp";
	}
	
	@RequestMapping("/adminloginform")
	public ModelAndView adminLoginForm(Admin admin)
	{
		ModelAndView mv=new ModelAndView();
		if(adminservice.loginAdmin(admin.getAdname(), admin.getAdpassword()).equals("success"))
		{
			mv.setViewName("/ui/adminfetch.jsp");
			mv.addObject("adminVal", admin);
			
		}
		else
		{
			mv.setViewName("/ui/error.jsp");
			mv.addObject("statement","Invalid credentials... please login again!!");
		}
		return mv;
	}
	
	
	
	

}
