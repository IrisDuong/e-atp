import axios from "axios";
import {BE_URI} from "./app.config"
const AXIOS_INSTANCE = axios.create({
    baseURL:BE_URI,
    withCredentials:true
})

AXIOS_INSTANCE.interceptors.response.use(
    response => response,
    error => {
        if(error.response.status === 401){
            window.location.href = "/authen/login";
        }
        return Promise.reject(error);
    }
)
export default AXIOS_INSTANCE;