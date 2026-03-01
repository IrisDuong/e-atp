import {createSlice} from "@reduxjs/toolkit"

const commonCodeSlide = createSlice({
    name: "commonCodeSlide",
    initialState : {
        listCommonCodes : []
    },
    reducers: {
        setListCommonCodes : (state,action)=>{
            state.listCommonCodes = action.payload;
        }
    }
})

export const {setListCommonCodes} = commonCodeSlide.actions;
export default commonCodeSlide.reducer;