package com.rogera.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rogera.savetravels.models.ExpenseModel;

@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseModel, Long> {
	
	//GET ALL METHOD
		//cast in a LIST to display all
	List<ExpenseModel> findAll();

}
