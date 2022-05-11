<template>
  <div>
    <span class="click-done" :class="{'is-done' : todo.done}" @click="updateTodo(todo)">{{todo.title}}</span>
    <button @click="deleteTodo(todo)">삭제</button>
  </div>
</template>

<script>
import {mapActions} from "vuex"
export default {
  props:{
    todo: Object
  },
  methods: {
    ...mapActions([
      "deleteTodo", "updateTodo"
    ])
  }
}
</script>

<style>
.click-done{
  cursor: pointer;
}
.is-done{
  text-decoration: line-through;
}
</style>