<template>
  
  <div class="input search keyword">
    <h1>{{ msg }}</h1>
    책 정보: 
    
    <input type="text" v-model="keyword" placeholder="검색할 책의 제목 혹은 ISBN을 입력하세요" v-on:keypress.enter="searchKeyword" >
    
    <button v-on:click="searchData">데이터 받기</button>
    
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
      keyValue: '',
      resModal: false,
      showModal: false
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
          axios.post('/api/amazon/search-books', { title: this.keyword } )
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

</style>