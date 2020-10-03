package com.myspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "currency_exchange")
public class CurrencyExchange {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "currency_id")
	Currencies currency;

	@Column(name = "purchase_value")
	private double purchase_value;

	@Column(name = "sale_value")
	private double sale_value;

	@Column(name = "assigned_time")
	private String assigned_time;

	public CurrencyExchange() {
	}

	public CurrencyExchange(Currencies currency, double purchase_value, double sale_value, String assigned_time) {
		this.currency = currency;
		this.purchase_value = purchase_value;
		this.sale_value = sale_value;
		this.assigned_time = assigned_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Currencies getCurrency_id() {
		return currency;
	}

	public void setCurrency_id(Currencies currency) {
		this.currency = currency;
	}

	public double getPurchase_value() {
		return purchase_value;
	}

	public void setPurchase_value(double purchase_value) {
		this.purchase_value = purchase_value;
	}

	public double getSale_value() {
		return sale_value;
	}

	public void setSale_value(double sale_value) {
		this.sale_value = sale_value;
	}

	public String getAssigned_time() {
		return assigned_time;
	}

	public void setAssigned_time(String assigned_time) {
		this.assigned_time = assigned_time;
	}
}
