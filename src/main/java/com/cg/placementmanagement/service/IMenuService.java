package com.cg.placementmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.placementmanagement.entities.Menu;
import com.cg.placementmanagement.entities.OrderTable;
import com.cg.placementmanagement.entities.User;
import com.cg.placementmanagement.repository.MenuRepository;
import com.cg.placementmanagement.repository.UserRepository;

@Service
public class IMenuService {
	
	@Autowired 
	MenuRepository menurepo;
	public String insertMenu(String menuname,int menuprice)
	{
		Menu menu=new Menu();
		menu.setMenuname(menuname);
		menu.setMenuprice(menuprice);
		menurepo.save(menu);
		
		return "inserted";
	}
	
	public String findMenuName(String menuname)
	{
		List<Menu> menulist=menurepo.findByMenuName(menuname);
		
		if(menulist.size()==1)
		{
			return "success";
		}
		else
		{
			return "fail";
		}
		
	}
	
	public String findMenuPrice(int menuprice)
	{
		List<Menu> menulist=menurepo.findByMenuPrice(menuprice);
		
		if(menulist.size()==1)
		{
			return "success";
		}
		else
		{
			return "fail";
		}
		
	}
	
	public List<Menu> fetchAllMenu(Menu menu)
	{
		List<Menu> menulist= (List<Menu>) menurepo.findAll();
		for(Menu m:menulist)
		{
			System.out.println(menulist);
		}
		
		return (List<Menu>) menu;
	}
	

}
