<template>
  <div>
    <h2>Add To do</h2>
    <input type="text" v-model.trim="newTodo" @keyup.enter="createTodo" ref="todoInput">
    <button @click="createTodo">등록</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      newTodo: ''
    }
  },
  methods : {
    createTodo() {
      const todoItem = {
        title : this.newTodo,
        done : false,
      }
      if(this.newTodo) {
        this.$store.dispatch("createTodo", todoItem)
      } else{
        alert("내용을 입력하세요")
        this.$refs.todoInput.focus();
      }
      this.newTodo = ''
    }
  }
}
</script>

<style>

</style>