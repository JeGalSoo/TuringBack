import { createAsyncThunk } from "@reduxjs/toolkit";
import { IArticle } from "./article.model";
import axios from "axios";
import { API } from "@/redux/common/enums/API";
import AxiosConfig, { instance } from "@/redux/common/configs/axios-config";
import { useState } from "react";
import articleSlice from "./article.slice";
import { findAllArticlesAPI } from "./article.api";

export const findAllArticles: any = createAsyncThunk(//thunk 비동기로 보내겠다는 뜻
    'articles/findAllArticles',
    async (page: number)=>{
        console.log('fetchAllArticles page : '+ page)
        const data:any = await  findAllArticlesAPI(1);
        // console.log('----- API 를 사용한 경우 -----')
        // console.log('message : '+ message)
        // console.log(JSON.stringify(result))
        return data
    }
)