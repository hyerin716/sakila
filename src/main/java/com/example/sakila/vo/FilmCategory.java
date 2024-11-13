package com.example.sakila.vo;

import lombok.Data;

@Data
public class FilmCategory {
	private Integer filmId;
	private Integer categoryId;
	private String lastUpdate;
}
