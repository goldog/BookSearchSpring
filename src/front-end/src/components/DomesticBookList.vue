<template>
  <section>
    <div v-if="propsdata.length > 0" class="ex1">
      <h3 >국내 도서 검색 결과</h3>      
        <p v-if="selectedBook.isbn > 0">
          <button @click="searchData">아마존 도서와 가격비교</button>
        </p>
        <p v-else>항목을 선택해줘요..</p>
        <transition-group name="list" tag="ul">
        <li v-for="item in propsdata" :key="item.id" class="shadow">      
            <label class="radio orange">
            <input type="radio" v-model="selectedBook" v-bind:value="item" name="selectedbookGroup2"/>
            <span>
                {{ item.title }}, {{ item.author}}, {{ getCurrcyStyle(item.price) }}
            </span>
            </label>  
        </li>
        </transition-group>    
      </div>
      <div v-else>
        <h3>국내 도서 검색 결과</h3>
        <h4>검색 결과가 없네요...</h4>
      </div>
  </section>
</template>

<script>
export default {
  props: ['propsdata'],
  // 새로운 검색이 수행되면 선택된 책 정보를 초기화 함
  watch: {
    propsdata(){
      this.selectedBook = []
    }
  },
  methods: {        
    getCurrcyStyle(amount) {
      return amount.toLocaleString('ko-KR', {
                                style: 'currency',
                                currency: 'KRW',
                              });
    },
    searchData(){        
      this.$emit('setSelectedDomesticBook', this.selectedBook);
    }
  },
  data () {
    return {
      selectedBook: []
    }
  }
}
</script>

<style scope>

</style>