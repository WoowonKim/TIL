import axios from "axios";

const axiosService = axios.create({
  baseURL: process.env.PUBLIC_URL,
  headers: {
    "Content-Type": "application/json",
    "auth=token": "",
  },
});

export { axiosService };
