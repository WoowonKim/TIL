# 데이터베이스

- 여러 사람이 공유하고 사용할 목적으로 통합 관리되는 정보의 집합

- 논리적으로 연관된 하나 이상의 자료의 모음으로 고도로 구조화 함으로써 검색과 갱신으 효율화
- 몇 개의 자료 파일을 조직적으로 통합하여 자료 항목의 중복을 없애고 자료를 구조화하여 기억시켜 놓은 자료의 집합체

## DBMS(Database Management System)

- 데이터베이스 조작 인터페이스 제공
- 효율적인 데이터 관리 기능제공
- 데이터베이스 구축 기능 제공
- 데이터 복구, 사용자 권한부여, 유지보수 기능 제공

## 관계형 데이터 베이스

- 테이블 기반의 DB
- 데이터를 테이블 단위로 관리
  - 하나의 데이터, 여러 속성
  - 데이터 중복 최소화
  - 테이블 간의 관계를 이용하여 데이터 검색 가능

## SQL(Structured Query Language)

관계형 데이터 베이스에서 데이터 조작과 데이터 정의를 위해 사용하는 언어

- 데이터 조회
- 데이터 삽입, 삭제, 수정
- DB Object 생성 및 변경, 삭제
- DB 사용자 생성 및 삭제, 권한 제어

표준 SQL은 모든 DBMS에서 사용 가능

### SQL 특징

- 대소문자를 구별하지 않는다. (데이터의 대소문자는 구분)
- 절차적인 언어가 아니라 선언적 언어이다.
- DBMS에 종속적이지 않다.

### DML(Data Manipulation Language) 

데이터 조작 언어

- 데이터베이스에서 데이터를 조작하거나 조회할 때 사용
- 테이블의 레코드를 CRUD(Create, Read, Update, Delete)

문장 : SELECT, INSERT, UPDATE, DELETE

### DDL(Data Definition Language)

데이터 정의 언어

- 데이터 베이스 객체(table, view, user, index 등)의 구조를 정의

문장 : CREATE, ALTER, DROP, RENAME

### TCL(Transaction Control Language)

트랜잭션 제어 언어

- 트랜잭션단위로 실행한 명령문을 적용하거나 취소

문장 : COMMIT, ROLLBACK

### DCL(Data Control Language)

데이터 제어 언어

- Database, Table 접근권한이나 CRUD권한 정의
- 특정 사용자에게 테이블의 검색권한 부여/금지

문장 : GRANT, REVOKE