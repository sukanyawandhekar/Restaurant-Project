package com.cg.placementmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.placementmanagement.entities.Menu;
import com.cg.placementmanagement.entities.OrderTable;
import com.cg.placementmanagement.entities.User;
import com.cg.placementmanagement.repository.MenuRepository;
import com.cg.placementmanagement.repository.OrderTableRepository;
import com.cg.placementmanagement.repository.UserRepository;

@Service
public class IOrderTableService {
	
	@Autowired
	OrderTableRepository orderrepo;
	@Autowired 
	MenuRepository menurepo;
	
	public String orderMenu(String menuname, int quantity, String uname, String uemail) {
		OrderTable order=new OrderTable();
		order.setMenuname(menuname);
		order.setQuantity(quantity);
		order.setUname(uname);
		order.setUemail(uemail);
		orderrepo.save(order);
		
		Menu menu=new Menu();
		int  name=menurepo.findByPrice(menuname);
		int bill=name*quantity;
		System.out.println(name);
		return "success";
	}
	

	public int bill(String menuname, int quantity, String uname, String uemail) {
		OrderTable order=new OrderTable();
		order.setMenuname(menuname);
		order.setQuantity(quantity);
		order.setUname(uname);
		order.setUemail(uemail);
		orderrepo.save(order);
		
		Menu menu=new Menu();
		int  name=menurepo.findByPrice(menuname);
		int bill=name*quantity;
		System.out.println(name);
		return bill;
	}
}
