import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from "vuex-persistedstate"

Vue.use(Vuex)

export default new Vuex.Store({
  plugins: [createPersistedState()],
  state: {
    todos:[]
  },
  getters: {
    doneTodosCount(state) {
      console.log(state.todos.filter(todo => todo.done).length)
      return state.todos.filter(todo => todo.done).length
    },
    undoneTodosCount(state){
      return state.todos.filter((todo) => {
        return todo.done === false
      }).length
    }
  },
  mutations: {
    CREATE_TODO(state, payload){
      state.todos.push(payload)
    },
    DELETE_TODO(state, payload){
      const index = state.todos.indexOf(payload)
      state.todos.splice(index,1)
    },
    UPDATE_TODO(state, payload){
      const index = state.todos.indexOf(payload)
      state.todos[index].done = !state.todos[index].done
    }
  },
  actions: {
    createTodo({commit}, todoItem){
      commit('CREATE_TODO', todoItem)
    },
    deleteTodo({commit}, todoItem){
      if(confirm("정말로 삭제하시겠습니까?")){
        commit('DELETE_TODO', todoItem)
      }
    },
    updateTodo({commit}, todoItem){
      commit('UPDATE_TODO', todoItem)
    }
  },
  modules: {
  }
})
