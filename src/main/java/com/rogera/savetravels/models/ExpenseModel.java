package com.rogera.savetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

//@Entity & @Table connect us to the database

@Entity
@Table(name = "expenses")
public class ExpenseModel {
	
	// MEMBER VARIABLES
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	VALIDATIONS FROM JAVAX
	@NotNull
	@Size(min=3, max=25, message="Dont hide !")
	
	@NotNull
	private String name;
	
	@NotEmpty
	@Size(min=3, max=32, message=" tell me the vendor !")
	private String vendor;
	
	@NotNull
	@Min(0)
	@Max(1000)
//	@Range(min=2, max=69)
	private Double amount;
	
	@NotEmpty
	private String info;
	
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date updatedAt;
	



	
	
//	CONSTRUCTORS
	
	//EMPTY CONTRUCTOR
	public ExpenseModel() {
		
	}
	
	//FULL CONTRUCTOR
	public ExpenseModel(String name, String vendor, Double amount, String info) {
		super();
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.info = info;
	}
		
	
	
//GETTERS / SETTERS / OTHER METHODS

	//OTHER METHODS FOR OUR createdAt & updatedAt - gets the names and dates that we need
	@PrePersist
	protected void onCreate() {
			this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
	
	
//CLOSING BRACKET
}
