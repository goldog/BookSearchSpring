<template>
  <section>
    <div v-if="propsdata.length > 0" class="ex1">
    <h3 >Amazon 도서 검색 결과</h3>    
    <p v-if="selectedBook.isbn > 0">
      선택 한 책의 ISBN: {{ selectedBook.isbn }}        
      <button @click="searchData">국내 도서에서 찾기</button>
    </p>
    <p v-else>항목을 선택해줘요..</p>
    <transition-group name="list" tag="ul">
      <li v-for="item in propsdata" :key="item.id" class="shadow">      
        <label  class="radio blue">
          <input type="radio" v-model="selectedBook" v-bind:value="item" name="selectedbookGroup1"/>
          <span>
            {{ item.title }}, {{ item.author}}, {{ getCurrcyStyle(item.price) }}
          </span>
        </label>  
      </li>
    </transition-group>    
      
    </div>      
    <div v-else>      
      <h3>Amazon 도서 검색 결과</h3>
      <h4>검색 결과가 없네요...</h4>
    </div> 
  </section>
</template>

<script>
import axios from 'axios'

export default {
  props: ['propsdata'],
  // 새로운 검색이 수행되면 선택된 책 정보를 초기화 함
  watch: {
    propsdata(){
      this.selectedBook = []
    },
    // selectedBook() {      
    //   this.$emit('setSelectedAmazonBook', []);
    // }
  },
  data () {
    return {
      selectedBook: [],  
      domesticBooks: [],
    }
  },
  methods: {
    searchData() {      
      this.$emit('setSelectedAmazonBook', this.selectedBook);

      this.domesticBooks = [];

      axios.post('/api/domestic/search-books', { isbn: this.selectedBook.isbn } )
            .then(response => { 
              console.log(response.data);
              this.domesticBooks = response.data;              
              this.$emit('setDomesticBooks', this.domesticBooks)
            })

    },    
    getCurrcyStyle(amount) {
      return amount.toLocaleString('en-US', {
                                style: 'currency',
                                currency: 'USD',
                              });
    }
  }  
}
</script>

<style scoped>
</style>
