<template>
  <div class="Register">
    <container>
      <div class="alert alert-danger" v-if="error">
        <p>{{ error }}</p>
      </div>
      <row>
        <column class="text-left">
          <MdInput @click.native="samplefunction($event)" type="checkbox" label="Admin"/>
        </column>
      </row>

      <row>
        <column class="text-left">
          <MdInput v-model="user.Username" label="Username" icon="user-circle" Placeholder="Username"/>
        </column>
      </row>

      <row>
        <column class="text-left">
          <MdInput v-model="user.Email" label="E-mail" icon="envelope"/>
        </column>
      </row>

      <row>
        <column class="text-left">
          <MdInput v-model="user.Password" type="password" label="Password" icon="lock"/>
        </column>
      </row>

      <row>
        <column class="text-left">
          <MdInput v-model="user.PasswordConfirm" type="password" label="Confirm Password" icon="lock"/>
        </column>
      </row>

      <row>
        <column class="text-left">
          <MdInput v-if="!admin" v-model="user.Code" label="Code" icon="group"/>
        </column>
      </row>

      <row class="mb-5">
        <column>
          <router-link to="/Login">
            <btn color="red">Cancel</btn>
          </router-link>
        </column>
        <column>
          <btn @click.native="Register()" color="red">Register</btn>
        </column>
      </row>
    </container>
  </div>
</template>

<script>
  import {
    Row,
    Column,
    Container,
    Card,
    CardBody,
    CardText,
    Fa,
    CardImg,
    Btn,
    CardTitle,
    MdInput,
    Dropdown,
    DropdownItem,
    DropdownMenu,
    DropdownToggle
  } from 'mdbvue';
  import auth from '../auth'

  export default {
    name: 'Register',

    components: {
      Container,
      Row,
      Column,
      CardText,
      Card,
      CardBody,
      Fa,
      CardImg,
      Btn,
      CardTitle,
      MdInput,
      DropdownMenu,
      DropdownItem,
      DropdownToggle,
      Dropdown,
    },

    data() {
      return {
        admin: '',
        response: [],
        user: {
          Username: '',
          Email: '',
          Password: '',
          PasswordConfirm: '',
          Code: '',
          id: 0
        },
        error: '',
      }
    },

    methods: {

      Register() {
        if (this.user.Username !== '' && this.user.Password !== '' && this.user.Email !== '' && this.user.PasswordConfirm !== '' && this.user.Password === this.user.PasswordConfirm) {
          if (this.admin != '') {
            this.error = ''
            this.user.role = 'Admin'
            auth.signup(this, this.user)
          } else if (this.admin == '' && this.user.Code !== '') {
            this.error = ''
            this.user.role = 'User'
            auth.signup(this, this.user)
          } else {
            this.error = 'Please fill all fields'
          }
        } else if (this.user.Password !== this.user.PasswordConfirm) {
          this.error = 'Password is not the same as confirmation password'
        } else
        {
          this.error = 'Please fill all fields'
        }
      },
      samplefunction: function (event) {
        if (event.target.checked) {
          this.admin = "checked"
        }
        else {
          this.admin = ""
        }
      },
      toggleDropdown(index) {
        for (let i = 0; i < Object.keys(this.active).length; i++) {
          if (index != i) {
            this.active[i] = false;
          }
        }
        this.active[index] = !this.active[index];
      },

      allDropdownsClose(target) {
        for (let i = 0; i < Object.keys(this.active).length; i++) {
          this.active[i] = false;
        }
      },

      onClick(e) {
        let parent = e.target;
        let body = document.getElementsByTagName('body')[0];
        while (parent !== body) {
          if (parent.classList.contains('dropdown') || parent.classList.contains('btn-group')) {
            return;
          }
          parent = parent.parentNode;
        }
        this.allDropdownsClose(e.target);
      }

    },
    mounted() {
      document.addEventListener('click', this.onClick);
      document.removeEventListener('click', this.onClick);
    }
  }
</script>
<style scoped>
  .btn {
    border-radius: 25px;
  }

  .Register {
    margin-top: 6%;
    padding-left: 20%;
    padding-right: 20%;
  }

  @media only screen and (max-width: 480px) {
    .Register {
      margin-top: 17%;
      padding-left: 0;
      padding-right: 0;
    }
  }
</style>
