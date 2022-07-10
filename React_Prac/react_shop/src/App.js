// eslint-disable-next-line
import './App.css';
import { Navbar, Container, Nav} from 'react-bootstrap';
import { useState } from 'react';
import data from './data';
import { Routes, Route, useNavigate} from 'react-router-dom';
import Detail from './routes/Detail';
import axios from 'axios';
function App() {
  let [shoes, setShoes] = useState(data);
  let navigate = useNavigate();
  let [btnCnt, setBtnCnt] = useState(2);
  let [loading, setloading] = useState(false);
  return (
    <div className="App">
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="">Shop</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link onClick={()=>{navigate('/')}}>Home</Nav.Link>
            <Nav.Link onClick={()=>{navigate('/detail/0')}}>Detail</Nav.Link>
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
            {
              loading ? <p>loading...</p> : null
            }
            {
              btnCnt < 4 ?
            <button onClick={()=>{
              setloading(true);
              axios.get('https://codingapple1.github.io/shop/data'+btnCnt+'.json')
              .then((res)=>{
                setBtnCnt(btnCnt+1)
                let copy = shoes.concat(res.data)
                setShoes(copy)
              }).catch((e)=>{
                console.log(e)
              }).finally(()=>{
                setloading(false);
              })
            }}>더보기</button> : null
          }
          </div>}/>
        <Route path='/detail/:id' element={
          <div><Detail shoes={shoes}/></div>
        }/>
      </Routes>
    </div>
  );
}

export default App;

function Card(props) {
  return(
    <div className="col-md-4">
      <img alt='' src={"https://codingapple1.github.io/shop/shoes"+(props.shoe.id+1)+".jpg"} width="80%"/>
      <h4>{props.shoe.title}</h4>
      <p>{props.shoe.price}</p>
    </div>
  );
}