import axios from "axios";
import {BE_URI,MICRO_SERVICE_PATH} from "./app.config"
const AXIOS_INSTANCE = axios.create({
    baseURL:BE_URI,
    withCredentials:true
})

AXIOS_INSTANCE.interceptors.response.use(
    res=> res,
    error=>{
        if(error.response.status === 401){
            window.location.href = `${BE_URI}/${MICRO_SERVICE_PATH.AUTH_SERVER}/oauth2/authorization/google`;
        }
        return Promise.reject(error);
    }
)

export default AXIOS_INSTANCE;