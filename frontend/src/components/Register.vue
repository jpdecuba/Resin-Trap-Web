<template>
  <div class="Register">
    <container>
      <row>
        <column></column>
        <column>

        </column>
        <column></column>
      </row>

      <row>
        <column></column>
        <column>
          <MdInput v-model="user.Username" label="Username" icon="user-circle" placeholder="Username"/>
        </column>
        <column></column>
      </row>

      <row>
        <column>
          <MdInput v-model="user.Email" label="E-mail" icon="envelope" placeholder="E-mail"/>
        </column>
      </row>

      <row>
        <column>
          <MdInput v-model="user.Password" label="Password" icon="lock" placeholder="Password"/>
        </column>
      </row>

      <row>
        <MdInput v-model="user.PasswordConfirm" label="Confirm Password" icon="lock" placeholder="Password"/>
      </row>

      <row align="align-items-center">
        <column>
          <MdInput v-model="user.Code" label="Code" icon="Group" placeholder="Code"/>
        </column>
      </row>

      <row>
        <column>
          <btn @click.native="Register()" label="Cancel"/>
          <btn @click.native="Register()" label="Register"/>
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
          Code: 0,
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
