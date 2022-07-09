import './App.css';
import { Navbar, Container, Nav} from 'react-bootstrap';
import { useState } from 'react';
import data from './data';
import { Routes, Route, useNavigate, Outlet} from 'react-router-dom';
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
            <Nav.Link onClick={()=>{navigate('/detail')}}>Detail</Nav.Link>
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
        <Route path='/detail/:id' element={<div><Detail shoe={shoes}/></div>}/>
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