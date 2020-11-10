<template>
  <section>      
    <h3 v-if="propsdata.length > 0"> 검색 결과 </h3>
    <transition-group name="list" tag="ul">
      <li v-for="item in propsdata" :key="item.id" class="shadow">      
        <label  class="radio">
          <input type="radio" name="selectedbook"/>
          <span>
            {{ item.title }}, 
          </span>
        </label>  
      </li>
      
      <!-- <label class="radio" v-for="item in propsdata" v-bind:key="item.id">
        <input type="radio" name="groupOne" />
        <span>{{ item.title }}, {{ item.isbn }}</span>
      </label> -->

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
  .radio span {
    display: block;
    width: 500px;
    min-width: 300px;
    padding: 0px 0px 0px 25px;
    border: 2px solid #ddd;
    border-radius: 5px;
    position: relative;
    transition: all 0.25s linear;
  }
  .radio span:before {
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

  .radio input:checked + span {
    color: blue;
    border-color: blue;
  }
  .radio input:checked + span:before {
    background-color: blue;
  }
</style>
