'use client'

import { DataGrid } from '@mui/x-data-grid';
import { useState, useEffect } from "react"
import {Box, Button, Input} from '@mui/material';
import { useSelector, useDispatch } from 'react-redux'
import { NextPage } from "next";
import { getAllArticles } from "@/app/component/articles/service/article-slice";
import { findAllArticles } from "@/app/component/articles/service/article.service";
import ArticleColumns from "@/app/component/articles/module/columns";




const ArticleListPage: NextPage = () => {
    const dispatch = useDispatch()
 
   const allArticles: [] = useSelector(getAllArticles)

    if(allArticles !== undefined){
        console.log('allArticles is not undefined')
        
        console.log('length is '+ allArticles.length)
        for(let i=0; i< allArticles.length; i++){
            console.log(JSON.stringify(allArticles[i]))
        }
    }else{
        console.log('allArticles is undefined')
    }
    

    useEffect(() => {
        dispatch(findAllArticles(1))
    }, [])
    
    return (<>
        <h2>게시글 목록</h2>
        <Box sx={{ height: 400, width: '100%' }}>
     {allArticles && <DataGrid
        rows={allArticles}
        columns={ArticleColumns()}
        pageSizeOptions={[5, 10, 20]}
        checkboxSelection
      />}
    </Box>
    </>)
}

export default ArticleListPage