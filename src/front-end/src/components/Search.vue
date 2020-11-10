<template>
  
  <div class="input search keyword">
    <h1>{{ msg }}</h1>
    <p class="currency-rate info">
      달러 환율 정보: $1 =  {{ currencyRate.toLocaleString('ko-KR', {
                                style: 'currency',
                                currency: 'KRW',
                              }) 
                            }}
    </p>
    
    
    <p>
      <input type="text" size="40" v-model="keyword" placeholder="검색할 책의 제목 혹은 ISBN을 입력하세요" v-on:keypress.enter="searchData" >
      <button v-on:click="searchData">검색</button>
    </p>
    
    <modal v-if="showModal" @close="showModal = false">
      <h3 slot="header">경고</h3>
      <span slot="footer" @click="showModal = false">제목 혹은 ISBN을 입력하세요.
        <i class="closeModalBtn fas fa-times" aria-hidden="true"></i>
      </span>
    </modal>
    <modal v-if="resModal" @close="resModal = false">
      <h3 slot="header">결과</h3>
      <span slot="footer" @click="resModal = false"> {{keyValue}}
        <i class="closeModalBtn fas fa-times" aria-hidden="true"></i>
      </span>
    </modal>

  </div>
  
</template>

<script>

import Modal from './common/Modal.vue'
import axios from 'axios'

export default {
  data() {
    return { 
      keyword: '',
      isbn: '',
      keyValue: '',
      resModal: false,
      showModal: false,
      amazonData: [],
      currencyRate: 1137
    }
  },
  methods: {
      searchKeyword() {
        if (this.keyword !== "") { 
            var value = this.keyword && this.keyword.trim();
            this.keyValue = value;
            this.resModal = !this.resModal;
            this.clearInput();
        } else if (this.resModal == false) {
            this.showModal = !this.showModal;
        } else {
            this.resModal = !this.resModal;
        }
      },
      clearInput() {
          this.keyword = ''
      },
      fetchData() {
        axios.get('/api/books')
        .then(function(response) {
          console.log(response);
        })
        .catch(function(error) {
          console.log(error);
        });
      },
      searchData() {
        if (this.keyword !== "") { 
          if (this.validateIsbn() == true)
          {
            axios.post('/api/amazon/search-books', { isbn: this.keyword } )
            .then(response => { 
              console.log(response.data);
              this.amazonData = response.data;              
              this.$emit('setAmazonBookList', this.amazonData)
            })
          } else {
            axios.post('/api/amazon/search-books', { title: this.keyword } )
            .then(response => { 
              console.log(response.data);
              this.amazonData = response.data;              
              this.$emit('setAmazonBookList', this.amazonData)
            })
          }
        }
      },
      validateIsbn() {
        var str = this.keyword.toString();
        // Todo: 정규식으로 변경
        if (str.startsWith('978') == true) {
          return true;
        } else {
          return false;
        }
      },
      searchDomesticData() {
        if (this.isbn !== "") { 
          axios.post('/api/domestic/search-books', { isbn: this.isbn } )
          .then(res => { console.log(res.data) })
        }
      }
  },
  components: {
    Modal: Modal
  },
  name: 'Search',
  props: {
    msg: String
  }
  

}
</script>

<style>
  input {
    margin: 0px 10px 0px 0px
  }
</style>