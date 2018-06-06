<template>
  <div id="app">
    <navbar></navbar>
    <router-view/>
    <footer class="page-footer foot font-small red pt-4 mt-4"></footer>
  </div>
</template>

<script>
  import Navbar from './components/Navbar'
  import {Footer} from 'mdbvue';

  export default {
    name: 'App',
    components: {
      Navbar, Footer
    }
  }
</script>

<style>
  @font-face {
    font-family: 'gsans';
    src: url('./assets/GoogleSans-Regular.ttf') format('truetype'),
    url('./assets/GoogleSans-Medium.ttf') format('truetype'),
    url('./assets/GoogleSans-Bold.ttf') format('truetype');
    font-weight: normal;
    font-style: normal;
  }
  #app {
    font-family: 'gsans', 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    margin-top: 0px;
  }
  .foot {
    background-color: #CC0000 !important;
    bottom:0;
    position: fixed;
    width: 100%;
  }
  @media only screen and (max-width: 480px) {
    .foot {
      position: static;
      display: none;
    }
  }
</style>
