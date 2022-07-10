import {useEffect, useState } from "react";
import {useParams} from "react-router-dom"
import {Nav} from "react-bootstrap";

function Detail(props){
  useEffect(()=>{
    let a = setTimeout(() => {
      setSale(false);
    }, 1000*2);
    return () => {
      clearTimeout(a)
    }
  }, [])
  useEffect(()=>{
    let a = setTimeout(()=>{
      setFade('end');
    }, 100)
    return () =>{
      clearTimeout(a)
      setFade('')
    }
  },[ ])
  let [sale, setSale] = useState(true);
  let {id} = useParams();
  let item = props.shoes.find(x => x.id == id)
  let [tab, setTab] = useState(0);
  let [fade, setFade] = useState('');

  return(
    <div className={`container start ${fade}`}>
      {
        sale === true ? 
        <div className="alert alert-warning">
          2초 이내 구매시 할인
        </div> :
        null
      }
      <div className="row">
        <div className="col-md-6">
          <img src={"https://codingapple1.github.io/shop/shoes" + (item.id + 1) + ".jpg" } width="100%" alt="img"/>
        </div>
        <div className="col-md-6">
          <h4 className="pt-5">{item.title}</h4>
          <p>{item.content}</p>
          <p>{item.price}</p>
          <button className="btn btn-danger">주문하기</button> 
        </div>
      </div>
      <Nav variant="tabs" defaultActiveKey="link0">
        <Nav.Item>
          <Nav.Link eventKey="link0" onClick={()=>{setTab(0)}}>버튼 0</Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link eventKey="link1" onClick={()=>{setTab(1)}}>버튼 1</Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link eventKey="link2" onClick={()=>{setTab(2)}}>버튼 2</Nav.Link>
        </Nav.Item>
      </Nav>
      <TabContent tab={tab}></TabContent>
    </div> 
  )
}
function TabContent(props){
  let [fade, setFade] = useState('')
  useEffect(()=>{
    let a = setTimeout(()=>{setFade('end')},100)
    return () => {
      clearTimeout(a)
      setFade('')
    }
  }, [props.tab])
  return (<div className={`start ${fade}`}>
    { [<div>내용 0</div>, <div>내용 1</div>, <div>내용 2</div>][props.tab]}
    </div>)
}
export default Detail