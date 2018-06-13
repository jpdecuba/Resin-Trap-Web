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
          <btn id="passPopupBtn" class="z-depth-5" color="red" @click.native="(showModal = true)(Message = 'Change password')">Change Password</btn>
          <p class="sub">You will be prompted to enter your current and new password</p>
        </column>
        <column md="3"></column>
      </row>

      <modal v-if="showModal" @close="showModal = false">
        <modal-header>
          <modal-title>{{Message.Protocol}}</modal-title>
        </modal-header>
        <modal-body>{{Message.Message}}</modal-body>
        <md-input id="newPass1" label="New password" Placeholder="New password"></md-input>
        <md-input id="newPass2" label="Confirm new password" Placeholder="Confirm new password"></md-input>
        <btn id="changepassbtn" class="z-depth-5" color="red" @click.native="changePass()">Confirm</btn>
        <modal-footer>
          <btn color="secondary" @click.native="showModal = false">Close</btn>
        </modal-footer>
      </modal>


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
    MdInput,
    Modal,
    ModalHeader,
    ModalTitle,
    ModalBody,
    ModalFooter
  } from 'mdbvue';

  export default {
    name: 'Account',
    components: {
      MdTextarea,
      MdInput,
      Container,
      Row, Column, Fa, Btn,
      Modal,
      ModalHeader,
      ModalTitle,
      ModalBody,
      ModalFooter
    },
    data() {
      return {
        showModal: false,
        Message: 'Change Password',
        key: 'keytest',
        user: {
          password: '',
          id: 0
        },
        passConfirm: ''
      }
    },

    methods: {
      changePass() {
        if (this.user.password.equals(this.passConfirm)) {
          auth.changePass(this,this.user.password)
        } else {
          this.error = 'The passwords do not match.'
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
