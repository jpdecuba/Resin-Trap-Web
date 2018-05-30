<template>
  <div class="Login">
    <container>
      <row>
        <md-input v-model="user.UserName" label="Username" icon="User" Placeholder="Username"/>
      </row>
      <row>
        <md-input v-model="user.Password" type="password" label="Password" icon="Key" Placeholder="Password"/>
      </row>
      <btn class="z-depth-5" color="red"  @click="Login()">Click Me!</btn>
       <div v-if="showResponse"><h6>User created: {{ response }}</h6></div>
    </container>
  </div>
</template>

<script>
  import {Row, Column, Container, Card, CardBody, CardText, Fa, CardImg, Btn, CardTitle, MdInput} from 'mdbvue';
  import {AXIOS} from './http-common'

  export default {
    name: 'Login',
    components: {
      Container,
      Row, Column, CardText, Card, CardBody, Fa, CardImg, Btn, CardTitle, MdInput
    },
    data () {
          return {
            response: [],
            user: {
              Username: '',
              Password: '',
              id: 0
            }
          }
  },

   methods: {
    Login () {
       var params = new URLSearchParams()
              params.append('firstName', this.user.firstName)
              params.append('lastName', this.user.lastName)
              AXIOS.post(`/login`, params)
                .then(response => {
                                  // JSON responses are automatically parsed.
                                  this.response = response.data
                                  console.log(response.data)
                                  this.showResponse = true
                                })
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
    list-style-type:none;
    padding-left: 0pt;
  }

</style>
