package com.myspring.entities;

import org.springframework.security.core.userdetails.User;

import javax.persistence.*;

@Entity
@Table(name = "transaction_histories")
public class TransactionHistories {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	Users manager;

	@ManyToOne
	@JoinColumn(name = "sender_account_id")
	Accounts sender;

	@ManyToOne
	@JoinColumn(name = "receiver_account_id")
	Accounts receiver;

	@ManyToOne
	@JoinColumn(name = "operation_id")
	Operations operation;

	@ManyToOne
	@JoinColumn(name = "currency_id")
	Currencies currency;

	@Column(name = "amount")
	private double amount;

	@Column(name = "operation_time")
	private String operation_time;

	public TransactionHistories() {
	}

	public TransactionHistories(Users manager, Accounts sender, Accounts receiver, Operations operation, Currencies currency, double amount, String operation_time) {
		this.manager = manager;
		this.sender = sender;
		this.receiver = receiver;
		this.operation = operation;
		this.currency = currency;
		this.amount = amount;
		this.operation_time = operation_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getManager_id() {
		return manager;
	}

	public void setManager_id(Users manager) {
		this.manager = manager;
	}

	public Accounts getSender_account_id() {
		return sender;
	}

	public void setSender_account_id(Accounts sender) {
		this.sender = sender;
	}

	public Accounts getReceiver_account_id() {
		return receiver;
	}

	public void setReceiver_account_id(Accounts receiver) {
		this.receiver = receiver;
	}

	public Operations getOperation_id() {
		return operation;
	}

	public void setOperation_id(Operations operation_id) {
		this.operation = operation;
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

	public String getOperation_time() {
		return operation_time;
	}

	public void setOperation_time(String operation_time) {
		this.operation_time = operation_time;
	}
}
