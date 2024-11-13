package com.example.sakila.vo;

import lombok.Data;

@Data
public class FilmActor {
	private Integer actorId;
	private Integer filmId;
	private String lastUpdate;
}
