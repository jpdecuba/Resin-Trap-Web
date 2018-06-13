import router from '../router/index'
import {AXIOS} from '../components/http-common'

export default {

  user: {
    authenticated: false,
    role: ''
  },

  // Send a request to the login URL and save the returned JWT
  async login(context, username, password) {
    var params = new URLSearchParams();
    params.append('username', username);
    params.append('password', password);

    AXIOS.post(`/inlog`, params)
      .then(response => {
        this.response = response.data;
        if (response.data) {
          // localStorage.setItem('id_token', data.id_token)
          // localStorage.setItem('access_token', data.access_token)
          this.user.authenticated = true
          router.push('/')
        } else if (!response.data) {
          context.error = 'Username/Password incorrect!'
        }
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
  },

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
  },

  // To log out, we just need to remove the token
  logout() {
    this.user.authenticated = false
  },

  checkAuth() {
    var jwt = localStorage.getItem('id_token')
    if (jwt) {
      this.user.authenticated = true
    }
    else {
      this.user.authenticated = false
    }
  },

  // The object to be passed as a header for authenticated requests
  getAuthHeader() {
    return {
      'Authorization': 'Bearer ' + localStorage.getItem('access_token')
    }
  },

async GetServices(context, user) {
  AXIOS.get(`/Services`, user)
    .then(response => {
      this.response = response.data;
      if (response.data != '') {
        context.data = response.data
        router.push('/')
      } else if (response.data == '') {
        context.error = 'No Data!'
      }
    })
  }
}
