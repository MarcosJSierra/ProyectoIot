<template>
  <v-app>
    <v-app-bar app color="blue darken-4" dark>
      <div class="d-flex align-center">
        <v-app-bar-nav-icon dark @click="drawer = !drawer"></v-app-bar-nav-icon>
        <v-btn-toggle> </v-btn-toggle>
        <v-checkbox
          v-model="expandSideBar"
          :on-icon="'mdi-pin'"
          :off-icon="'mdi-pin-off'"
          @change="repaint"
          color="white"
          hide-details
        ></v-checkbox>

        <v-toolbar-title >Lotso Monitoring Center</v-toolbar-title>
      </div>
    </v-app-bar>
    <v-navigation-drawer
        color="indigo lighten-5"
        v-model="drawer"
        app
        :expand-on-hover="!expandSideBar"
      >
        <v-divider></v-divider>
        <v-list-item class="pa-2">
          <v-avatar color="indigo lighten-5">
          <v-img
            alt="Lotso Logo"
            class="shrink mr-2"
            contain
            :src="require('@/assets/tanque.gif')"
            transition="scale-transition"
          />
        </v-avatar>
          <v-list-item-content>
            <v-list-item-title class="font-weight-bold">Contenedores</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-divider></v-divider>
        <v-list dense nav>
          <v-list-item-group active-class="blue lighten-3" v-model="contenedor">
            <v-list-item
              class="pa-2"
              v-for="item in items"
              :key="item.title"
              
            >
              <v-list-item-icon>
                <v-icon>{{ item.icon }}</v-icon>
              </v-list-item-icon>

              <v-list-item-content>
                <v-list-item-title class="font-weight-light text-body-2">{{
                  item.title
                }}</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list-item-group>
        </v-list>
        <v-divider></v-divider>
      </v-navigation-drawer>

    <v-main>
      <SensorDataTable />
    </v-main>
  </v-app>
</template>

<script>
import SensorDataTable from "./components/SensorDataTable";

export default {
  name: "App",

  components: {
    SensorDataTable,
  },

  data: () => ({
    tab: 1,
    drawer: true,
    contenedor: null,
    expandSideBar: true,
    items: [
      { title: "Contenedor 1", icon: "mdi-cup-water", to: "/ventas" },
      { title: "Contenedor 2", icon: "mdi-cup-water", to: "/compras" },
      { title: "Contenedor 3", icon: "mdi-cup-water", to: "/inventario" },
      { title: "Contenedor 4", icon: "mdi-cup-water", to: "/financiero" },
      { title: "Contenedor 5", icon: "mdi-cup-water", to: "/recursos_humanos" }
    ],
  }),
  computed: {
    sideBarIcon() {
      return this.expandSideBar === true ? "mdi-pin" : "mdi-pin-off";
    },
  },
  watch: {
    drawer: false,
  },
  methods: {
    repaint() {
      this.drawer = !this.drawer;
      this.drawer = !this.drawer;
    }
  },
};
</script>
