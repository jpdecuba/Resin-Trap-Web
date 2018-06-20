<template>
  <div class="account">
    <container>
      <row style="margin-bottom: 20px">
        <column md="3"></column>
        <column md="6" class="text-left">
          <p>Key: </p>
          <p>{{code}}</p>
        </column>
        <column md="3"></column>
      </row>
      <row>
        <column md="3"></column>
        <column md="6" class="text-left">
          <dropdown v-if="emails !== ''" btn-group>
            <dropdown-toggle @click.native="toggleDropdown(0)" color="red">{{selected}}</dropdown-toggle>
            <dropdown-menu v-show="active[0]" class="collapse-item">
              <dropdown-item v-for="mail in emails" @click.native="select(mail)">{{mail}}</dropdown-item>
            </dropdown-menu>
          </dropdown>
        </column>
        <column md="3"></column>
      </row>
      <row style="margin-bottom: 20px">
        <column md="3"></column>
        <column md="6" class="text-left">
          <btn id="deletebtn" class="z-depth-5" color="red" @click.native="deleteEmail()">Delete</btn>
          <p class="sub">Choose an email you want to delete from the list</p>
        </column>
        <column md="3"></column>
      </row>
      <row style="margin-bottom: 20px">
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
    ModalFooter,
    Dropdown,
    DropdownToggle,
    DropdownItem,
    DropdownMenu
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
      ModalFooter,
      DropdownItem,
      DropdownMenu,
      DropdownToggle,
      Dropdown
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
        email: '',
        active: {
          0: false
        },
        selected: ''
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
      deleteEmail() {
        auth.deleteEmail(this, this.selected)
      }
      ,
      checkAuth() {
        if (!auth.use.authenticated) {
          auth.goToLogin()
        }
      },
      toggleDropdown(index) {
        for (let i = 0; i < Object.keys(this.active).length; i++) {
          if (index !== i) {
            this.active[i] = false;
          }
        }
        this.active[index] = !this.active[index];
      },
      select(email) {
        this.selected = email;
      },
      selector() {
        this.selected = this.emails[0]
      }
    },
    beforeMount() {
      this.checkAuth()
    },
    mounted() {
      this.selector()
    },
  }

</script>

<style scoped>
  .account {
    margin-top: 14%;
  }

  .sub {
    font-size: 12px;
    color: #7f7f7f;
  }

  .btn {
    border-radius: 25px;
  }

  .dropdown-item:hover {
    background-color: #CC0000 !important;
  }

  .dropdown .dropdown-menu .dropdown-item:active, .dropdown .dropdown-menu .dropdown-item:hover {
    color: white !important;
  }

  @media only screen and (max-width: 480px) {
    .account {
      margin-top: 20%;
    }
  }
</style>
