<template>
  <div class="Login" style="margin-top: 70px">
    <container>
      <row class="align-items-center justify-content-center">
        <column md="3"></column>
        <column md="6">
          <MdInput v-model="user.username" label="Username" icon="User" Placeholder="Username"/>
        </column>
        <column md="3"></column>
      </row>
      <row class="align-items-center justify-content-center">
        <column md="3"></column>
        <column md="6">
          <md-input v-model="user.password" type="password" label="Password" icon="Key" Placeholder="Password"/>
        </column>
        <column md="3"></column>
      </row>
      <btn class="z-depth-5" color="red" @click.native="login()">Click Me!</btn>
      <div class="alert alert-danger" v-if="error">
        <p>{{ error }}</p>
      </div>
        <btn class="z-depth-5" color="red"  @click.native="login()">Login</btn>
      <router-link to="/Register">
        <btn class="z-depth-5" color="red"  href="/Register">Register</btn>
      </router-link>
       <div v-if="showResponse"><h1>User created: {{ response }}</h1></div>
    </container>
  </div>
</template>

<script>

  import {Row, Column, Container, Card, CardBody, CardText, Fa, CardImg, Btn, CardTitle, MdInput} from 'mdbvue'
  import auth from '../auth'

  export default {
    name: 'Login',
    components: {
      Container,
      Row, Column, CardText, Card, CardBody, Fa, CardImg, Btn, CardTitle, MdInput
    },
    data() {
      return {
        response: [],
        showResponse: false,
        user: {
          username: '',
          password: '',
          id: 0
        },
        error: '',
        result: false
      }
    }
    ,

    methods: {
      login() {
        auth.login(this, this.user.username, this.user.password)
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  .card-img {
    height: 500px;
  }

  .feat {
    list-style-type: disc;
    display: list-item;
    alignment: left;
    padding-left: 0pt;
    list-style-position: inside;
  }

  .ulist {
    width: 70%;
    margin: auto;
    alignment: left;
    list-style-type: none;
    padding-left: 0pt;
  }

</style>
