package com.example.sakila.vo;

import lombok.Data;

@Data
public class Payment {
	private int paymentId;
	private int customerId;
	private int staffId;
	private int rentalId;
	private double amount;
	private String paymentDate;
	private String lastUpdate;
}
