import AXIOS_INSTANCE from "../../utils/config/api.config";
import { BE_URI,MICRO_SERVICE_PATH} from "../../utils/config/app.config";

export const getAuthentication = async ()=>{
    try {
        let response = await AXIOS_INSTANCE.get(`${BE_URI}/authen/authenticated-user-info`);
        let result = response.data.data
        return result;
    } catch (error) {
        return null;
    }
}

export const doLogin = ()=>{
    window.location.href=`${BE_URI}/${MICRO_SERVICE_PATH.AUTH_SERVER}/oauth2/authorization/google`;
}

export const doLogout = ()=>{
    window.location.href=`${BE_URI}/authen/logout/handle`;
}