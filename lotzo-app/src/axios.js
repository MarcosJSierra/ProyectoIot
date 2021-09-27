import axios from "axios";

export default function axiosSetUp() {
  // point to your API endpoint
  axios.defaults.baseURL = "http://ec2-18-116-74-39.us-east-2.compute.amazonaws.com:8080/";
  //axios.defaults.baseURL = "https://jsonplaceholder.typicode.com/";
  // Add a request interceptor
  axios.interceptors.request.use(
    function(config) {
      return config;
    },
    function(error) {
      return Promise.reject(error);
    }
  );

  // Add a response interceptor
  axios.interceptors.response.use(
    function (response) {
      // Any status code that lie within the range of 2xx cause this function to trigger
      // Do something with response data
      return response;
    },
    async function (error) {
      // Any status codes that falls outside the range of 2xx cause this function to trigger
      // Do something with response error
      return Promise.reject(error);
    }
  );

}