import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    searchBoards:[]
  },
  getters: {
  },
  mutations: {
    SERACH_BOARD(state, boards){
      state.searchBoards = boards
    }
  },
  actions: {
    searchBoard({commit}, value){
      const API_URL="http://localhost:8080/api/board/"
      const params={
        key: value
      }
      axios({
        url: API_URL,
        method: 'GET',
        params
      })
      .then((res) => {
        commit('SEARCH_BOARD', res.data.item)
      })
      .catch((err)=>{
        console.log(err)
      })
    }
  },
  modules: {
  }
})
