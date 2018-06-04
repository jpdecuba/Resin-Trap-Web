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
