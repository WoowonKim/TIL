<template>
  <div>
    <h2>Things To Do</h2>
    <todo-list-item v-for="(todo, index) in todos" :key="index" :todo="todo"></todo-list-item>
  </div>
</template>

<script>
import TodoListItem from '@/components/TodoListItem.vue';
import {mapState} from 'vuex';
export default {
  name: 'TodoList',
  components: {
    TodoListItem
  },
  // computed: {
  //   todos(){
  //     return this.$store.state.todos
  //   }
  // }
  computed:{
    ...mapState([
      'todos'
    ])
  }
}
</script>

<style scoped>
h2{
  color: red;
}
</style>