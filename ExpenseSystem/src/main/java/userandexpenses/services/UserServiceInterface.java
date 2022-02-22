package userandexpenses.services;

import java.util.List;

import userandexpenses.model.Expense;
import userandexpenses.model.User;

public interface UserServiceInterface 
{
	
	
	//Insert User
	boolean addUser(User obj);
	
	//Insert Expense
	void addExpense(Expense obj);
	
	
	
	//Update User
	User updateUser(long id,User obj) throws Exception;
	
	//Update Expense
	Expense updateExpense(long id,Expense obj) throws Exception;
	
	//Delete Expense
	void deleteExpense(long id);
	void deleteAllExpenses();
	
	
	//Delete User
	boolean deleteUser(long id) throws Exception;
	
	
	
	
	
	
	//Display Users
	User displayUser(long id) throws Exception;
	
	//Display User  by Email
	User displayByEmail(String emailid) throws Exception;
	
	List<User> displayAllUsers();
	
	//Display Expense
	Expense displayExpense(long id) throws Exception;
	
	List<Expense> displayAllExpenses();
	
	//Display Expenses For User
	List<Expense> displayUserExpenses(long id) throws Exception;
	
	
}
