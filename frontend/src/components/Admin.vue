<template>
  <div class="home">
    <container>
      <row class="mt-5"></row>>
      <row class="align-items-center justify-content-center">Threats per Week</row>
      <row class="align-items-center justify-content-center">
        <column>
          <line-chart :data="lineChartData" :options="lineChartOptions" id="lineChart" :width="900" :height="300"></line-chart>
        </column>
      </row>
      <row class="align-items-center justify-content-center">Threats by Protocol</row>
      <row class="align-items-center justify-content-center mb-5">
        <column>
          <bar-chart :data="barChartData" :options="barChartOptions" id="barChart" :width="900" :height="300"></bar-chart>
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
    },

    data() {
      return {
        lineChartData: {
          labels: ["Weeks", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52"],
          datasets: [
            {
              label: "Threats",
              fillColor: "rgba(204, 0, 0, 1)",
              strokeColor: "rgba(204, 0, 0, 1)",
              pointColor: "rgba(204, 0, 0, 1)",
              pointStrokeColor: "#C00",
              pointHighlightFill: "#C00",
              pointHighlightStroke: "rgba(204, 0, 0, 1)",
              data: [0, 59, 80, 81, 56, 55, 40, 50, 44, 49, 33, 22, 10, 8, 20, 15, 59, 60, 23, 56, 55, 40, 50, 44, 49, 33, 22, 10, 30, 20, 25, 59, 80, 81, 56, 55, 40, 50, 44, 49, 38, 22, 10, 8, 20, 15, 59, 80, 81, 56, 55, 40, 50, 44, 49]
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
            data: [490, 745, 483, 621],
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
