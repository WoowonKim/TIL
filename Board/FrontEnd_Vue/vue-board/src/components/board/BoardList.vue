<template>
  <div class="container">
    <h2>게시글 목록</h2>

    <div v-if="boards.length">
      <table class="board-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 40%" />
          <col style="width: 20%" />
          <col style="width: 20%" />
          <col style="width: 15%" />
        </colgroup>
        <thead>
          <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
            <th>조회수</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(board, index) in boards" :key="index">
            <td>{{ index + 1 }}</td>
            <td>
              <router-link class="board-link" :to="`/${board.id}`">{{
                board.title
              }}</router-link>
            </td>
            <td>{{ board.writer }}</td>
            <td>{{ board.datetime }}</td>
            <td>{{ board.viewCnt }} 회</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div v-else>등록된 게시물이 없습니다.</div>
  </div>
</template>

<script>
export default {
  methods: {},
  data(){
  },
  computed: {

    boards(){
      return this.$store.state.boards
    }
  }
}
</script>

<style>

</style>