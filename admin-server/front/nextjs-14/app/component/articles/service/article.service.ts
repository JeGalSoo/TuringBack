import { createAsyncThunk } from "@reduxjs/toolkit";
import { findAllArticlesAPI, findArticleByIdAPI } from "./article-api";


export const findAllArticles: any = createAsyncThunk(
    'articles/findAllArticles',
    async (page: number)=>{
        console.log('findAllArticles page : '+ page)
        const data:any = await  findAllArticlesAPI(1);

        const {message, result}:any = data
        // console.log('----- API 를 사용한 경우 -----')
        // console.log('message : '+ message)
        // console.log(JSON.stringify(result))
        return data
    }
)

export const findArticleById: any = createAsyncThunk(
    'articles/findById',
    async (id: number)=>{
        console.log('findAllArticles page : '+ id)
        const data:any = await  findArticleByIdAPI(id);

        const {message, result}:any = data
        console.log('----- API 를 사용한 경우 -----')
        console.log('message : '+ message)
        console.log(JSON.stringify(result))
        return data
    }
)