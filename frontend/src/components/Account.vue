<template>
  <div class="home">
    <container>
      <row>Key: <label id="keylabel">[keylabel]</label></row>
      <row>Emails:<br> <md-textarea id="emailtextarea"></md-textarea></row>
      <row><btn id="deletebtn">Delete</btn></row>
      <row class="align-items-center">
        <column ><md-input id="emailinput">Email</md-input></column>
        <column className="align-self-center"><btn id="addbtn">ADD</btn></column>
      </row>
      <row>
        <btn id="changepassbtn">Change Password</btn>
      </row>
      <!--features and users (home, small business, big business)-->
    </container>
  </div>
</template>

<script>
  import {Row, Column, Container, Card, CardBody, CardText, Fa, CardImg, Btn, CardTitle, MdTextarea, MdInput} from 'mdbvue';

  export default {
    name: 'Home',
    components: {
      MdTextarea,
      MdInput,
      Container,
      Row, Column, CardText, Card, CardBody, Fa, CardImg, Btn, CardTitle
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

  #keylabel {

  }
</style>
