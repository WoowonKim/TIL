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

# [React] React-Router-Dom

### React에서 권장하는 public 폴더 이미지 사용법

``` jsx
<img src={process.env.PUBLIC_URL + '/logo192.png'} /> 
```

## react-router-dom 설치

1. 설치

``` powershell
npm install react-router-dom@6
```

2. index.js에서 import 후, <App/> 감싸기

``` jsx
import { BrowserRouter } from "react-router-dom";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
      <BrowserRouter>
        <App />
      </BrowserRouter>
  </React.StrictMode>
); 
```

## 라우터로 페이지 나누기

1. Routes, Route import

```jsx
import { Routes, Route, Link } from 'react-router-dom'

function App(){
  return (
    (생략);
    <Routes>
      <Route path="/detail" element={ <div>상세페이지</div> } />
      <Route path="/about" element={ <div>어바웃페이지</div> } />
    </Routes>
  )
}
```

> path에 "*"입력 시 유저가 이상한 경로로 접속했을 때 "없는 페이지" 작성 가능 (404)
>
> *이 모든 경로를 뜻하기 때문

## 페이지 이동 버튼

``` jsx
<Link to="/">홈</Link>
<Link to="/detail">상세페이지</Link>
```

또는 useNavigate import 후

``` jsx
function App(){
  let navigate = useNavigate()
  
  return (
    (생략);
    <button onClick={()=>{ navigate('/detail') }}>상세페이지</button>
  )
}
```

## nested routes / outlet

1. /about/member, /about/location을 만드는 두가지 방법

``` jsx
<Route path="/about/member" element={ <div>멤버</div> } />
<Route path="/about/location" element={ <div>위치</div> } />
```

``` jsx
<Route path="/about" element={ <About/> } >  
  <Route path="member" element={ <div>멤버</div> } />
  <Route path="location" element={ <div>위치</div> } />
</Route>
```

아래와 같은 방법을 Nested routes라고 부른다

2. Nested  Routes안의 엘리먼트를 보여주기 위해서는 <Outlet>으로 엘리먼트 위치를 지정해 주어야 한다.

``` jsx
function About(){
  return (
    <div>
      <h4>about페이지</h4>
      <Outlet></Outlet>
    </div>
  )
}
```

## path parameter

``` jsx
<Route path="/detail/:id" element={ <Detail shoes={shoes}/> }/>
```

위 처럼 코드를 작성하면 id에 무엇이 오든 detail페이지에 parameter로 전달할 수 있다

useParams를 import하여 경로에 있는 변수를 사용 가능하다.

``` jsx
import {useParams} from "react-router-dom"
.
.
.;
let {id} = useParams();
```

# [React] Styled-components

> 해당 컴포넌트에만 적용시킬 수 있는 CSS

## 설치

``` powershell
npm install styled-components
```

사용하고자 하는 컴포넌트에 임포트

``` jsx
import styled from 'styled-components'
```

## 사용법

1. 컴포넌트를 만들 때 스타일을 미리 주입할 수 있다.
2. 컴포넌트 사용시 CSS 값을 props로 전달받을 수 있다.
3. 자바스크립트를 작성 가능하기 때문에 간단한 프로그래밍이 가능하다

``` jsx
import styled from "styled-components";

let YellowBtn = styled.button`
  background : ${props => props.bg};
  color : ${ props => props.bg == 'blue' ? 'white' : 'black' };
  padding : 10px;
`
let BlackBox = styled.div`
  background : grey;
  padding : 20px
`
function Detail(){
  return(
    <div className="container">
      <BlackBox>
        <YellowBtn bg='blue'>버튼</YellowBtn>
      </BlackBox>
    </div> 
  )
}

```

## 장점

1. 다른 JS파일에 영향을 주지 않는다.

   > 일반 CSS 파일도 컴포넌트명.module.css라고 작명하면 가능하다.

2. 페이지 로딩시간이 단축된다

## 단점

1. JS파일이 매우복잡해진다
2. 다른 파일에서 Import해서 사용가능한데 그러면 CSS파일 사용하는거와 차이가 없다.

# [React] LifeCycle/useEffect

> 컴포넌트가 생성, 재렌더링, 삭제 될때 실행할 코드 작성 가능

1. mount

   생성

2. update

   재랜더링

3. unmount

   삭제

### class 문법에서의 Lifecycle hook

``` jsx
class Detail extends React.Component {
  componentDidMount(){
    //Detail 컴포넌트가 로드되고나서 실행할 코드
  }
  componentDidUpdate(){
    //Detail 컴포넌트가 업데이트 되고나서 실행할 코드
  }
  componentWillUnmount(){
    //Detail 컴포넌트가 삭제되기전에 실행할 코드
  }
}
```

### 요즘 리엑트에서의 Lifecycle hook

> useEffect 안에 적은 코드는 html이 렌더링 된 이후에 동작

1. 재렌더링 마다 코드실행

``` jsx
useEffect(()=>{ 실행할코드 })
```

2. mount시 1회만 실행

``` jsx
useEffect(()=>{ 실행할코드 }, [ ])
```

> [ ]안에 state를 입력하면, 해당 state가 변경될 때만 실행 (여러개 가능)

3. useEffect() 안의 코드 실행 전에 실행

``` jsx
useEffect(()=>{ 
    ... (나중에 실행됨)
  return ()=>{
    실행할코드(먼저 실행됨)
  }
})
```

> 보통 clean up function이라 하며 타이머 제거, 소켓 연결 요청 제거, ajax요청 중단시 사용

4. unmount시 1회 실행

``` jsx
useEffect(()=>{ 
  return ()=>{
    실행할코드
  }
}, [ ])
```

