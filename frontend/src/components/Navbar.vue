<template>
  <navbar src="static/ResinTrapTiny.png" alt="Brand logo" class="danger-color-dark" href="#" position="top">
    <navbar-collapse  class="justify-content-end">
      <navbar-nav >
        <navbar-item href="#">Home</navbar-item>
        <navbar-item href="#">Features</navbar-item>
        <navbar-item href="#">Pricing</navbar-item>
      </navbar-nav>
    </navbar-collapse>
  </navbar>
</template>

<script>
  import {Navbar, NavbarNav, NavbarItem, Dropdown, DropdownItem, DropdownMenu,DropdownToggle, NavbarCollapse} from 'mdbvue';
  import 'mdbvue/build/css/mdb.css'
  import 'mdbvue/src/components/Waves.css'
  export default {
    components: {
      Navbar,
      NavbarNav,
      NavbarItem,
      NavbarCollapse
    }
  }
</script>
<style>
  .nav-item .nav-link  {
    color: white!important;
  }
</style>
