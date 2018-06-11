<template>
  <div class="Register">
    <container style="margin-top: 10%; padding-left: 20%; padding-right: 20%;">
      <row>
        <column class="text-left"><MdInput v-model="admin" type="checkbox" label="Admin" /></column>
      </row>

      <row>
        <column class="text-left"><MdInput v-model="user.Username" label="Username" icon="user-circle" Placeholder="Username"/></column>
      </row>

      <row>
        <column class="text-left"><MdInput v-model="user.Email" label="E-mail" icon="envelope"/></column>
      </row>

      <row>
        <column class="text-left"><MdInput v-model="user.Password" type="password" label="Password" icon="lock"/></column>
      </row>

      <row>
        <column class="text-left"><MdInput v-model="user.PasswordConfirm" type="password" label="Confirm Password" icon="lock"/></column>
      </row>

      <row>
        <column class="text-left"><MdInput v-model="user.Code" label="Code" icon="group"/></column>
      </row>

      <row>
        <column ><btn @click.native="Register()" color="red">Cancel</btn></column>
        <column ><btn @click.native="Register()" color="red">Register</btn></column>
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
  import {AXIOS} from './http-common'

  export default{
    name: 'Register',

    components:{
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
      Dropdown
    },

    data(){
      return{
        admin: '',
        response:[],
        user:{
          Username: '',
          Email: '',
          Password: '',
          PasswordConfirm: '',
          Code: '',
          id: 0
        }
      }
    },

    methods:{

      Register(){
        console.log(this.admin)
      },

      toggleDropdown(index) {
        for(let i =0; i < Object.keys(this.active).length; i++){
          if(index != i){
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
    mounted(){
      document.addEventListener('click', this.onClick);
      document.removeEventListener('click', this.onClick);
    }
  }
</script>
<style scoped>
  .btn {
    border-radius: 25px;
  }
</style>
