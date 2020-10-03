package com.myspring.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accounts")
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "birth_date")
	private String birth_date;

	@Column(name = "iin_number")
	private String iin_number;

	@ManyToOne
	@JoinColumn(name = "currency_id")
	private Currencies currency;

	@Column(name = "amount")
	private double amount;

	@Column(name = "created_date")
	private String created_date;

	@Column(name = "is_blocked")
	private boolean is_blocked;

	public Accounts() {
	}

	public Accounts(String first_name, String last_name, String birth_date, String iin_number, Currencies currency, double amount) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.birth_date = birth_date;
		this.iin_number = iin_number;
		this.currency = currency;
		this.amount = amount;
		this.created_date = String.valueOf(new Date());
		this.is_blocked = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getIin_number() {
		return iin_number;
	}

	public void setIin_number(String iin_number) {
		this.iin_number = iin_number;
	}

	public Currencies getCurrency_id() {
		return currency;
	}

	public void setCurrency_id(Currencies currency) {
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public boolean isIs_blocked() {
		return is_blocked;
	}

	public void setIs_blocked(boolean is_blocked) {
		this.is_blocked = is_blocked;
	}
}
