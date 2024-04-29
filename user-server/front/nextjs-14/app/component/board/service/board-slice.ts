import axios from 'axios';
import { createAsyncThunk } from '@reduxjs/toolkit';
import { createSlice } from "@reduxjs/toolkit";
import { IBoard } from '../model/board';
import { findAllBoards } from './board-service';

interface BoardState{
    json:IBoard,
    array:Array<IBoard>
}

export const initialState:BoardState = {
    json: {} as IBoard,
    array: [] 
}

const boardThunks = [findAllBoards]

const status = {
    pending: 'pending',
    fulfilled: 'fulfilled',
    rejected: 'rejected'
}

const handleFulfilled =  (state: any, {payload}: any) => {
    console.log('------------------Board conclusion ---------------')
    // state.array = payload
    console.log(state.array)

}

const handlePending = (state: any) => {
  
}
const handleRejected = (state: any) => {
  
}

export const boardSlice = createSlice({
    name: "boards",
    initialState,
    reducers: {},
    extraReducers: builder => {
        const {pending, rejected} = status;

        builder
        .addCase(findAllBoards.fulfilled, (state: any, {payload}: any) => {state.array = payload})
  
    }
})
export const getAllBoards = (state: any) => {
    console.log('여기는 슬라이스'+JSON.stringify(state.board.array))
    return state.board.array}

export const {} = boardSlice.actions

export default boardSlice.reducer;