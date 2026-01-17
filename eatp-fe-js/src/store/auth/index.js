import {createSlice} from "@reduxjs/toolkit";
const authSlice = createSlice({
    name:"authSlice",
    initialState:{
        authenticatedUser:null
    },
    reducers:{
        setAuthenticatedUser : (state,action)=>{
            state.authenticatedUser = action.payload;
        }
    }
})

export const {setAuthenticatedUser} = authSlice.actions;
export default authSlice.reducer;