<template>
  <div id="app">
    <navbar></navbar>
    <router-view/>
  </div>
</template>

<script>
  import Navbar from './components/Navbar'

  export default {
    name: 'App',
    components: {
      Navbar
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
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
