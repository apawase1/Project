package userandexpenses.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "expense")
public class Expense 
{
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String category;
	
	private double price;
	
	private double variableincome;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_id",referencedColumnName = "id")
	private User user;
	

	public Expense() {
		
	}


	public Expense(long id, String category, double price, double variableincome, User user) {
		this.id = id;
		this.category = category;
		this.price = price;
		this.variableincome = variableincome;
		this.user = user;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public double getVariableincome() {
		return variableincome;
	}


	public void setVariableincome(double variableincome) {
		this.variableincome = variableincome;
	}

}
