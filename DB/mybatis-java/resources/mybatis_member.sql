create database mybatisdb;

use webex;

CREATE TABLE `mybatis_member` (
  `id` varchar(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `addr` varchar(100) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `join_date` timestamp NOT NULL DEFAULT now(),
  PRIMARY KEY (`id`)
);

insert into mybatis_member(id, name, addr, email) values
('member-1', '서울', 'seoul', 'seoul@ssafy.com'),
('member-2', '구미', 'gumi', 'gumi@ssafy.com'),
('member-3', '대전', 'daejeon', 'daejeon@ssafy.com'),
('member-4', '부울경', 'buulgyeong', 'eee@ssafy.com');

commit;

select * from mybatis_member;