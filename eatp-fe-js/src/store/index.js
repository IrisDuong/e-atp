import {configureStore} from "@reduxjs/toolkit";
import authReducer from "./auth";

const appStore = configureStore({
    reducer:{
        authStore: authReducer
    }
})
export default appStore;