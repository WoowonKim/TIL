/* eslint-disable */
import './App.css';
import { useState } from 'react';
function App() {
  let [title, setTitle] = useState(['남자 코트 추천','강남 우동 맛집','파이썬 독학']);
  let [cnts, addCnts] = useState([0,0,0]);
  let [modal, setModal] = useState(false);
  let [titleIdx, setTitleIdx] = useState(0);
  let [input, setInput] = useState('');
  return (
    <div className="App">
      <div className="black-nav">
        <h4 style={{color : 'red',fontSize:'20px'}}>React Blog</h4>
      </div>
      <span onClick={()=>{
          let copy = [...title];
          copy[0] = '여자코트 추천'
          setTitle(copy)}} >change</span>
      <button onClick={()=>{
        let copy = [...title];
        setTitle(copy.sort())
      }}>정렬</button>
      {/* <div className="list">
        <h4>{title[0]} <span onClick={()=>{addCnt(cnt+1)}}>👍</span> {cnt} </h4>
        <p>2월 17일 방행</p>
      </div>
      <div className="list">
        <h4>{title[1]}</h4>
        <p>2월 17일 방행</p>
      </div>
      <div className="list">
        <h4 onClick={()=>{
          setModal(!modal)
          }}>{title[2]}</h4>
        <p>2월 17일 방행</p>
      </div> */}
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
      <input onChange={(e)=>{
        setInput(e.target.value)
      }} ></input>
      <button onClick={()=>{
        let copy = [...title]
        copy.push(input)
        cnts.push(0);
        setTitle(copy)
      }}>등록</button>
      {
        modal == true ? <Modal color="skyblue" titleIdx={titleIdx} title={title} setTitle={setTitle}/> : null
      }
    </div>
  );
}
function Modal(props){
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
}
export default App;
