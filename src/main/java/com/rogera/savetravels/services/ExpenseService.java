package com.rogera.savetravels.services;

//IMPORTS START
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogera.savetravels.models.ExpenseModel;
import com.rogera.savetravels.repositories.ExpenseRepository;
//IMPORTS END


@Service
public class ExpenseService {

//IMPORT REPOSITORY
	@Autowired
	ExpenseRepository expenseRepo;
	
	
//	CREATE
	public ExpenseModel create(ExpenseModel newExpense) {
		return expenseRepo.save(newExpense);
	
	}
	
// GET ALL
	public List<ExpenseModel> getAllExpenses(){
		return expenseRepo.findAll();
	}
	
// GET ONE
	public ExpenseModel findExpense(Long id) {
		
		return expenseRepo.findById(id).orElse(null);
//		Optional<ExpenseModel> optionalExpense = expenseModelRepo.findById(id);
//		if(optionalExpenseModel.isPresent()) {
//			return optionalExpenseModel.get();
//		} else {
//			return null;
//		}
		
	}
	
// UPDATE A USER
	public ExpenseModel updateExpense(@Valid ExpenseModel updatedExpense) {
		return expenseRepo.save(updatedExpense);
	}
	
// DELETE A USER
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}

// CLOSING TAG
}
