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

