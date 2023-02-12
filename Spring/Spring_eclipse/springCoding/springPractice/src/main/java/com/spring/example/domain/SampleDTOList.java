package com.spring.example.domain;

import java.util.List;

import lombok.Data;

import java.util.ArrayList;

@Data
public class SampleDTOList {
	private List<SampleDTO> list;
	
	public SampleDTOList() {
		list = new ArrayList<>();
	}
}
