<template>
  <div class="home">
    <container>
      <row>
        <column>
          <line-chart id="lineChart" :width="600" :height="300"></line-chart>
        </column>
      </row>
      <row>
        <column>
          <bar-chart id="barChart" :width="600" :height="300"></bar-chart>
        </column>
      </row>
    </container>
  </div>
</template>

<script>
  import {Row, Column, Container, Card, CardBody, CardText, Fa, CardImg, Btn, CardTitle, LineChart, BarChart} from 'mdbvue';

  export default {
    name: 'Home',
    components: {
      Container,
      Row, Column, CardText, Card, CardBody, Fa, CardImg, Btn, CardTitle,
      LineChart, BarChart
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
