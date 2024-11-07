package com.example.sakila.vo;

import lombok.Data;

@Data
public class Film {
	private int filmId;	//PK
	private String title;	
	private String description;	// 기본값 NULL
	private Integer releaseYear;	// 기본값 NULL
	private int languageId;
	private Integer originalLanguageId; // 기본값 NULL
	private int rentalDuration; 
	private double rentalRate;
	private int length;	// 기본값 NULL
	private double replacementCost;
	private String rating;
	private String specialFeatures;	// 기본값 NULL  ex) xxx, yyy, zz,
	private String lastUpdate;
}
