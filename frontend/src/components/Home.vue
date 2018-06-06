<template>
  <div class="home">
    <div class="head">
      <img class="headimg " :src="require('../assets/chart2.jpg')" alt="Responsive image">
      <div class="headbody rgba-black-strong py-5 px-4">
        <div class="hbody">
          <h1>Resin Trap</h1>
          <p>Resin Trap is a user-friendly honeypot which allows you to secure your network from hackers. Day by day
            is the cyber criminality becoming more frequent. We have build this application in hope that we can better
            protect our clients data.</p>
          <btn class="download" color="danger">Download
            <fa icon="download"/>
          </btn>
        </div>
      </div>
    </div>

    <container>
      <row style="margin: 50px">
        <p>Resin Trap was build so that anyone can use it. We have build a user-friendly interface with clear
          instructions on how to use it. The application has 4 modes to choose from depending on your network. These
          modes have different services that are turned on to be able to make it look like an important server.</p>
      </row>
      <row>
        <column md="3" sm="12" class="p-3">
          <card class="test">
            <card-body>
              <h5 class="red-text">
                <fa icon="home" size="2x"/>
              </h5>
              <card-title>Home</card-title>
              <card-text>A mode designed for personal use at home.
              </card-text>
            </card-body>
          </card>
        </column>
        <column md="3" sm="12" class="p-3">
          <card class="test">
            <card-body>
              <h5 class="red-text">
                <fa icon="building-o" size="2x"/>
              </h5>
              <card-title>Small Business</card-title>
              <card-text>A mode designed for small businesses.
              </card-text>
            </card-body>
          </card>
        </column>
        <column md="3" sm="12" class="p-3">
          <card class="test">
            <card-body>
              <h5 class="red-text">
                <fa icon="building" size="2x"/>
              </h5>
              <card-title>Big Business</card-title>
              <card-text>A mode designed for big businesses.
              </card-text>
            </card-body>
          </card>
        </column>
        <column md="3" sm="12" class="p-3">
          <card class="test">
            <card-body>
              <h5 class="red-text">
                <fa icon="hourglass-3" size="2x"/>
              </h5>
              <card-title>Express</card-title>
              <card-text>Express mode allows the application to run a scan on the network it's connected to. Depending
                on your network the applcation will automatically choose one of the other 3 modes.
              </card-text>
            </card-body>
          </card>
        </column>
      </row>
      <row style="margin: 50px;">
        <div class="text-center" style="width: 100%">
          <h3>Features</h3>
          <p>Resin Trap has a variety of features that will help you easily protect your network.</p>
        </div>
      </row>

      <row>
        <column md="3" sm="12" class="p-3">
          <card class="test">
            <card-body>
              <h5 class="red-text">
                <fa icon="server" size="2x"/>
              </h5>
              <card-title>Fake Services</card-title>
              <card-text>Trick intruders into exposing themselves by laying traps in the form of fake data.
              </card-text>
            </card-body>
          </card>
        </column>
        <column md="3" sm="12" class="p-3">
          <card class="test">
            <card-body>
              <h5 class="red-text">
                <fa icon="bell" size="2x"/>
              </h5>
              <card-title>Notifications</card-title>
              <card-text>Be notified when an intruder is found on your network.
              </card-text>
            </card-body>
          </card>
        </column>
        <column md="3" sm="12" class="p-3">
          <card class="test">
            <card-body>
              <h5 class="red-text">
                <fa icon="database" size="2x"/>
              </h5>
              <card-title>Logs</card-title>
              <card-text>Keep extensive records of what happens to your network.
              </card-text>
            </card-body>
          </card>
        </column>
        <column md="3" sm="12" class="p-3">
          <card class="test">
            <card-body>
              <h5 class="red-text">
                <fa icon="question" size="2x"/>
              </h5>
              <card-title>Something else</card-title>
              <card-text>Some quick example text to build on the card title and make up the bulk of the card's
                content.
              </card-text>
            </card-body>
          </card>
        </column>
      </row>
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
  .test {
    height: 100%;
  }

  .home {
    margin-bottom: 50px;
  }

  .headimg {
    width: 100%;
    height: auto;
    background-repeat: no-repeat;
  }

  .head {
    position: relative;
  }

  .headbody {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
  }

  .hbody {
    position: absolute;
    top: 45%;
    left: 25%;
    width: 50%;
    color: white;
  }

  @media only screen and (max-width: 480px) {
    .hbody {
      left: 0;
      top: 75px;
      height: 100%;
      width: 100%;
    }

    .headimg {
      content: url("../assets/chart.jpg");
      height: 100%;
      margin-top: 55px;
    }

    .download {
      display: none;
    }
  }

</style>
