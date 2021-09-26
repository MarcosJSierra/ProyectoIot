<template>
  <v-container>
    <v-row class="text-center">
      <v-col cols="12">
        <v-toolbar flat>
          <v-toolbar-title>Gráfica de Eventos</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
        </v-toolbar>
        <v-col></v-col>
        <v-col cols="12">
          <v-sheet
            class="v-sheet--offset mx-auto"
            color="blue accent-4"
            elevation="12"
            max-width="calc(100% - 50px)"
          >
            <v-sparkline
              auto-draw
              :value="value"
              color="white"
              line-width="1.5"
              padding="10"
            ></v-sparkline>
          </v-sheet>
        </v-col>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-toolbar flat>
          <v-toolbar-title>Datos Registrados</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
        </v-toolbar>
        <v-col></v-col>
        <v-data-table :headers="headers" :items="desserts" class="elevation-1" dense>
          <template v-slot:item.state="{ item }">
            <v-chip :color="getColor(item.state)" dark x-small>
              {{ item.state }}
            </v-chip>
          </template>
        </v-data-table>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-toolbar flat>
          <v-toolbar-title>Datos Estadísticos</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
        </v-toolbar>
        <v-col></v-col>
        <v-data-table
          :headers="headersStats"
          :items="statistics"
          hide-default-footer
          class="elevation-1"
        ></v-data-table>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-toolbar flat>
          <v-toolbar-title>Búsqueda de Datos</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
        </v-toolbar>
        <v-col></v-col>
      </v-col>
      <v-col cols="6">
        <v-menu
          ref="menu1"
          v-model="menu1"
          :close-on-content-click="false"
          :return-value.sync="date"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              v-model="date1"
              label="Fecha de inicio"
              prepend-icon="mdi-calendar"
              readonly
              v-bind="attrs"
              v-on="on"
            ></v-text-field>
          </template>
          <v-date-picker v-model="date1" no-title scrollable>
            <v-spacer></v-spacer>
            <v-btn text color="primary" @click="menu1 = false"> Cancelar </v-btn>
            <v-btn text color="primary" @click="$refs.menu1.save(date)"> OK </v-btn>
          </v-date-picker>
        </v-menu>
      </v-col>
      <v-col cols="6">
        <v-menu
          ref="menu2"
          v-model="menu2"
          :close-on-content-click="false"
          :return-value.sync="date"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              v-model="date2"
              label="Fecha final"
              prepend-icon="mdi-calendar"
              readonly
              v-bind="attrs"
              v-on="on"
            ></v-text-field>
          </template>
          <v-date-picker v-model="date2" no-title scrollable>
            <v-spacer></v-spacer>
            <v-btn text color="primary" @click="menu2 = false"> Cancel </v-btn>
            <v-btn text color="primary" @click="$refs.menu2.save(date)"> OK </v-btn>
          </v-date-picker>
        </v-menu>
      </v-col>
      <v-col cols="12" align="center" justify="space-around">
        <v-btn depressed color="primary"> Consultar Datos </v-btn>
      </v-col>
    </v-row>
    <v-row>
      <v-text> </v-text>
    </v-row>
  </v-container>
</template>
<script>
import axios from "axios";

export default {
  name: "SensorDataTable",
  data() {
    return {
      sensorLectureList: [],
      headers: [
        {
          text: "Fecha de registro",
          align: "center",
          value: "timeLecture",
          //value: "name",
        },
        { text: "Valor",
          value: "lecture",
          //value: "email",
          align: "center",
          sortable: false }
      ],
      headersStats: [
        {
          text: "Parametro",
          align: "start",
          value: "title",
          sortable: false,
        },
        { text: "Valor", value: "value", sortable: false },
      ],
      date1: new Date(Date.now() - new Date().getTimezoneOffset() * 60000)
        .toISOString()
        .substr(0, 10),
      date2: new Date(Date.now() - new Date().getTimezoneOffset() * 60000)
        .toISOString()
        .substr(0, 10),
      menu1: false,
      menu2: false,
      desserts: [
        {
          timeLecture: "25-09-2021 11:55",
          lecture: "250",
          state: "normal",
        },
        {
          timeLecture: "25-09-2021 11:54",
          lecture: 237,
          state: "muy bajo",
        },
        {
          timeLecture: "25-09-2021 11:53",
          lecture: 262,
          state: "bajo",
        },
        {
          timeLecture: "25-09-2021 11:52",
          lecture: 305,
          state: "bajo",
        },
        {
          timeLecture: "25-09-2021 11:51",
          lecture: 356,
          state: "normal",
        },
        {
          timeLecture: "25-09-2021 11:50",
          lecture: 375,
          state: "normal",
        },
        {
          timeLecture: "25-09-2021 11:49",
          lecture: 392,
          state: "normal",
        },
        {
          timeLecture: "25-09-2021 11:48",
          lecture: 408,
          state: "muy bajo",
        },
        {
          timeLecture: "25-09-2021 11:47",
          lecture: 452,
          state: "bajo",
        },
        {
          timeLecture: "25-09-2021 11:46",
          lecture: 518,
          state: "normal",
        },
      ],
      statistics: [
        {
          title: "Valor Promedio",
          value: "410.50",
        },
        {
          title: "Valor Maximo",
          value: "675",
        },
        {
          title: "Valor Minimo",
          value: "200",
        },
        {
          title: "Valores Totales",
          value: "64",
        },
      ],
      //labels: ["12am", "3am", "6am", "9am", "12pm", "3pm", "6pm", "9pm"],
      value: [
        200,
        675,
        410,
        390,
        310,
        460,
        250,
        240,
        200,
        675,
        410,
        390,
        310,
        460,
        250,
        240,
        200,
        675,
        410,
        390,
        310,
        460,
        250,
        240,
        200,
        675,
        410,
        390,
        310,
        460,
        250,
        240,
        200,
        675,
        410,
        390,
        310,
        460,
        250,
        240,
        200,
        675,
        410,
        390,
        310,
        460,
        250,
        240,
        200,
        675,
        410,
        390,
        310,
        460,
        250,
        240,
        200,
        675,
        410,
        390,
        310,
        460,
        250,
        240,
      ],
    };
  },
   created() {
    this.initialize();
  },
  methods: {
    initialize() {
      axios.get("api/sensorlecture/").then((response) => {
        if (response.status == 200) {
          this.sensorLectureList = response.data;
         console.log(response)
        } else {
          console.log(response.status);
        }
      });
    },
    //initialize() {
    //  axios.get("users/").then((response) => {
    //    if (response.status == 200) {
    //      this.sensorLectureList = response.data;
    //      console.log(response)
    //    } else {
    //      console.log(response.status);
    //    }
    //  });
    //},
    getColor(state) {
      if (state == "normal") return "green";
      else if (state == "bajo") return "orange";
      else return "red";
    },
  },
  
};
</script>
<style>
.v-sheet--offset {
  top: -24px;
  position: relative;
}
</style>
