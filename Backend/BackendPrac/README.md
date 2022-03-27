# 백엔드 로그인 데이터 조회 게시판 연습

## 구현할 기능

1. emp 테이블로 부터 EMPNO(ID)와 ENAME(PW)로 로그인
2. 사원 조회 기능
   1. EMPNO ENAME JOB DNAME
3. 게시판 기능
   1. 조회
   2. 수정
   3. 삭제

## 작업 순서

1. Maven Project로 변경 후 MVNRepository에서 필요한 dependency 가져오기
   1. mysql
   2. mybatis
   3. jstl
2. DB 연동을 위한 소스폴더(resources) 생성 후,  config, mapper xml 작성, src에 MyAppSqlConfig 작성
   1. board.xml
      1. insertBoard, selectBoard, selectBoardById, updateViewCnt, deleteBoard, updateBoard
   2. emp.xml
      1. selectEmp, selectEmpById

3. mapper를 기반으로 board와 emp의 dao dto 생성
4. 