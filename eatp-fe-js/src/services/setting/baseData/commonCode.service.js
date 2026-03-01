import AXIOS_INSTANCE from "../../../utils/config/api.config";
import {MICRO_SERVICE_PATH} from "../../../utils/config/app.config";

const {SETTING} = MICRO_SERVICE_PATH;
const API_PREFIX = `${SETTING}/base-data/common-code`;

export const createCommonCode = async params =>{
    try {
        await AXIOS_INSTANCE.post(`${API_PREFIX}/create`,params);
        return true;
    } catch (error) {
        return false;
    }
}

export const searchListCommonCode = async (params) => {
    try {
        const response = await AXIOS_INSTANCE.post(`${API_PREFIX}/search`, params);
        return response.data.data;
    } catch (error) {
        return null;
    }
}

export const getCommonCodeInDetail = async (commonCodeNo) => {
    try {
        const response = await AXIOS_INSTANCE.get(`${API_PREFIX}/detail/${commonCodeNo}`)
        return response.data.data;
    } catch (error) {
        return null;
    }
}