<template>
  <div class="home">
    <container>
      <row>
        <column md="2">
          <!--<card>-->
          <!--<card-img :src="require('../assets/chart.jpg')" alt="Card image cap" waves></card-img>-->
          <!--<card-body class="text-center">-->
          <!--<card-title><strong>Resin Trap</strong></card-title>-->
          <!--<hr/>-->
          <!--<card-text>Resin Trap is a user-friendly application that lets you setup your own honeypot to better-->
          <!--secure your network.-->
          <!--</card-text>-->
          <!--</card-body>-->
          <!--</card>-->
        </column>
        <column class="test" md="8">
          <card class="card-image"
                style="background-image: url('/static/chart.jpg'); background-size: 125%; border-radius: 20px; border-color: transparent">
            <div class="text-white text-center d-flex align-items-center rgba-black-strong py-5 px-4" style="border-radius: 20px">
              <div>
                <h5 class="red-text">
                  <fa icon="desktop"/>
                </h5>
                <card-title tag="h3" class="pt-2"><strong>Resin Trap</strong></card-title>
                <p>Resin Trap is a user-friendly application that lets you setup your own honeypot to better secure
                  your network. Resin Trap is a simple solution which can be used almost anyone. The application has many features including:</p>
                <ul class="ulist">
                  <li class="feat">Creating a fake active service</li>
                  <li class="feat">Notifications when someone has connected to the honeypot</li>
                  <li class="feat">A log so you can see everything when a user has connected</li>
                  <li class="feat">And more!</li>
                </ul>
                <!--<btn color="red">-->
                  <!--<fa icon="clone left"/>-->
                  <!--View project-->
                <!--</btn>-->
              </div>
            </div>
          </card>
        </column>
        <column md="2">
        </column>
      </row>
      <!--features and users (home, small business, big business)-->
    </container>
  </div>
</template>

<script>
  import {Row, Column, Container, Card, CardBody, CardText, Fa, CardImg, Btn, CardTitle} from 'mdbvue';

  export default {
    name: 'Home',
    components: {
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

</style>
