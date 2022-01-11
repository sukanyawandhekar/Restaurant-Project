package com.cg.placementmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.placementmanagement.entities.User;
import com.cg.placementmanagement.exceptions.PasswordLengthException;
import com.cg.placementmanagement.repository.UserRepository;

@Service
public class IUserService {
	
		@Autowired
		UserRepository userrepo;
		public boolean insertUser(String uname,String upassword, String uemail,long umobno)
		{
			User user=new User();
			user.setUname(uname);
			user.setUpassword(upassword);
			user.setUemail(uemail);
			user.setUmobno(umobno);
			
			try
			{
				if(!(user.getUpassword().length()>6))
				{
					throw new PasswordLengthException("Password length must be 6");
				}
			}
			catch(PasswordLengthException e)
			{
				System.out.println(e);
			}
			userrepo.save(user);
			
			return true;
		}
		
		public String loginUser(String uname,String upassword)
		{
			List<User> adminList=userrepo.findByLogin(uname, upassword);
			if(adminList.size()==1)
			{
				return "success";
			}
			else
			{
				return "fail";
			}
		}
		
		@RequestMapping("/menuhomepage")
		public String menuHomePage()
		{
			return "/ui/menuhomepage.jsp";
		}
		
}
