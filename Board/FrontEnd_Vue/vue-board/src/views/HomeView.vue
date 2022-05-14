<template>
  <div>
    <br />
    <div class="text-center">
      <h1>{{ message }}</h1>
    </div>
    <br />
    <board-search></board-search>
  </div>
</template>

<script>
import BoardSearch from '@/components/board/BoardSerch.vue'
export default {
  components:{
    BoardSearch
  },
  data(){
    return{
      message: "김우원의 게시판"
    }
  }
}
</script>

<style>

</style>