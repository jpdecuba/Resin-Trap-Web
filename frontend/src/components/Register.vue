<template>
  <div class="Register">
    <container style="margin-top: 10%; padding-left: 20%; padding-right: 20%;">
      <row>
        <column><MdInput type="checkbox" id="checkbox1" label="Admin" /></column>
      </row>

      <row>
        <column col="1"><fa icon="user-circle"/></column>
        <column><MdInput v-model="user.Username" label="Username" placeholder="Username"/></column>
      </row>

      <row>
        <column col="1"><fa icon="envelope"/></column>
        <column><MdInput v-model="user.Email" label="E-mail" placeholder="E-mail"/></column>
      </row>

      <row>
        <column col="1"><fa icon="lock"/></column>
        <column><MdInput v-model="user.Password" type="password" label="Password" placeholder="Password"/></column>
      </row>

      <row>
        <column col="1"><fa icon="lock"/></column>
        <column><MdInput v-model="user.PasswordConfirm" type="password" label="Confirm Password" placeholder="Password"/></column>
      </row>

      <row>
        <column col="1"><fa icon="group"/></column>
        <column><MdInput v-model="user.Code" label="Code" placeholder="Code"/></column>
      </row>

      <row>
        <column ><btn @click.native="Register()" color="danger">Cancel</btn></column>
        <column ><btn @click.native="Register()" color="danger">Register</btn></column>
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
        console.log("Test")
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

