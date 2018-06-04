<template>
  <navbar src="static/ResinTrapTiny.png" alt="Brand logo" class="danger-color-dark" href="#/" position="top">
    <navbar-collapse>
      <navbar-nav right>
        <router-link to="/"><navbar-item>Home</navbar-item></router-link>
        <dropdown tag="li" class="nav-item">
          <dropdown-toggle @click.native="toggleDropdown(0)" tag="a" navLink color="danger-color-dark" waves-fixed><i class="fa fa-user-circle fa-lg"></i></dropdown-toggle>
          <dropdown-menu right v-show="active[0]">
            <router-link class="dropdown-item" v-if="!user.authenticated" to="/Login">Login</router-link>
            <router-link class="dropdown-item" v-if="user.authenticated" to="/Login">Logout</router-link>
            <router-link class="dropdown-item" v-if="!user.authenticated" to="/Register">Register</router-link>
            <router-link class="dropdown-item" v-if="user.authenticated" to="/Account">Account</router-link>
          </dropdown-menu>
        </dropdown>
      </navbar-nav>
    </navbar-collapse>
  </navbar>
</template>

<script>
  import {Navbar, NavbarNav, NavbarItem, Dropdown, DropdownItem, DropdownMenu,DropdownToggle, NavbarCollapse, Btn, BtnGroup } from 'mdbvue';
  import 'mdbvue/build/css/mdb.css'
  import 'mdbvue/src/components/Waves.css'
  import auth from '../auth'
  export default {
    data() {
      return {
        active: {
          0: false
        },
        user: auth.user
      };
    },
    components: {
      Navbar,
      NavbarNav,
      NavbarItem,
      NavbarCollapse,
      DropdownMenu,
      DropdownItem,
      DropdownToggle,
      Dropdown,
      Btn,
      BtnGroup
    },
    methods: {
      toggleDropdown(index) {
        for (let i = 0; i < Object.keys(this.active).length; i++) {
          if (index !== i) {
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
      },
      logout() {
        auth.logout()
      }
    },
    mounted() {
      document.addEventListener('click', this.onClick);
    },
    destroyed() {
      document.removeEventListener('click', this.onClick);
    }
  }
</script>
<style>
  .dropdown-item:hover {
    background-color: #CC0000!important;
  }
  .nav-item .nav-link  {
    color: white!important;
  }
  .dropdown .dropdown-menu .dropdown-item:active, .dropdown .dropdown-menu .dropdown-item:hover{color: white !important;}
  .nav-item {
    border-radius: 20px;
    background-color: #CC0000;
    margin: 5px;
    /*box-shadow: 0 1px 2px 0 rgba(60,64,67,0.302), 0 1px 3px 1px rgba(60,64,67,0.149);*/
  }

</style>
