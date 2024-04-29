import { createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";
import { API } from "@/redux/common/enums/API";
import AxiosConfig, { instance } from "@/redux/common/configs/axios-config";
import { useState } from "react";
import { findAllUsersAPI } from "./user.api";

export const findAllUsers: any = createAsyncThunk(//thunk 기동기로 보내겠다는 뜻
    'users/findAllUsers',
    async (page: number)=>{
        console.log('fetchAllUsers page : '+ page)
        const data:any = await  findAllUsersAPI(1);
        const {message,result}:any = data
        console.log('----- API 를 사용한 경우 -----')
        console.log('message : '+ message)
        console.log(JSON.stringify(result))
        return data
    }
)