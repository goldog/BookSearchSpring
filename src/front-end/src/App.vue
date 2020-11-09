<template>
  <div id="app">
    <Search v-on:setAmazonBookList="setAmazonBookList" msg="책 정보 검색"/>
    <BookList></BookList>
  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import Search from './components/Search.vue'
import BookList from './components/BookList.vue'

export default {
  name: 'App',
  data() {
    return {
      amazonBooks: [],
      DomesticBooks: []
    }
  },
  components: {
    Search, 
    BookList
  },
  methods: {
    setAmazonBookList(books) {
      console.log('welcome setAmazonBookList, parameter is') 
      console.log(books);
      this.amazonBooks = books;
      console.log('amazonBooks is') 
      console.log(this.amazonBooks);
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
