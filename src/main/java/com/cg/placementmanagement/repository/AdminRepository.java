package com.cg.placementmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cg.placementmanagement.entities.Admin;

public interface AdminRepository extends CrudRepository<Admin,Integer> {
	
	@Query("from Admin where adname=?1 and adpassword=?2")
	List<Admin> findByLogin(String adname,String adpassword);
}
