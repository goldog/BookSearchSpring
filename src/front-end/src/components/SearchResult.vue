<template>
  <p v-if="amazonPrice > 0 && domesticPrice > 0">
      {{ message }}
  </p>
</template>

<script>
export default {  
  props: ['propsdata'],
  computed: {
    currencyRate() {      
      return this.propsdata[0];
    },
    amazonPrice (){      
      return this.propsdata[1].price * this.currencyRate;
    },
    domesticPrice (){      
      return this.propsdata[2].price;
    },
    message () {
      let diff = this.amazonPrice - this.domesticPrice;
      if (diff > 0){
        return "국내도서가 약 " + this.getCurrcyStyle(diff) + " 더 쌉니다.";
      } else if (diff < 0){        
        return "아마존 도서가 약 " + this.getCurrcyStyle(diff * -1) + " 더 쌉니다.";
      } else{
        return "가격이 동일합니다."
      }
    }
  },
  methods: {    
    getCurrcyStyle(amount) {
      return amount.toLocaleString('ko-KR', {
                                style: 'currency',
                                currency: 'KRW',
                              });
    },
    
  },
}
</script>

<style>

</style>