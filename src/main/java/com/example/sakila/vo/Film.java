package com.example.sakila.vo;

import lombok.Data;

@Data
public class Film {
	private Integer filmId;	//PK
	private String title;	
	private String description;	// 기본값 NULL
	private Integer releaseYear;	// 기본값 NULL
	private Integer languageId;
	private Integer originalLanguageId; // 기본값 NULL
	private Integer rentalDuration; 
	private Double rentalRate;
	private Integer length;	// 기본값 NULL
	private Double replacementCost;
	private String rating;
	private String specialFeatures;	// 기본값 NULL  ex) xxx, yyy, zz,
	private String lastUpdate;
}
