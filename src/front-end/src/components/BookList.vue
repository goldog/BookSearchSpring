<template>
  <section>      
    <h3 v-if="propsdata.length > 0"> 검색 결과 </h3>
    <transition-group name="list" tag="ul">
      <li v-for="item in propsdata" :key="item.id" class="shadow">      
        <label>
        <input type="radio" class="checkradio" name="selectedbook">
          {{ item.title }}, {{ item.isbn }}
        </label>  
      </li>
    </transition-group>
  </section>
</template>

<script>
export default {
  props: ['propsdata'],
//   data () {
//       selectedBook: ''
//   }
}
</script>

<style scoped>
  ul {
    list-style-type: none;
    padding-left: 0px;
    margin-top: 0;
    text-align: left;
  }
  li {
    display: flex;
    min-height: 50px;
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

  .checkradio {
    padding: 0;
  }
  
  input[type="radio"]:not(old){
  width   : 10px;
  margin  : 0;
  padding : 0;
  opacity : 0;
}
  label input {
  display      : inline-block;
  background-color: aqua;
  line-height  : 24px;
}
  label input:checked {
  display      : inline-block;
  background-color: #de4343;
}

input[type="radio"]:not(old) + label {
  display      : inline-block;
  background-color: aqua;
  line-height  : 24px;
}

input[type="radio"]:not(old):checked + label{
  display      : inline-block;
  background-color: #de4343;
}

</style>
