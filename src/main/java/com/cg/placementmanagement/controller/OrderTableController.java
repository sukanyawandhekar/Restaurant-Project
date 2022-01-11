package com.cg.placementmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.placementmanagement.entities.OrderTable;
import com.cg.placementmanagement.service.IOrderTableService;

@Controller
public class OrderTableController {
	@Autowired
	IOrderTableService orderservice;
	@RequestMapping("/orderpage")
	public String orderpage()
	{
		return "/ui/orderdetails.jsp";
	}
	
	@RequestMapping("/ordernowparam")
	public ModelAndView orderNowparam(@RequestParam("menuname") String menuname,@RequestParam("quantity") int quantity,@RequestParam("uname") String uname,@RequestParam("uemail") String uemail)
	{
		ModelAndView mv=new ModelAndView();
		OrderTable order=new OrderTable();
		order.setMenuname(menuname);
		order.setQuantity(quantity);
		order.setUname(uname);
		order.setUemail(uemail);
		
		mv.addObject("orderVal", order);
		mv.setViewName("/ui/ordersuccess.jsp");
		return null;
	}
	
	
	@RequestMapping("/ordernow")
	public ModelAndView orderNow(OrderTable order)
	{
		ModelAndView mv=new ModelAndView();
		if(orderservice.orderMenu(order.getMenuname(), order.getQuantity(), order.getUname(), order.getUemail()).equals("success"))
		{
			
			
			int bill=orderservice.bill(order.getMenuname(), order.getQuantity(), order.getUname(), order.getUemail());
				
				mv.addObject("orderVal", order);
				mv.addObject("bill",bill);
			
			mv.setViewName("/ui/ordersuccess.jsp");
			//mv.addObject("orderVal", order);
			mv.addObject("statement1", "Congradulations");
			mv.addObject("statement2", "Your order is confirm");

		}
		else
		{
			mv.setViewName("/ui/error.jsp");
			mv.addObject("statement","order not complete please try again...");
		}
		
		return mv;
	}
	

}
