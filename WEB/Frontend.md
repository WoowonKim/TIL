# Frontend

## HTML

- img 태그 속성
  - src : img 태그에서 이미지의 경로를 나타낼 때 사용하는 속성	
  - alt : 이미지가 깨졌을때 보이는 명칭
- 링크(a) 태그 속성
  - href : 이동할 주소를 적을 때 사용하는 속성
  - target
    - _self: 기본적으로 들어가있는 속성
    - _blank : 새탭에 링크 열기
  - 같은 페이지에서 원하는 위치로 이동 가능(id 활용 예 <a href="#top">)
- block, inline 성질의 차이점과 주요 태그
  - block : 엘리먼트의 내용과 상관 없이 라인 전체를 차지
    - div, p, h, ul, section
  - inline : 엘리먼트의 내용만큼만 영역
    - span, a ,img
- table: 행과 열로 이루어진 표를 나타낼 때 사용하는 태그 
  - colspan(차지하는 열) , rowspan(차지하는 행): 테이블의 행과 열을 확장할 떄 사용하는 속성
  - tr : 각 행
    - th : 제목
      - thead
    - td : 내용
      - tbody, tfoot

- form : 사용자의 입력 정보를 서버에 전송하기 위해 사용하는 태그
  - action(속성) : 어디에 보낼지 주소를 작성하는 공간
  - input : 사용자의 정보를 입력 받기 위해서 사용하는 태그
    - 속성 :
      - type : 다양한 입력을 받기위해 사용하는 속성
      - name : 서버 보낼 이름, 
      - value : 기본적으로 가지고 있을 값
  - select : option태그와 함께 사용 value에 저장된 값을 서버로 보냄
  - textarea : 여러줄을 입력받을 때 사용

- link : html에서 외부 css 파일을 참조할 때 사용하는 태그
  - href :파일의 경로를 설정하는 속성

## CSS

- 선택자

  - \# : id 속성을 이용
  - . : class 속성을 이용
  - #test * or \#test > * : id가 test인 엘리먼트 하위의 모든 엘리먼트를 선택하는 선택자
  - #test > .memo : id가 test인 엘리먼트 바로 아래 memo 클래스
  - #test .memo : id가 test인 엘리먼트 아래 모든 memo 클래스
  - #test > .memo.bi : id가 test인 엘리먼트  바로 아래 memo와 bi를 모두가진 클래스

- 크기 지정

  - px : 픽셀 단위의 절대크기
  - % : 부모를 기준으로 상대적인 크기
  - em : 부모 기준 배수 단위
  - rem : 루트 태그(16px) 기준 배수 단위

- CSS 속성

  - background ~ : 배경 스타일을 변경할 때 속성
  - border ~ : 엘리먼트의 테두리의 스타일을 변경할 때
  - text ~ : 텍스트의 스타일을 변경할때

- CSS 적용 우선순위

  1. !important
  2. inline style
  3. id
  4. class
  5. 태그

  (동일 조건에서는 스타일 내부의 순서를 따라감)

- Position
  - relative : 있어야할 위치에서 상대적으로
  - absolute : 부모의 시작 (padding 적용x)
  - fixed : 고정
  - static : 변화 x
- flexbox의 주요 개념
  - Main Axios(주축), Cross Axios(교차축)
  - 시작선과 끝선
  - 컨테이너와 아이템
- flex container
  - display 속성을 이용하여 containe를 생성
    - display: flex - block 성격의 container
    - display: inline-flex - inline 성격의 container
  - 주요 속성
    - flex-direction : item들의 나열되는 방향
    - flex-wrap : item들의 크기가 container의 크기보다 클 때 줄넘김
    - flex-flow : 방향과 줄 넘김을 동시에 설정
    - justify-content : 메인 축의 정렬을 제어
    - align-items : 교차축의 정렬을 제어
    - align-content :wrap 속성에 의해서 여러 줄이 발생한 경우의 교차축 정렬
- flex container

## Javascript

