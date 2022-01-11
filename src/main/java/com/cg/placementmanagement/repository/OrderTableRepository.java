package com.cg.placementmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.placementmanagement.entities.OrderTable;

@Repository
public interface OrderTableRepository extends CrudRepository<OrderTable ,Integer>{
	

}
