import { createSlice } from "@reduxjs/toolkit";
import { findAllUsers, findUserById, loginUser  } from './user.service';
import { log } from "console";
import { IUser } from "../model/user";
import { useState } from "react";

const userThunks = [findAllUsers]


const status = {
    pending: 'pending',
    fulfilled: 'fulfilled',
    rejected: 'rejected'
}

interface IAuth{
    message?: string,
    token?: string
}

interface userState {
    array? : Array<IUser>,
    json? : IUser,
    auth?: IAuth
}

export const initialState:userState = {
    json : {} as IUser,
    array : [],
    auth : {} as IAuth

}


const handlePending = (state: any) => {
  
}
const handleRejected = (state: any) => {
  
}

export const userSlice = createSlice({
    name: "users",
    initialState,
    reducers: {
        usernameHandler: (state:any, {payload}) => {state.json.username = payload},
        nameHandler: (state:any, {payload}) => {state = payload},
        phoneHandler: (state:any, {payload}) => {state.json.phone = payload},
        jobHandler: (state:any, {payload}) => {payload.json.job = state.data}
    },
    extraReducers: builder => {
        const {pending, rejected} = status;

        builder
        .addCase(findAllUsers.fulfilled, (state: any, {payload}: any) => {state.array = payload})
        .addCase(findUserById.fulfilled, (state: any, {payload}: any) => {state.data = payload})
        .addCase(loginUser.fulfilled, (state: any, {payload}: any) => {state.auth = payload})
    }
})
export const getAllUsers = (state: any) =>(state.user.array)
export const getById = (state:any) => {
    console.log('123123123')
    console.log(JSON.stringify(state.user.data))
    return state.user.data
}
export const getAuth = (state: any) => state.user.auth

export const {} = userSlice.actions
export const { usernameHandler, nameHandler, phoneHandler, jobHandler } = userSlice.actions
export default userSlice.reducer;