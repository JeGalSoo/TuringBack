import { createAsyncThunk } from "@reduxjs/toolkit";
import { deleteAPI, findAllArticlesAPI, findArticleByIdAPI, saveAPI } from "./article-api";


export const findAllArticles: any = createAsyncThunk(
    'articles/findAllArticles',
    async (page:any)=>await  findAllArticlesAPI(page)
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

export const saveArticle:any = createAsyncThunk(
    'articles/saveArticle', 
    async (article:any) => {
        const data:any = await saveAPI(article)
        return data
    }
)

export const deleteArticleById:any = createAsyncThunk(
    'articles/saveArticle', 
    async (id:any) => {
        const data:any = await deleteAPI(id)
        return data
    }
)