<template>
  <div class="account">
    <container>
      <row>
        <column md="3"></column>
        <column md="6" class="text-left">
          <p>Key: </p>
          <p>{{code}}</p>
        </column>
        <column md="3"></column>
      </row>
      <row>
        <column md="3"></column>
        <column md="6">
          <md-textarea v-model="emails" id="emailtextarea" label="Emails" Placeholder="Emails"></md-textarea>
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
          <md-input id="emailinput" v-model="email" label="New Email" Placeholder="New Email"></md-input>
        </column>
        <column md="2" className="align-self-center">
          <btn id="addbtn" class="z-depth-5" color="red" @click.native="addEmail()">ADD</btn>
        </column>
        <column md="3"></column>
      </row>
      <row>
        <column md="3"></column>
        <column md="6" class="text-left">
          <btn id="passPopupBtn" class="z-depth-5" color="red"
               @click.native="(showModal = true), (Message = 'Change password')">Change Password
          </btn>
          <p class="sub">You will be prompted to enter your current and new password</p>
        </column>
        <column md="3"></column>
      </row>

      <modal v-if="showModal" @close="showModal = false">
        <modal-header>
          <modal-title>{{Message}}</modal-title>
        </modal-header>
        <modal-body>
          <div class="alert alert-danger" v-if="error">
            <p>{{ error }}</p>
          </div>
          <md-input v-model="oldPass" type="password" label="Old Password" icon="Key"
                    Placeholder="New password"></md-input>
          <md-input v-model="user.password" id="newPass1" type="password" label="New password" icon="Key"
                    Placeholder="New password"></md-input>
          <md-input v-model="passConfirm" id="newPass2" type="password" label="Confirm new password" icon="Key"
                    Placeholder="Confirm new password"></md-input>
        </modal-body>
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
  import auth from '../auth'

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
        passConfirm: '',
        oldPass: '',
        error: '',
        error2: '',
        code: auth.user.code,
        emails: auth.user.msgEmail,
        email: ''
      }
    },

    methods: {
      changePass() {
        if (this.user.password != '' && this.oldPass != '' && this.passConfirm != '') {
          if (this.user.password === this.passConfirm) {
            this.error = ''
            auth.changePass(this, this.user.password)
          } else {
            this.error = 'The passwords do not match.'
          }
        } else {
          this.error = 'Please fill all fields'
        }
      },
      addEmail() {
        if (this.email != '') {
          auth.addEmail(this, this.email)
        } else {
          this.error2 = 'Please fill an email address in'
        }
      },
      checkAuth() {
        if (!auth.use.authenticated) {
          auth.goToLogin()
        }
      }
    },
    beforeMount() {
      this.checkAuth()
    },
  }

</script>

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
