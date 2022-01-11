package com.cg.placementmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.placementmanagement.entities.Admin;
import com.cg.placementmanagement.entities.Menu;
import com.cg.placementmanagement.repository.AdminRepository;


@Service
public class IAdminService {

@Autowired
AdminRepository adminrepo;

public boolean insertAdmin(String adname, String adpassword)
{
	Admin admin=new Admin();
	admin.setAdname(adname);
	admin.setAdpassword(adpassword);
	adminrepo.save(admin);
	return true;
}
public String loginAdmin(String adname,String adpassword)
{
	List<Admin> adminList=adminrepo.findByLogin(adname, adpassword);
	if(adminList.size()==1)
	{
		return "success";
	}
	else
	{
		return "fail";
	}
}

	
	
}
