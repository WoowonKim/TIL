<template>
  <div id="app">
    <h2>Todo List App</h2>
    <h3>전체 할일의 수 {{$store.state.todos.length}}</h3>
    <h3>완료 Todo {{doneCount}}</h3>
    <h3>미완료 Todo {{undoneCount}}</h3>
    <todo-list></todo-list>
    <todo-list-write></todo-list-write>
  </div>
</template>

<script>
import TodoList from '@/components/TodoList.vue'
import TodoListWrite from '@/components/TodoListWrite.vue'

export default {
  name: 'App',
  components: {
    TodoList,
    TodoListWrite
  },
  computed:{
    doneCount() {
      return this.$store.getters.doneTodosCount
    },
    undoneCount(){
      return this.$store.getters.undoneTodosCount
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
