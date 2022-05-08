package com.ssafy.boot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int id;
	private String writer;
	private String title;
	private String content;
	private int viewCnt;
	private String regDate;
}
