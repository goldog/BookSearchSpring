<template>
  <div id="app">
    <Search v-on:setAmazonBookList="setAmazonBookList" msg="책 가격 비교 검색"/> 
    <SearchResult v-bind:propsdata="[currencyRate, amazonSelectedBook, domesticSelectedBook]"></SearchResult>
    <div class="list left">
      <AmazonBookList v-bind:propsdata="amazonBooks" 
                      v-on:setSelectedAmazonBook="setSelectedAmazonBook"
                      v-on:setDomesticBooks="setDomesticBooks"></AmazonBookList>
    </div>
    <div class="list right">
      <DomesticBookList v-bind:propsdata="domesticBooks" 
                      v-on:setSelectedDomesticBook="setSelectedDomesticBook"></DomesticBookList>
    </div>   
  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import Search from './components/Search.vue'
import AmazonBookList from './components/BookList.vue'
import DomesticBookList from './components/DomesticBookList.vue'
import SearchResult from './components/SearchResult.vue'

export default {
  name: 'App',
  data() {
    return {
      amazonBooks: [],
      domesticBooks: [],
      amazonSelectedBook: [],
      domesticSelectedBook: [],
      currencyRate: 1200
    }
  },
  components: {
    Search, 
    AmazonBookList,
    DomesticBookList,
    SearchResult
  },
  methods: {
    setAmazonBookList(books) {
      this.domesticBooks = [];
      this.amazonSelectedBook= [];
      this.domesticSelectedBook = [];
      this.amazonBooks = books;
    },
    setSelectedAmazonBook(book){
      this.domesticSelectedBook = [];
      this.amazonSelectedBook = book;
    },
    setDomesticBooks(book){
      this.domesticBooks = book;
    },
    setSelectedDomesticBook(book){
      this.domesticSelectedBook = book;
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
  #app div{
    min-width: 550px;
  }
  .list{
    float: left;
    margin: 20px;
  }
  #app div .left{
    float: left;
    width: 50
  }
  #app div .right{
    float: right;
  }
  .result{ 
    float: unset;
    margin: auto;
    width: 50%;
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
  
  ul {
    list-style-type: none;
    padding-left: 0px;
    margin-top: 0;
    text-align: left;
  }
  li {
    display: flex;
    min-height: 0px;
    height: 50px;
    line-height: 50px;
    margin: 0.5rem 0;
    padding: 0 0.9rem;
    background: white;
    border-radius: 5px;
  }
  .list-enter-active, .list-leave-active {
    transition: all 1s;
  }
  .list-enter, .list-leave-to {
    opacity: 0;
    transform: translateY(30px);
  }  
  .radio {
    margin-right: 20px;
    display: inline-block;
    cursor: pointer;
  }
  .radio input {
    display: none;
  }
  .ex1 span {
    display: block;
    min-width: 500px;
    padding: 0px 0px 0px 25px;
    border: 0px solid #ddd;
    border-radius: 5px;
    position: relative;
    transition: all 0.25s linear;
  }
  .ex1 span:before {
    content: '';
    position: absolute;
    left: 5px;
    top: 50%;
    -webkit-transform: translatey(-50%);
            transform: translatey(-50%);
    width: 15px;
    height: 15px;
    border-radius: 50%;
    background-color: #ddd;
    transition: all 0.25s linear;
  }
  
  /* .ex1 input:checked + span {
    background-color: #fff;
    box-shadow: 0 0 5px 2px rgba(0, 0, 0, 0.1);
  } */
  .ex1 .blue input:checked + span {
    color: blue;
    border-color: blue;
  }
  .ex1 .blue input:checked + span:before {
    background-color: blue;
  }

  .ex1 .orange input:checked + span {
    color: orange;
    border-color: orange;
  }
  .ex1 .orange input:checked + span:before {
    background-color: orange;
  }
</style>
