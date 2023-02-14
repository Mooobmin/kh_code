package com.spring.example.domain;

import org.springframework.lang.Nullable;

import lombok.Data;

@Data
public class Ticket {
	@Nullable
	private int tno;
	private String owner;
	private String grade;
}
