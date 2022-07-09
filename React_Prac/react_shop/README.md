# React-Router-Dom

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

