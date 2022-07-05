function Detail(props){
  return(
    <div className="container">
      <div className="row">
        <div className="col-md-6">
          <img src={props.shoe.imgSrc} width="100%" />
        </div>
        <div className="col-md-6">
          <h4 className="pt-5">{props.shoe.title}</h4>
          <p>{props.shoe.content}</p>
          <p>{props.shoe.price}</p>
          <button className="btn btn-danger">주문하기</button> 
        </div>
      </div>
    </div> 
  )
}

export default Detail