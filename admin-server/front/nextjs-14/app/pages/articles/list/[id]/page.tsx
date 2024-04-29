'use client'

import { useRouter } from "next/navigation"
import { DataGrid } from '@mui/x-data-grid';
import { useState, useEffect } from "react"
import {Box, Button, Input} from '@mui/material';
import { useSelector, useDispatch } from 'react-redux'
import { NextPage } from "next";
import { findAllBoards } from "@/app/component/board/service/board-service";
import { getAllBoards } from "@/app/component/board/service/board-slice";
import Columns from "@/app/component/articles/columns";
import Link from "next/link";
import { PG } from "@/redux/common/enums/PG";
import { findAllArticles } from "@/redux/features/articles/article.service";
import { findArticleById } from "@/app/component/articles/service/article.service";
import { getArticleById } from "@/app/component/articles/service/article-slice";
import ArticleColumns from "@/app/component/articles/module/columns";


const ArticleListPage: NextPage = (props:any) => {
  const dispatch = useDispatch()
  const article:[] = useSelector(getArticleById)

  if(article !== undefined){
      console.log('allUser is not undefined')
      console.log(article)
  }else{
      console.log('allUser is undefined')
  }

  useEffect(()=>{
      dispatch(findArticleById(props.params.id))
  },[])

    
    return (<>
    <div className="flex flex-col h-screen items-center justify-center w-full">
      <div className="flex overflow-x-scroll snap-x snap-mandatory max-w-6xl no-scrollbar">
      </div>
      <h2>게시판 글쓰기</h2>
        <Box sx={{ height: 400, width: '60%' }}>
     {article && <DataGrid
        rows={article}
        columns={ArticleColumns()}
        initialState={{
          pagination: {
            paginationModel: {
              pageSize: 5,
            },
          },
        }}
        pageSizeOptions={[5]}
        checkboxSelection
        disableRowSelectionOnClick
      />}
    </Box>
    </div>
    </>)
}

export default ArticleListPage