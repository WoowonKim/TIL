import { Table } from "react-bootstrap";
import { useSelector, useDispatch } from "react-redux"
import { increaseCount, delStock } from "./../store/stockSlice"
function Cart(){
  let stocks = useSelector((state)=> state.stock )
  let dispatch = useDispatch()
  return(
    <div>
      <Table>
        <thead>
          <tr>
            <th>#</th>
            <th>상품명</th>
            <th>수량</th>
            <th>변경하기</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          {
            stocks.map((stock,i)=>{
              return(
              <tr key={i}>
                <td>{i}</td>
                <td>{stock.name}</td>
                <td>{stock.count}</td>
                <td>
                  <button onClick={()=>{
                    dispatch(increaseCount(stock.id))
                  }}>+</button>
                </td>
                <td>
                  <button onClick={()=>{
                    dispatch(delStock(stock.id))
                  }}>삭제</button>
                </td>
              </tr>
              )
            })
          }
        </tbody>
      </Table> 
    </div>
  )
}
export default Cart