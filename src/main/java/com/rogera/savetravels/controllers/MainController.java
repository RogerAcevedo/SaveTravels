package com.rogera.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rogera.savetravels.models.ExpenseModel;
import com.rogera.savetravels.services.ExpenseService;

@Controller
public class MainController {
	
// IMPORT SERVICE TO INTERACT WITH THIS CONTROLLER (DEPENDENCY INJECTION)
	@Autowired
	ExpenseService expenseServ;
	
	// ------------------------------- DATA BINDING CREATE ------------------------------ //
					// DATA BINDING IS EXCLUSIVELY FOR CREATING & UPDATE!
//READ ALL
	
	@GetMapping("/")
	public String index(
			Model model, @ModelAttribute("expenseObj") ExpenseModel emptyExpenseObj
			) {
		
		// USE SERVICE TO MAKE CRUD COMMAND - RETRIEVE ALL
		List<ExpenseModel> allExpensesFromDB = expenseServ.getAllExpenses();
		
		// PASS INFORMATION TO JSP
		model.addAttribute("allExpenses", allExpensesFromDB);
		
		//RENDER JSP
		return "index.jsp";
	}
	
	@PostMapping("/expenses/new")
	public String processExpense(
			// ExpenseModel "filledExpenseOjb" uses our empty constructor
			// @Valid is used for Validations
			// ORDER FOR Valid, ModelAttribute, etc, etc must follow this ORDEr
			@Valid @ModelAttribute("expenseObj") ExpenseModel filledExpenseObj,
			BindingResult results, Model model // HttpSession session, etc
			) {
				// FOR VALIDATIONS
				if(results.hasErrors()) {
					//get all users from DB
					List<ExpenseModel> allExpensesFromDB = expenseServ.getAllExpenses();
					model.addAttribute("allExpenses", allExpensesFromDB);
					return "index.jsp";
				}
		expenseServ.create(filledExpenseObj);
		return "redirect:/";
		
	}
	
	// ------------------------------- DATA BINDING CREATE END ------------------------------ //
	
	
//READ ONE
	@GetMapping("/expenses/{id}")
	public String showOne(
			@PathVariable("id") Long expenseId,
			Model model
	) {
		//RETRIEVE ONE USER FROM THE DATABASE
		ExpenseModel oneExpense = expenseServ.findExpense(expenseId);
		
		//PASS INFORMATION TO THE JSP
//		model.addAttribute("ExpenseModel", oneExpense);
		model.addAttribute("expense", oneExpense);
		
		return "oneExpense.jsp";
	}

	
	// ------------------------------- DATA BINDING UPDATE/EDIT ------------------------------ //
	
//	EDITING A USER
	//{id} inside varbiable MUST remain "{id}"
	@GetMapping("/expenses/{id}/edit")
	public String editExpense(
			// TO DISPLAY USER 
			@PathVariable("id") Long userId, Model model
	) {
		// GRAB ONE USER FROM DB
		ExpenseModel oneExpense = expenseServ.findExpense(userId);
		
		//PASS ONE USER TO JSP
		//  expenseObj - our create object & one expense is our variable to grab info from DB
		model.addAttribute("expenseObj", oneExpense);
		
		return "editExpense.jsp";
	}
	
	@PutMapping("/expenses/{id}/edit")
	public String updateExpense(
			@Valid @ModelAttribute("expenseObj") ExpenseModel filledExpenseObj,
			BindingResult results
	) {
		if(results.hasErrors()) {
			return "editExpense.jsp";
		}
		expenseServ.create(filledExpenseObj);
		return "redirect:/";
		
	}
	
	// ------------------------------- DATA BINDING UPDATE/EDIT END------------------------------ //
	
	
	//DELETE 
	@DeleteMapping("/expenses/{id}")
	public String deleteExpense(@PathVariable("id") Long userId) {
		expenseServ.deleteExpense(userId);
		return "redirect:/";
	}
	
	
//MainController closing bracket	
}






//@GetMapping("/expenses/new")
//public String newExpense( 
//		
//		//model.addAttribute("expenseObj", new ExpenseModel()); - same as below
//		// ExpenseModel "emptyExpenseOjb" uses our empty constructor
//	@ModelAttribute("expenseObj") ExpenseModel emptyExpenseObj
//) {		
//	return "create.jsp";
//}


