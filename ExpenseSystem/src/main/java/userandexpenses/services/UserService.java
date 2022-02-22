package userandexpenses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import userandexpenses.dao.ExpenseRepository;
import userandexpenses.dao.UserRepository;
import userandexpenses.model.Expense;
import userandexpenses.model.User;

@Service
public class UserService implements UserServiceInterface
{
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private ExpenseRepository erepo;

	@Override
	public boolean addUser(User obj) {
		// TODO Auto-generated method stub
		boolean added = false;
		try {
			urepo.save(obj);
			added = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return added;
	}

	@Override
	public void addExpense(Expense obj) {
		// TODO Auto-generated method stub
		erepo.save(obj);
		
	}

	@Override
	public User updateUser(long id, User obj) throws Exception {
		// TODO Auto-generated method stub
		User updateuser = urepo.findById(id).orElseThrow(()-> new Exception("Not a Valid ID Exception"));
		updateuser.setId(id);
		if(obj.getEmail()!=null)
			updateuser.setEmail(obj.getEmail());
		if(obj.getExpense()!=null)
			updateuser.setExpense(obj.getExpense());
		updateuser.setFixedmonthlyexpense(obj.getFixedmonthlyexpense());
		updateuser.setFixedmonthlyincome(obj.getFixedmonthlyincome());
		updateuser.setMainbalance(obj.getMainbalance());
		if(obj.getUsername()!=null)
			updateuser.setUsername(obj.getUsername());
		urepo.save(updateuser);
		return updateuser;
	}

	@Override
	public Expense updateExpense(long id, Expense obj) throws Exception {
		// TODO Auto-generated method stub
		Expense exp = erepo.findById(id).orElseThrow(()->new Exception("Not a Valid ID Exception"));
		exp.setId(id);
		if(obj.getCategory()!=null)
			exp.setCategory(obj.getCategory());
		exp.setPrice(obj.getPrice());
		exp.setVariableincome(obj.getVariableincome());
		if(obj.getUser()!=null)
			exp.setUser(obj.getUser());
		erepo.save(exp);
		return exp;
	}

	@Override
	public void deleteExpense(long id) {
		// TODO Auto-generated method stub
		erepo.deleteById(id);
		
	}

	@Override
	public boolean deleteUser(long id) throws Exception {
		boolean deleted = false;
		Optional<User> x = urepo.findById(id);
		User tempuser = new User();
		if(x.isPresent())
		{
			tempuser = x.get();
			urepo.delete(tempuser);
			deleted = true;
		}
		
		
		return deleted;
		
		
	}

	@Override
	public User displayUser(long id) throws Exception {
		// TODO Auto-generated method stub
		User x = urepo.findById(id).orElseThrow(()->new Exception("Invalid"));
		return x;
	}

	@Override
	public List<User> displayAllUsers() {
		// TODO Auto-generated method stub
		List<User> us= urepo.findAll();
		return us;
	}

	@Override
	public Expense displayExpense(long id) throws Exception {
		// TODO Auto-generated method stub
		Expense ex=  erepo.findById(id).orElseThrow(()->new Exception("Invalid"));
		return ex;
	}

	@Override
	public List<Expense> displayAllExpenses() {
		// TODO Auto-generated method stub
		List<Expense> exp = erepo.findAll();
		return exp;
	}

	@Override
	public void deleteAllExpenses()
	{
		// TODO Auto-generated method stub
		erepo.deleteAll();
		
	}

	@Override
	public User displayByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		User x = urepo.findByEmail(email);
		return x;
	}

	@Override
	public List<Expense> displayUserExpenses(long id) throws Exception {
	
			User u = urepo.findById(id).orElseThrow(()-> new Exception("Invalid"));
			long z = u.getId();
			List<Expense> x  = erepo.findByUser_id(z);
		
		
		return x;
	}


}
