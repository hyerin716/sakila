package com.example.sakila.vo;

import lombok.Data;

@Data
public class City {
	private Integer cityId;
	private String city;
	private Integer countryId;
	private String lastUpdate;
}
