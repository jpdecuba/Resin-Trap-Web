<template>
  <div class="Login">
    <container>
      <div class="alert alert-danger" v-if="error">
        <p>{{ error }}</p>
      </div>
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
      <btn color="red" @click.native="login()">Login</btn>
      <router-link to="/Register">
        <btn color="red">Register</btn>
      </router-link>
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
        if (this.user.username !== '' && this.user.password !== '') {
          this.error = ''
          auth.login(this, this.user.username, this.user.password)
        } else {
          this.error = 'Please fill all fields'
        }
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .Login {
    margin-top: 17%;
    min-height: 100%;
  }

  .btn {
    border-radius: 25px;
  }

</style>
