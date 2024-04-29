import { createAsyncThunk } from "@reduxjs/toolkit";
import { deleteByIdAPI, existIdAPI, findAllUsersAPI, findByIdAPI, loginAPI, logoutAPI, modifyByIdAPI } from "./user.api";
import { IUser } from "../model/user";
import { deleteAPI } from "../../articles/service/article-api";


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

export const existId:any = createAsyncThunk(
    'user/existId', 
    async (data) => existIdAPI(data)
)

export const logout:any = createAsyncThunk(
    'user/logout',
    async () => await logoutAPI()
)

export const deleteById:any = createAsyncThunk(
    'user/logout',
    async (id) => {return await deleteByIdAPI(id)}
)
