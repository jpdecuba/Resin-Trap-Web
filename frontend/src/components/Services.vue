<template>
  <div class="Services">
    <container style="margin-top: 10%;">
      <column>
        <row>
          <h1>Services</h1>
        </row>
        <row>
          <table class="table table-striped">
            <thead class="mdb-color darken-3">
            <tr class="text-white">
              <th>Protocol</th>
              <th>IP Address</th>
              <th>Time</th>
              <th>Port</th>
              <th>Message</th>
            </tr>
            </thead>
            <tbody>
            <tr v-if="data" v-for="item in data">
              <td>{{item.Protocol}}</td>
              <td>{{item.IP}}</td>
              <td>{{item.Time}}</td>
              <td>{{item.Port}}</td>
              <td>
                <btn color="mdb-color darken-3" @click.native="(showModal = true), (Message = item)">show</btn>
              </td>
            </tr>
            </tbody>
          </table>
        </row>
      </column>

      <modal v-if="showModal" @close="showModal = false">
        <modal-header>
          <modal-title>{{Message.Protocol}}</modal-title>
        </modal-header>
        <modal-body>{{Message.Message}}</modal-body>
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
    Btn,
    Table,
    Modal,
    ModalHeader,
    ModalTitle,
    ModalBody,
    ModalFooter,
    Tooltip,
    Popover,
    MdInput,
    MdTextarea
  } from 'mdbvue';
  import {AXIOS} from './http-common'

  export default {
    name: 'Services',
    components: {
      Container,
      Row,
      Column,
      Btn,
      Modal,
      ModalHeader,
      ModalTitle,
      ModalBody,
      ModalFooter,
      Tooltip,
      Popover,
      MdInput,
      MdTextarea
    },
    data() {
      return {
        data,
        showModal: false,
        Message: null,
        response: [],
        items: [
          {Protocol: 'MySQL', IP: '000.000.000.000', Time: 'NVT', Port: '0000', Message: 'show'},
          {Protocol: 'FTP', IP: '000.000.000.000', Time: 'NVT', Port: '0000', Message: 'show'},
          {Protocol: 'IRC', IP: '000.000.000.000', Time: 'NVT', Port: '0000', Message: 'show'},
          {Protocol: 'SMTP', IP: '000.000.000.000', Time: 'NVT', Port: '0000', Message: 'show'}
        ]
      }
    },

    methods: {

    }
  }
</script>

<style scoped>
  .btn {
    border-radius: 25px;
  }
</style>
