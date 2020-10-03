package com.myspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "currencies")
public class Currencies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "short_name")
	private String short_name;

	public Currencies() {
	}

	public Currencies(String name, String short_name) {
		this.name = name;
		this.short_name = short_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
}
