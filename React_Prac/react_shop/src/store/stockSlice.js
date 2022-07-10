import {createSlice} from "@reduxjs/toolkit"
let stock = createSlice({
  name : 'stock',
  initialState : [
    {id : 0, name : 'White and Black', count : 2},
    {id : 2, name : 'Grey Yordan', count : 1}
  ],
  reducers : {
    addStock(state, action){
      state.push(action.payload)
    },
    increaseCount(state, action){
      state.find(x => x.id == action.payload).count += 1
    },
    delStock(state, action){
      let item = state.findIndex(x=> x.id == action.payload)
      state.splice(item,1)
    }
  }
})
export let {addStock, increaseCount, delStock} = stock.actions
export default stock