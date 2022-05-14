<template>
  <div class="container">
    <div class="text-center">
      <input type="text" class="view" v-model="key" placeholder="검색어를 입력하세요">
      <button class = "btn" @click="search">검색</button>
    </div>
    <br>
    <hr>
    <board-list></board-list>
  </div>
</template>

<script>
import BoardList from "@/components/board/BoardList.vue"
export default {
  components:{
      BoardList
  },
  data() {
    return {
      key: ""
    };
  },
  methods: {
    search(){
      this.$store.dispatch("searchBoard", this.key)
    }
  },
};

</script>

<style>
</style>