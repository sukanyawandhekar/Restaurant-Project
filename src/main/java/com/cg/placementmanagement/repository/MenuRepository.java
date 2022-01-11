package com.cg.placementmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cg.placementmanagement.entities.Menu;

public interface MenuRepository extends CrudRepository<Menu,Integer> {

	@Query("from Menu where menuname=?1")
	List<Menu> findByMenuName(String menuname);
	
	@Query("from Menu where menuprice=?1")
	List<Menu> findByMenuPrice(int menuprice);
	
	@Query("select menuprice from Menu where menuname=?1")
	int findByPrice(String menuname);
	
	
	
	
}
