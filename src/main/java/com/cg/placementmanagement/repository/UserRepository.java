package com.cg.placementmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.cg.placementmanagement.entities.User;

public interface UserRepository extends CrudRepository<User,Integer>{
	
	@Query("from User where uname=?1 and upassword=?2")
	List<User> findByLogin(String uname, String upassword);

	

}
