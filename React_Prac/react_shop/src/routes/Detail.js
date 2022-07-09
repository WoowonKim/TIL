import {useParams} from "react-router-dom"
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

function Detail(props){
  let {id} = useParams();
  let item = props.shoe.find(x => x.id == id)
  return(
    <div className="container">
      <BlackBox>
        <YellowBtn bg='blue'>버튼</YellowBtn>
      </BlackBox>
      <div className="row">
        <div className="col-md-6">
          <img src={item.imgSrc} width="100%" />
        </div>
        <div className="col-md-6">
          <h4 className="pt-5">{item.title}</h4>
          <p>{item.content}</p>
          <p>{item.price}</p>
          <button className="btn btn-danger">주문하기</button> 
        </div>
      </div>
    </div> 
  )
}

export default Detail