<template>
  <div class="home">
    <container>
      <row class="mt-5"></row>
      >
      <row class="align-items-center justify-content-center">Threats per Day</row>
      <row class="align-items-center justify-content-center">
        <column md="12">
          <line-chart v-if="data" :data="lineChartData" :options="lineChartOptions" id="lineChart" :width="900"
                      :height="300"></line-chart>
        </column>
      </row>
      <row class="align-items-center justify-content-center">Threats by Protocol</row>
      <row class="align-items-center justify-content-center mb-5">
        <column md="12">
          <bar-chart v-if="data" :data="barChartData" :options="barChartOptions" id="barChart" :width="900"
                     :height="300"></bar-chart>
        </column>
      </row>
    </container>
  </div>
</template>

<script>
  import {
    Row,
    Column,
    Container,
    Card,
    CardBody,
    CardText,
    Fa,
    CardImg,
    Btn,
    CardTitle,
    LineChart,
    BarChart
  } from 'mdbvue';
  import moment from 'moment';
  import auth from '../auth'

  export default {
    name: 'Admin',
    components: {
      Container,
      Row, Column, CardText, Card, CardBody, Fa, CardImg, Btn, CardTitle,
      LineChart, BarChart
    },

    data() {
      return {
        name: 'Admin',
        data:'',
        lineChartData: {
          labels: [],
          datasets: [
            {
              label: "Threats",
              fillColor: "rgba(204, 0, 0, 1)",
              strokeColor: "rgba(204, 0, 0, 1)",
              pointColor: "rgba(204, 0, 0, 1)",
              pointStrokeColor: "#C00",
              pointHighlightFill: "#C00",
              pointHighlightStroke: "rgba(204, 0, 0, 1)",
              data: []
            },
          ]
        },
        lineChartOptions: {
          responsive: false,
          maintainAspectRatio: false,
          scales: {
            xAxes: [{
              gridLines: {
                display: true,
                color: "rgba(0, 0, 0, 0.1)",
              }
            }],
            yAxes: [{
              gridLines: {
                display: true,
                color: "rgba(0, 0, 0, 0.1)",
              }
            }],
          }
        },
        barChartData: {
          labels: ["MySQL", "FTP", "IRC", "SMTP"],
          datasets: [{
            label: "Threats",
            data: [],
            backgroundColor: [
              'rgba(204, 0, 0, 1)',
              'rgba(204, 0, 0, 1)',
              'rgba(204, 0, 0, 1)',
              'rgba(204, 0, 0, 1)',
            ],
            borderColor: [
              'rgba(0, 0, 0, 0.8)',
              'rgba(0, 0, 0, 0.8)',
              'rgba(0, 0, 0, 0.8)',
              'rgba(0, 0, 0, 0.8)',
            ],
            borderWidth: 1,
          }]
        },
        barChartOptions: {
          responsive: false,
          maintainAspectRatio: false,
          scales: {
            xAxes: [{
              barPercentage: 1,
              gridLines: {
                display: true,
                color: "rgba(0, 0, 0, 0.1)",
              }
            }],
            yAxes: [{
              gridLines: {
                display: true,
                color: "rgba(0, 0, 0, 0.1)",
              }
            }],
          }
        }
      }
    },
    methods: {
      days() {
        for (var i = 30; i >= 0; i--) {
          var currentDate = new Date();
          var date = moment(String(currentDate)).subtract(i, 'days').format('DD MMMM');
          this.lineChartData.labels.push(date)
          var amount = this.logs(moment(String(currentDate)).subtract(i, 'days').format('YYYY-MM-DD'));
          this.lineChartData.datasets[0].data.push(amount)
        }
      },
      logs(date) {
        var amount = 0;
        for (var i = 0; i < this.data.length; i++) {
          if (moment(date).isSame(this.data[i].date)) {
            amount++
          }
        }
        return amount;
      },
      getData() {
        auth.GetServices(this)
      },
      bar() {
        var MySQL = 0;
        var FTP = 0;
        var IRC = 0;
        var SMTP = 0;
        for (var i = 0; i < this.data.length; i++) {
          if (this.data[i].protocol.toLowerCase().trim() === "mysql") {
            MySQL++
          } else if (this.data[i].protocol.toLowerCase().trim() === "ftp") {
            FTP++
          } else if (this.data[i].protocol.toLowerCase().trim() === "irc") {
            IRC++
          } else if (this.data[i].protocol.toLowerCase().trim() === "smtp") {
            SMTP++
          }
        }
        this.barChartData.datasets[0].data = [MySQL, FTP, IRC, SMTP]
      }
    },
    created() {
      this.getData();
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
    list-style-type: none;
    padding-left: 0pt;
  }

</style>
