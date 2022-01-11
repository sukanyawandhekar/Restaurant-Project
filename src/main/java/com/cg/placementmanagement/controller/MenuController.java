package com.cg.placementmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.placementmanagement.entities.Menu;
import com.cg.placementmanagement.service.IMenuService;

@Controller
public class MenuController {
	
	@Autowired
	IMenuService menuservice;
	@RequestMapping("/insertmenuform")
	public String menu()
	{
		return "/ui/insertmenuform.jsp";
	}
	
	@RequestMapping("/insertmenu")
	public ModelAndView insertMenu(Menu menu)
	{
		ModelAndView mv=new ModelAndView();
		if(menuservice.insertMenu(menu.getMenuname(), menu.getMenuprice()).equals("inserted"))
		{
			mv.setViewName("/ui/insertmenuinfo.jsp");
			mv.addObject("menuVal", menu);
			
		}
		else
		{
			mv.setViewName("/ui/error.jsp");
			mv.addObject("statement", "unable to insert...");
		}
		return mv;
	}
	
	@RequestMapping("/fetchmenudetails")
	public String fetchMenuDetails()
	{
		return "/ui/fetchmenudetails.jsp";
	}
	
	@RequestMapping("/fetchmenu")
	public ModelAndView fetchMenu(Menu menu)
	{
		//Menu menu=new Menu();
		ModelAndView mv=new ModelAndView();
		if(menuservice.findMenuName(menu.getMenuname()).equals("success"))
		{
			mv.setViewName("/ui/fetchmenu.jsp");
			mv.addObject("menuVal", menu);
		}
		else if(menuservice.findMenuName(menu.getMenuname()).equals("fail"))
		{
			mv.setViewName("/ui/error.jsp");
			mv.addObject("statement", "This item is not available now");
		}
		return mv;
	}
	
	
	@RequestMapping("/fetchmenuprice")
	public String fetchMenuPrice()
	{
		return "/ui/fetchmenupricedetails.jsp";
	}
	
	@RequestMapping("/fetchmenubyprice")
	public ModelAndView fetchMenuByPrice(@RequestParam("menuprice") int menuprice)
	{
		Menu menu=new Menu();
		ModelAndView mv=new ModelAndView();
		if(menuservice.findMenuPrice(menuprice).equals("success"))
		{
			mv.setViewName("/ui/fetchmenubyprice.jsp");
			mv.addObject("menuVal", menu);
		}
//		else if(menuservice.findMenuName(menu.getMenuname()).equals("fail"))
//		{
//			mv.setViewName("/ui/error.jsp");
//			mv.addObject("statement", "This item is not available now");
//		}
		return mv;
	}
	
	
	/*
	@RequestMapping("/fetchallmenu")
	public ModelAndView fetchAllMenuList(Menu menu)
	{
		ModelAndView mv=new ModelAndView();
		Menu menu=new Menu();
		 List<Menu> list=menuservice.fetchAllMenu(menu);
		 if(list.size()>=0)
		 {
			 
			 mv.addObject("menulist", menu);
			mv.setViewName("/ui/fetchmenulist.jsp");
		 }
		
		
		return mv;
		
		
		ModelAndView mv=new ModelAndView();
		if(menuservice.fetchAllMenu(menu) != null)
		{
			//System.out.println(menu.getMenuname()+menu.getMenuprice());
			mv.addObject("menulist", menu);
			mv.setViewName("/ui/fetchmenulist.jsp");
		}
		else
		{
			mv.setViewName("/ui/error.jsp");
			mv.addObject("statement", "This item is not available now");
		}
		return mv;

	
	}
	*/

	@RequestMapping("/fetchallmenu")
	public String fetchAllMenu()
	{
		return "/ui/menuphoto.jsp";
	}
	
	@RequestMapping("/info")
	public String info()
	{
		return "/ui/photos.jsp";
	}

}
