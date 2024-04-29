import axios from 'axios';
import { createAsyncThunk } from '@reduxjs/toolkit';
import { createSlice } from "@reduxjs/toolkit";
import { initialState } from './board.init';
import { findAllBoards } from './board.service';


const userThunks = [findAllBoards]

const status = {
    pending: 'pending',
    fulfilled: 'fulfilled',
    rejected: 'rejected'
}

const handleFulfilled =  (state: any, {payload}: any) => {
    console.log('------------------ conclusion ---------------')
    state.array = payload
    console.log(state.array)

}

const handlePending = (state: any) => {
  
}
const handleRejected = (state: any) => {
  
}

export const userSlice = createSlice({
    name: "users",
    initialState,
    reducers: {},
    extraReducers: builder => {
        const {pending, rejected} = status;

        builder
        .addCase(findAllBoards.fulfilled, handleFulfilled)
  
    }
})
export const getAllUsers = (state: any) => {
    console.log('------------------ Before useSelector ---------------')
    console.log(JSON.stringify(state.user.array))
    return state.user.message;
}

export const {} = userSlice.actions

export default userSlice.reducer;