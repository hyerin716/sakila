package com.example.sakila.vo;

import lombok.Data;

@Data
public class Payment {
	private Integer paymentId;
	private Integer customerId;
	private Integer staffId;
	private Integer rentalId;
	private Double amount;
	private String paymentDate;
	private String lastUpdate;
}
