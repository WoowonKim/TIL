<template>
  <header>
    <nav class="header-nav">
      <div>
        <router-link to="/" class="logo">Woowon's Board</router-link>
      </div>
      <div>
        <router-link to="/write" >새 게시물</router-link>
      </div>
    </nav>
  </header>
</template>

<script>
export default {

}
</script>

<style scoped>
header {
  height: 70px;
  background-color: #53e3a6;
  line-height: 70px;
  padding: 0px 30px;
}

.header-nav {
  display: flex;
  justify-content: space-between;
}

header a {
  margin: 10px;
  text-decoration: none;
  color: white;
}

.logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: white;
  margin: 0;
}
</style>