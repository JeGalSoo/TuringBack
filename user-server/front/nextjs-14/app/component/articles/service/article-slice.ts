import axios from 'axios';
import { createAsyncThunk } from '@reduxjs/toolkit';
import { createSlice } from "@reduxjs/toolkit";
import { IArticle } from '../model/article';
import { initialState } from './article-init';
import { deleteArticleById, findAllArticles, findArticleById } from './article.service';

interface IAuth{
    id?: number,
    title?: string,
    description?: string,
    writerId?: string,
    boardId?: string,
    regDate?: string,
    modDate?: string
    message?: string
}

interface userState {
    array? : Array<IAuth>,
    json? : IAuth
}


const articleThunks = [findAllArticles]

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

export const articleSlice = createSlice({
    name: "articles",
    initialState,
    reducers: {},
    extraReducers: builder => {
        const {pending, rejected} = status;

        builder
        .addCase(findAllArticles.fulfilled, handleFulfilled)
        .addCase(findArticleById.fulfilled, (state: any, {payload}: any) => {state.array = payload})
        .addCase(deleteArticleById.fulfilled, (state: any, {payload}: any) => {state.json = payload})
  
    }
})
export const getAllArticles = (state: any) => {
    console.log('------------------ Before useSelector ---------------')
    console.log(JSON.stringify(state.article.array))
    return state.article.array;
}

export const getArticleById = (state: any) => {
    console.log('------------------ Before useSelector ---------------')
    console.log(JSON.stringify(state.article.array))
    return state.article.array;
}
export const getDeleteArticleById = (state: any) => {
    console.log('------------------ Before useSelector ---------------')
    console.log('여기는 슬라이스입니다 : '+state.article.json)
    return state.article.json;
}

export const {} = articleSlice.actions

export default articleSlice.reducer;