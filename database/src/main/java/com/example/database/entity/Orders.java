package com.example.database.entity;

// default package
// Generated Jan 31, 2019 10:14:08 AM by Hibernate Tools 5.1.10.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Orders generated by hbm2java
 */
@Entity
@Table(name = "orders", catalog = "ban_hang")
public class Orders implements java.io.Serializable {

	private Integer orderId;
	private Integer customersId;
	private Integer employeesId;
	private Date orderDate;
	private Date requiredDate;
	private String address;

	public Orders() {
	}

	public Orders(int customers, int employees, Date orderDate, Date requiredDate, String address) {
		this.customersId = customersId;
		this.employeesId = employeesId;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.address = address;
		
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "OrderID", unique = true, nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	
	@Column(name = "CustomerID")
	public int getCustomersId() {
		return this.customersId;
	}

	public void setCustomersId(int customersId) {
		this.customersId = customersId;
	}

	
	@Column(name = "EmployeeID")
	public int getEmployeesId() {
		return this.employeesId;
	}

	public void setEmployeesId(int employeesId) {
		this.employeesId = employeesId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OrderDate", length = 26)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RequiredDate", length = 26)
	public Date getRequiredDate() {
		return this.requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	@Column(name = "Address", length = 45)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

}
