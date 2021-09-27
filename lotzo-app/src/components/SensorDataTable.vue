<template>
  <v-container>
    <v-row class="text-center">
      <v-col cols="12">
        <v-toolbar flat>
          <v-toolbar-title>Gráfica de Eventos</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
        </v-toolbar>
      </v-col>
      <v-col cols="12">
        <v-sheet
          class="v-sheet--offset mx-auto"
          color="blue accent-4"
          elevation="12"
          max-width="calc(100% - 50px)"
        >
          <v-sparkline
            auto-draw
            :value="sensorLectureGraficList"
            color="white"
            line-width="1.5"
            padding="10"
          ></v-sparkline>
        </v-sheet>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-toolbar flat>
          <v-toolbar-title>Datos Registrados</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
        </v-toolbar>
        <v-col></v-col>
        <v-data-table
          :headers="headers"
          :items="sensorLectureList"
          class="elevation-1"
          :footer-props="{
            'items-per-page-text': 'Datos por página',
            'items-per-page-all-text': 'Todos',
            'page-text': '{0}-{1} de {2}',
          }"
        >
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
        <v-card>
          <v-simple-table>
            <template v-slot:default>
              <thead>
                <tr>
                  <th class="text-center">Parámetro</th>
                  <th class="text-center">Valor</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="text-center">Valor Promedio</td>
                  <td class="text-center">{{ promedio }}</td>
                </tr>
                <tr>
                  <td class="text-center">Valor Máximo</td>
                  <td class="text-center">{{ maximo }}</td>
                </tr>
                <tr>
                  <td class="text-center">Valor Mínimo</td>
                  <td class="text-center">{{ minimo }}</td>
                </tr>
                <tr>
                  <td class="text-center">Datos Totales</td>
                  <td class="text-center">{{ totales }}</td>
                </tr>
              </tbody>
            </template>
          </v-simple-table>
        </v-card>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-col></v-col>
      </v-col>
    </v-row>
    <v-row justify="center">
      <v-dialog v-model="dialog" persistent max-width="600px">
        <template v-slot:activator="{ on, attrs }">
          <v-btn color="primary" dark v-bind="attrs" v-on="on"> Búsqueda de Datos </v-btn>
        </template>
        <v-card>
          <v-card-title>
            <span class="text-h5">Búsqueda de Datos</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col cols="6">
                  <v-menu
                    ref="menu1"
                    v-model="menu1"
                    :close-on-content-click="false"
                    :return-value.sync="date1"
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
                      <v-btn text color="primary" @click="menu1 = false">
                        Cancelar
                      </v-btn>
                      <v-btn text color="primary" @click="$refs.menu1.save(date1)">
                        OK
                      </v-btn>
                    </v-date-picker>
                  </v-menu>
                </v-col>
                <v-col cols="6">
                  <v-menu
                    ref="menu2"
                    v-model="menu2"
                    :close-on-content-click="false"
                    :return-value.sync="date2"
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
                      <v-btn text color="primary" @click="$refs.menu2.save(date2)">
                        OK
                      </v-btn>
                    </v-date-picker>
                  </v-menu>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="reset()"> Close </v-btn>
            <v-btn color="blue darken-1" text @click="searchData(date1, date2)"> Save </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-col></v-col>
      </v-col>
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
      sensorLectureData: [],
      sensorLectureGraficList: [],
      promedio: "1",
      maximo: "2",
      minimo: "3",
      totales: "4",
      dialog: false,
      headers: [
        {
          text: "Fecha de registro",
          align: "center",
          value: "lectureDate",
          //value: "name",
        },
        {
          text: "Valor",
          value: "lecture",
          //value: "email",
          align: "center",
          sortable: false,
        },
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
      date1: "",
      date2: "",
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
          value: 410.5,
        },
        {
          title: "Valor Maximo",
          value: 675,
        },
        {
          title: "Valor Minimo",
          value: 200,
        },
        {
          title: "Valores Totales",
          value: 64,
        },
      ],
      //labels: ["12am", "3am", "6am", "9am", "12pm", "3pm", "6pm", "9pm"],
      value: [200, 675, 410, 390, 310, 460],
    };
  },
  created() {
    this.initialize();
  },
  methods: {
    initialize() {
      axios.get("/api/sensorlecture/statistics/").then((response) => {
        if (response.status == 200) {
          this.sensorLectureData = response.data;
          this.promedio = this.sensorLectureData.promedio;
          this.maximo = this.sensorLectureData.maximo;
          this.minimo = this.sensorLectureData.minimo;
          this.totales = this.sensorLectureData.total;
          this.sensorLectureList = this.sensorLectureData.sensorLectures;
          this.sensorLectureGraficList = this.setGraficValues(this.sensorLectureList);
        } else {
          console.log(response.status);
        }
      });
    },
    getColor(state) {
      if (state == "normal") return "green";
      else if (state == "bajo") return "orange";
      else return "red";
    },
    setGraficValues(list) {
      var valueArray = [];
      list.forEach(function (element) {
        valueArray.push(element.lecture);
      });
      return valueArray;
    },
    reset() {
      this.dialog = false;
      this.date1 = "";
      this.date2 = "";
    },
    searchData(date1, date2) {
      const startDate = new Date(date1).getTime();
      const endDate = new Date(date2).getTime();
      console.log("start" + startDate);
      console.log("end" + endDate);

      this.reset();
      axios.get("/api/sensorlecture/statistics?startDate=" + startDate + "&endDate=" + endDate).then((response) => {
        if (response.status == 200) {
          this.sensorLectureData = response.data;
          this.promedio = this.sensorLectureData.promedio;
          this.maximo = this.sensorLectureData.maximo;
          this.minimo = this.sensorLectureData.minimo;
          this.totales = this.sensorLectureData.total;
          this.sensorLectureList = this.sensorLectureData.sensorLectures;
          this.sensorLectureGraficList = this.setGraficValues(this.sensorLectureList);
        } else {
          console.log(response.status);
        }
      });
    }
  },
};
</script>
<style>
.v-sheet--offset {
  top: -24px;
  position: relative;
}
</style>
