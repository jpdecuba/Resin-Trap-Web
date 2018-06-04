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
          context.error = 'nope wtf'
        }
      })
  },

  signup(context, creds, redirect) {
    context.$http.post(SIGNUP_URL, creds, (data) => {
      localStorage.setItem('id_token', data.id_token)
      localStorage.setItem('access_token', data.access_token)

      this.user.authenticated = true

      if (redirect) {
        router.go(redirect)
      }

    }).error((err) => {
      context.error = err
    })
  },

  // To log out, we just need to remove the token
  logout() {
    localStorage.removeItem('id_token')
    localStorage.removeItem('access_token')
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
  }
}
