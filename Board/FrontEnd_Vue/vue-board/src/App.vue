<template>
  <div id="app">
    <header-nav></header-nav>
    <router-view></router-view>
  </div>
</template>

<script>
import HeaderNav from "@/components/common/HeaderNav.vue"
export default {
  components: {
    HeaderNav
  }
}
</script>
<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}
.text-center {
  text-align: center;
}
.container {
  margin: 0px 30px;
}

.view {
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}

label {
  display: inline-block;
  width: 130px;
}

.btn {
  width: 8%;
  background-color: #d0d3d0;
  color: rgb(80, 82, 79);
  padding: 14px 20px;
  margin: 8px;
  border: 1px solid #787878;
  border-radius: 4px;
  font-size: large;
  cursor: pointer;
}

/* 테이블 CSS */
.board-list {
  border-collapse: collapse;
  width: 100%;
  text-align: center;
  margin: auto;
}

.board-list td,
.board-list th {
  border: 1px solid black;
}
</style>
