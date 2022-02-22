package userandexpenses.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String username;
	

	private String email;
	


	private double mainbalance;
	
	private double fixedmonthlyincome;
	public User() {
	}
	
	


	public User(String username, String email, double mainbalance, double fixedmonthlyincome,
			double fixedmonthlyexpense, Set<Expense> expense) {
		
		this.username = username;
		this.email = email;
		this.mainbalance = mainbalance;
		this.fixedmonthlyincome = fixedmonthlyincome;
		this.fixedmonthlyexpense = fixedmonthlyexpense;
		this.expense = expense;
	}




	private double fixedmonthlyexpense;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<Expense> expense =new HashSet<Expense>();


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public double getMainbalance() {
		return mainbalance;
	}


	public void setMainbalance(double mainbalance) {
		this.mainbalance = mainbalance;
	}


	public double getFixedmonthlyincome() {
		return fixedmonthlyincome;
	}


	public void setFixedmonthlyincome(double fixedmonthlyincome) {
		this.fixedmonthlyincome = fixedmonthlyincome;
	}


	public double getFixedmonthlyexpense() {
		return fixedmonthlyexpense;
	}


	public void setFixedmonthlyexpense(double fixedmonthlyexpense) {
		this.fixedmonthlyexpense = fixedmonthlyexpense;
	}


	public Set<Expense> getExpense() {
		return expense;
	}


	public void setExpense(Set<Expense> expense) {
		this.expense = expense;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
}
