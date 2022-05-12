package com.ssafy.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Board {
	private int id;
	private String title;
	private String writer;
	private String content;
	private int viewCnt;
	private String datetime;
}

/*
id int AI PK 
title varchar(40) 
writer varchar(40) 
content varchar(200) 
view_cnt int 
reg_date datetime
*/