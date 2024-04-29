import { createAsyncThunk } from "@reduxjs/toolkit";
import { findAllUsersAPI, findByIdAPI, loginAPI, modifyByIdAPI } from "./user.api";
import { IUser } from "../model/user";


export const findAllUsers: any = createAsyncThunk(
    'users/findAllUsers',
    async (page: number)=> await  findAllUsersAPI(page)
)

export const findUserById: any = createAsyncThunk(
    'users/findUserById',
    async (id:any)=> await findByIdAPI(id)
)

export const modifyUser:any = createAsyncThunk(
    'user/modifyUser', 
    async (user:IUser) => modifyByIdAPI(user)
)

export const loginUser:any = createAsyncThunk(
    'user/loginUser', 
    async (data) => loginAPI(data)
)