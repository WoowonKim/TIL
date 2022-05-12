DROP DATABASE IF EXISTS board;

CREATE DATABASE board CHARACTER SET=utf8mb4;

USE board;

DROP TABLE IF EXISTS board;

CREATE TABLE `board` (
	`id` INT NOT NULL PRIMARY KEY auto_increment,
    `title` VARCHAR(40) NOT NULL,
    `writer` VARCHAR(40) NOT NULL,
    `content` VARCHAR(200) NOT NULL,
    `view_cnt` INT NOT NULL,
    `reg_date` DATETIME
)ENGINE=InnoDB;

INSERT INTO `board` (id, title, writer, content, view_cnt, reg_date)
VALUES
(0, '초기 게시물 1', '김우원1', '테스트용 초기게시물입니다', 0, now()),
(0, '초기 게시물 2', '김우원2', '테스트용 초기게시물입니다', 0, now()),
(0, '초기 게시물 3', '김우원3', '테스트용 초기게시물입니다', 0, now()),
(0, '초기 게시물 4', '김우원4', '테스트용 초기게시물입니다', 0, now());

