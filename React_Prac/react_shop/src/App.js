import './App.css';
import { Navbar, Container, Nav, AccordionButton} from 'react-bootstrap';
import { useState } from 'react';
import data from './data';
import { Routes, Route, Link, useNavigate, Outlet} from 'react-router-dom';
import Detail from './routes/Detail';
function App() {
let [shoes] = useState(data);
let navigate = useNavigate();
  return (
    <div className="App">
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="#home">Shop</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link onClick={()=>{navigate('/')}}>Home</Nav.Link>
            <Nav.Link onClick={()=>{navigate('/detail')}}>Cart</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      <Routes>
        <Route path='/' element={
        <div>
          <div className="main-bg" ></div>
          <div className='container'>
            <div className='row'>
                {
                  shoes.map(function(shoe){
                    return(
                      <Card shoe={shoe}/>
                    )
                  })
                }
              </div>
            </div>
          </div>}/>
        <Route path='/detail' element={
        <div>
          <Detail shoe={shoes[0]}/>
        </div>
        }/>
        <Route path="/about" element={<About/>}>
          <Route path='member' element={<div>멤버임</div>}/>
          <Route path="location" element={<div>위치정보임</div>}/>
        </Route>
        <Route path="/event" element={<div><h2>오늘의 이벤트</h2><Outlet></Outlet></div>}>
          <Route path='one' element={<div>첫 주문시 양배추즙 서비스</div>}/>
          <Route path="two" element={<div>생일기념 쿠폰 받기</div>}/>
        </Route>
        <Route path="*" element={<div>404커스텀 가능</div>}/>
      </Routes>

      
    </div>
  );
}

export default App;

function Card(props) {
  return(
    <div className="col-md-4">
      <img src={props.shoe.imgSrc} width="80%"/>
      <h4>{props.shoe.title}</h4>
      <p>{props.shoe.price}</p>
    </div>
  );
}

function About(){
  return(
    <div>
      <h4>회사정보임</h4>
      <Outlet></Outlet>
    </div>
  )
}