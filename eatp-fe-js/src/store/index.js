import {configureStore} from "@reduxjs/toolkit";
import authReducer from "./auth";
import commonCodeReducer from "./setting/baseData/commonCode"

const appStore = configureStore({
    reducer:{
        authStore: authReducer,
        commonCodeStore: commonCodeReducer
    }
})
export default appStore;