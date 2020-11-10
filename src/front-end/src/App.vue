<template>
  <div id="app">
    <Search v-on:setAmazonBookList="setAmazonBookList" msg="책 가격 비교 검색"/>
    <div class="list">
      <AmazonBookList v-bind:propsdata="amazonBooks" ></AmazonBookList>
    </div>
    <div class="list">
      <DomesticBookList></DomesticBookList>
    </div>
  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import Search from './components/Search.vue'
import AmazonBookList from './components/BookList.vue'
import DomesticBookList from './components/DomesticBookList.vue'

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
    AmazonBookList,
    DomesticBookList
  },
  methods: {
    setAmazonBookList(books) {
      this.amazonBooks = books;
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
.list{
  float: left;
  margin: 20px;
}
  body {
    text-align: center;
    background-color: #F6F6F8;
  }
  /* input {
    border-style: groove;
    width: 200px;
  } */
  button {
    border-style: groove;
  }
  .shadow {
    box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03)
  }
</style>
