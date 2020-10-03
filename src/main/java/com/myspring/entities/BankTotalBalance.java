package com.myspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "bank_total_balance")
public class BankTotalBalance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "value")
	private double value;

	@ManyToOne
	@JoinColumn(name = "currency_id")
	private Currencies currency;

	public BankTotalBalance() {
	}

	public BankTotalBalance(int value, Currencies currency) {
		this.value = value;
		this.currency = currency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Currencies getCurrency() {
		return currency;
	}

	public void setCurrency_id(Currencies currency) {
		this.currency = currency;
	}
}
