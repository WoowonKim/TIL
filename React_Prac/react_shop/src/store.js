import { configureStore, createSlice } from '@reduxjs/toolkit'
import user from './store/userSlice'
import stock from './store/stockSlice'

export default configureStore({
  reducer: {
    user : user.reducer,
    stock : stock.reducer
  }
}) 