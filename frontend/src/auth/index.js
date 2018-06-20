import router from '../router/index'
import {AXIOS} from '../components/http-common'

export default {
  user: {
    role: '',
    username: ''
  },
  use: {
    authenticated: false
  },

  // Send a request to the login URL and save the returned JWT
  async login(context, username, password) {
    var params = new URLSearchParams();
    params.append('username', username);
    params.append('password', password);

    AXIOS.post(`/inlog`, params)
      .then(response => {
        this.response = response.data;
        if (response.data != '') {
          this.use.authenticated = true;
          this.user = response.data
          router.push('/')
          alert('Welcome ' + this.user.name)
        } else {
          context.error = 'Username/Password incorrect!'
        }
      }).catch(e => {
      context.error = e.toString()
    })
  },

  async download() {
    AXIOS({
      url: '/download/resin',
      method: 'GET',
      responseType: 'blob', // important
    }).then((response) => {
      const url = window.URL.createObjectURL(new Blob([response.data]));
      const link = document.createElement('a');
      link.href = url;
      link.setAttribute('download', 'resintrap.zip'); //or any other extension
      document.body.appendChild(link);
      link.click();
    });
  }
  ,

  signup(context, user) {
    const User = {
      name: user.Username,
      password: user.Password,
      msgEmail: [user.Email],
      role: user.role,
      code: user.Code
    }

    AXIOS.post(`/register`, User)
      .then(response => {
        this.response = response.data;
        if (response.data) {
          router.push('/Login')
        } else if (!response.data) {
          context.error = 'Error while signing up'
        }
      })
  }
  ,

  // To log out, we just need to remove the token
  logout() {
    this.use.authenticated = false
    this.user = ''
  }
  ,

  async GetServices(context) {
    AXIOS.post(`/Logs`, this.user)
      .then(response => {
        this.response = response.data;
        if (response.data != '') {
          context.data = response.data
          if (context.name == 'Admin') {
            context.days()
            context.bar()
          }
        } else if (response.data == '') {
          context.error = 'No Data!'
        }
      }).catch(e => {
      context.error = e.toString()
    })
  },

  changePass(context, password) {
    this.user.password = password

    AXIOS.post(`/Account/Pass`, this.user)
      .then(response => {
        this.response = response.data;
        if (response.data) {
          alert('Password has been changed')
        } else {
          context.error = 'Password was not changed'
        }
      }).catch(e => {
      context.error = e.toString()
    })
  },
  addEmail(context, email) {
    var params = new URLSearchParams();
    params.append('id', this.user.id);
    params.append('email', email);

    AXIOS.post(`/Account/Email`, params)
      .then(response => {
        this.response = response.data;
        if (response.data) {
          this.user.msgEmail.push(email)
          alert('Email has been added')
        } else {
          context.error = 'Password was not changed'
        }
      }).catch(e => {
      context.error = e.toString()
    })
  },
  deleteEmail(context, email) {
    var params = new URLSearchParams();
    params.append('id', this.user.id);
    params.append('email', email);

    AXIOS.post(`/Account/EmailDel`, params)
      .then(response => {
        this.response = response.data;
        if (response.data) {
          this.user.msgEmail.splice(this.user.msgEmail.indexOf(email) ,1)
          context.selector()
          alert('Email has been deleted')
        } else {
          context.error = 'Email not deleted'
        }
      }).catch(e => {
      context.error = e.toString()
    })
  },
  goToLogin() {
    router.push('/Login')
  }
}
