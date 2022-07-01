/* eslint-disable */
import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
function App() {
  let [title, b] = useState(['남자 코트 추천','강남 우동 맛집','파이썬 독학']);
  let [cnt, addCnt] = useState(0);
  let head = 'blog';
  return (
    <div className="App">
      <div className="black-nav">
        <h4 style={{color : 'red',fontSize:'20px'}}>React Blog</h4>
      </div>
      <span onClick={()=>{
          let copy = [...title];
          copy[0] = '여자코트 추천'
          b(copy)}} >change</span>
      <button onClick={()=>{
        let copy = [...title];
        b(copy.sort())
      }}>정렬</button>
      <div className="list">
        <h4>{title[0]} <span onClick={()=>{addCnt(cnt+1)}}>👍</span> {cnt} </h4>
        <p>2월 17일 방행</p>
      </div>
      <div className="list">
        <h4>{title[1]}</h4>
        <p>2월 17일 방행</p>
      </div>
      <div className="list">
        <h4>{title[2]}</h4>
        <p>2월 17일 방행</p>
      </div>
      <Modal></Modal>
    </div>
  );
}
function Modal(){
  return (
    <div className='Modal'>
      <h4>제목</h4>
      <p>날짜</p>
      <p>상세내용</p>
    </div>
  )
}
export default App;
