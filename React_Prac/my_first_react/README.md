# React 시작하기

>이번에 새로 진행할 프로젝트에서 프론트 개발을 맡게 되었다.
>팀원들과 협의 끝에 React를 사용하기로 하였다.
>이유는 현재 취업시장에서 가장 많이 사용되기 때문이다.
>프로젝트를 시작하기 전에 간단하게 사용법을 익히고자 한다.

## React 프로젝트 생성

- Node.js 설치
- 터미널에 명령어 입력

``` powershell
npx create-react-app 프로젝트 명
```

- 미리보기 명령어

```powershell
npm start
```

## JSX

>자바스크립트 내에서 html을 쉽게 작성할 수 있게 도와주는 언어

### 문법

- 클래스 부여 class x => className o

  - 자바 스크립트 내 class와 겹치기 때문에

- 중괄호 문법 (데이터 바인딩)

  - 변수 설정 후 중괄호로 html어디서든 사용가능

    ```jsx
    function App() {
    	let head = 'blog';
     	return (
        	<div className="App">
          		<div className="black-nav">
            		<h4 style={{color : 'red',fontSize:'20px'}}>{head}</h4>
          		</div>
          .
          .
          .
    ```

- style 속성

  - inner style 속성은 중괄호 안에 객체형태로 입력

  ```html
  <h4 style={{color : 'red',fontSize:'20px'}}>{head}</h4>
  ```

   - camelCase 사용

## State

  > 변수를 사용하기 보단 State를 사용하면 값이 변경 될때마다 html이 자동으로 렌더링된다.

  ```javascript
import { useState } from 'react';
  
let [a, b] = useState('blog')
  ```

  - state에 저장된 값을 사용할땐, a
 - state에 저장된 값을 변경할땐, b

```jsx
let [cnt, addCnt] = useState(0);
.
.
.
<h4><span onClick={()=>{addCnt(cnt+1)}}>👍</span> {cnt} </h4>
```

  - array/object도 가능
   - 단 변경시 copy를 만드는 것을 권장

```jsx
<span onClick={()=>{
      let copy = [...title];
      copy[0] = '코트 추천'
      b(copy)}} >change</span>
```

## Component

> HTML 코드를 모듈화 가능

- 컴포넌트 만드는 법
  - 사용하고자 하는 위치에 <함수명><함수명/> or <함수명/>
  - fucntion 생성 후 return()에 html코드 작성

```jsx
function Modal(){
  return (
    <div className='Modal'>
      <h4>제목</h4>
      <p>날짜</p>
      <p>상세내용</p>
    </div>
  )
}
```

## 동적 UI 만들기

> 유저 조작에 따라 형태가 바뀌는 UI

1. UI 디자인 하기

2. UI의 현재 상태 State로 저장

3. State에 따라서 UI가 어떻게 보일지 조건 or 반복문 작성 

   - JSX애서 조건문 반복문 작성법 (3항 연산자, map 활용)

     ```jsx
     {
         modal == true ? <Modal color="skyblue" titleIdx={titleIdx} title={title} setTitle={setTitle}/> : null
     }
     ```

     ```jsx
     {
             title.map(function(a, i){
               return(
                 <div className="list">
                   <h4 onClick={(e)=>{
                     setModal(!modal)
                     setTitleIdx(i)
                     }}>{a}
                     <span onClick={(e)=>{
                       e.stopPropagation();
                       let copy = [...cnts]
                       copy[i]++
                       addCnts(copy)
                     }}>👍</span> {cnts[i]}
                     <button onClick={(e)=>{
                       e.stopPropagation()
                       let copy = [...title]
                       copy.splice(i,1)
                       cnts.splice(i,1)
                       setTitle(copy)
                     }}>삭제</button>
                   </h4>
                   <p>2월 17일 발행</p>
                 </div>
               )
             })
     }
     ```

## PROPS

> 자식 컴포넌트가 부모 컴포넌트에 있던 state를 사용하려면 부모가 props로 state를 전송해야 한다.

- props로 state 전달하기
  - <자식컴포넌트 변수이름={state이름}/}

- 전달받은 state 사용하기
  - props.state이름

```jsx
{//부모 컴포넌트
    modal == true ? <Modal color="skyblue" titleIdx={titleIdx} title={title} setTitle={setTitle}/> : null
}
```

```jsx
function Modal(props){//자식컴포넌트
  return (
    <div className='Modal' style={{background: props.color}}>
      <h4>{props.title[props.titleIdx]}</h4>
      <p>날짜</p>
      <p>상세내용</p>
      <button onClick={()=>{
        let copy = [...props.title]
        copy[0] = '여자 코트 추천'
        props.setTitle(copy)
      }}>change</button>
    </div>
  )
```

