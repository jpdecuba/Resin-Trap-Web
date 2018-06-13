<template>
  <div class="account">
    <container>
      <row>
        <column md="3"></column>
        <column md="6" class="text-left">
          <p>Key: </p>
          <p>{{ key}}</p>
        </column>
        <column md="3"></column>
      </row>
      <row>
        <column md="3"></column>
        <column md="6">
          <md-textarea id="emailtextarea" label="Emails" Placeholder="Emails" disabled></md-textarea>
        </column>
        <column md="3"></column>
      </row>
      <row>
        <column md="3"></column>
        <column md="6" class="text-left">
          <btn id="deletebtn" class="z-depth-5" color="red" @click.native="deleteEmail()">Delete</btn>
          <p class="sub">Choose an email you want to delete from the list</p>
        </column>
        <column md="3"></column>
      </row>
      <row>
        <column md="3"></column>
        <column md="4">
          <md-input id="emailinput" label="New Email" Placeholder="New Email"></md-input>
        </column>
        <column md="2" className="align-self-center">
          <btn id="addbtn" class="z-depth-5" color="red" @click.native="addEmail()">ADD</btn>
        </column>
        <column md="3"></column>
      </row>
      <row>
        <column md="3"></column>
        <column md="6" class="text-left">
          <btn id="changepassbtn" class="z-depth-5" color="red" @click.native="changePass()">Change Password</btn>
          <p class="sub">You will be prompted to enter your current and new password</p>
        </column>
        <column md="3"></column>
      </row>
      <!--features and users (home, small business, big business)-->
    </container>
  </div>
</template>

<script>
  import {
    Row,
    Column,
    Container,
    Fa,
    Btn,
    MdTextarea,
    MdInput
  } from 'mdbvue';

  export default {
    name: 'Account',
    components: {
      MdTextarea,
      MdInput,
      Container,
      Row, Column, Fa, Btn
    },
    data() {
      return {
        key: 'keytest'
      }
    }

    methods: {
      changePass() {
        if (this.user.username !== '' && this.user.password !== '') {
          this.error = ''
          auth.changePass(this,this.user.password)
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
  .account {
    margin-top: 70px;
  }

  .sub {
    font-size: 12px;
    color: #7f7f7f;
  }

  .btn {
    border-radius: 25px;
  }
</style>
