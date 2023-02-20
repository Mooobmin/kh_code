package com.spring.client.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private int b_num;
	private String b_name;
	private String b_title;
	private String b_content;
	private String b_pwd;
	private String b_date;
}
