'use client'

import nookies, { parseCookies, destroyCookie, setCookie } from 'nookies';
import { findArticleById, saveArticle } from "@/app/component/articles/service/article.service";
import { IBoard } from "@/app/component/board/model/board";
import { findAllBoards } from "@/app/component/board/service/board-service";
import { getAllBoards } from "@/app/component/board/service/board-slice";
import { Typography12 } from "@/app/component/common/style/ceil"
import { PG } from "@/redux/common/enums/PG";
import { AttachFile, FmdGood, ThumbUpAlt } from "@mui/icons-material"
import { NextPage } from "next";
import { parseCookie } from "next/dist/compiled/@edge-runtime/cookies";
import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import {useForm} from 'react-hook-form'
import { jwtDecode } from "jwt-decode";

const RegisterPage:NextPage = ()=>{
  const {register, handleSubmit, formState:{errors}} = useForm();
  const dispatch = useDispatch()
  const allBoards = useSelector(getAllBoards)
  const router = useRouter();


  if(allBoards !== undefined){
    console.log('allUser is not undefined')
    console.log(allBoards)
}else{
    console.log('allUser is undefined')
}


useEffect(()=>{
  console.log('123123')
  dispatch(findAllBoards(1))
},[])

    const onSubmit = (data:any)=>{
      alert(JSON.stringify(data))
      dispatch(saveArticle(data))
      .then((res:any)=>{
        alert('게시글 작성 완료')
        router.push(`${PG.ARTICLE}/list/${data.boardId}`)
      })
    }

    return (<>
    <form onSubmit={handleSubmit(onSubmit)}>
      <form  className="max-w-sm mx-auto">
          <label htmlFor="countries" className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Select your country</label>
          <select {...register('boardId', { required: true })} id="countries" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
              {/* {options.map((item,index)=>(
                <option key={item.boardId} title={item.title}>{item.content}</option>
              ))} */}
              {allBoards.map((a:any)=>(<option key={a.boardId} title={a.title} value={a.id} >{a.title}</option>))}
          </select>
      </form>
      <div className="editor mx-auto w-10/12 flex flex-col text-gray-800 border border-gray-300 p-4 shadow-lg max-w-2xl">
          {Typography12('Article 작성', "1.5rem")}
          <input {...register('writerId', { required: true, maxLength:4 })} type="hide" value={jwtDecode<any>(parseCookies().accessToken).id} readOnly/>
          <input {...register('title', { required: true, maxLength:45 })} className="title bg-gray-100 border border-gray-300 p-2 mb-4 outline-none" placeholder="Title" type="text" name="title"  />
      <input />
          <textarea {...register('content', { required: true, maxLength:80 })}  className="content bg-gray-100 sec p-3 h-60 border border-gray-300 outline-none" placeholder="Describe everything about this post here" name="content"></textarea>
          {/* <!-- icons --> */}
          <div className="icons flex text-gray-500 m-2">
              <svg className="mr-2 cursor-pointer hover:text-gray-700 border rounded-full p-1 h-7" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <ThumbUpAlt component={ThumbUpAlt}></ThumbUpAlt>
              </svg>
              <svg className="mr-2 cursor-pointer hover:text-gray-700 border rounded-full p-1 h-7" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <FmdGood component={FmdGood}></FmdGood>
              </svg>
              <svg className="mr-2 cursor-pointer hover:text-gray-700 border rounded-full p-1 h-7" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <AttachFile component={AttachFile}></AttachFile>
              </svg>
              <div className="count ml-auto text-gray-400 text-xs font-semibold">0/300</div>
          </div>
          {/* <!-- buttons --> */}
          <div className="buttons flex">
              <div className="btn  overflow-hidden relative w-30 bg-white text-blue-500 p-3 px-4 rounded-xl font-bold uppercase -- before:block before:absolute before:h-full before:w-1/2 before:rounded-full
      before:bg-pink-400 before:top-0 before:left-1/4 before:transition-transform before:opacity-0 before:hover:opacity-100 hover:text-200 hover:before:animate-ping transition-all duration-00"
                  >Cancel</div>
              {/* <div className="btn  overflow-hidden relative w-30 bg-blue-500 text-white p-3 px-8 rounded-xl font-bold uppercase -- before:block before:absolute before:h-full before:w-1/2 before:rounded-full
      before:bg-pink-400 before:top-0 before:left-1/4 before:transition-transform before:opacity-0 before:hover:opacity-100 hover:text-200 hover:before:animate-ping transition-all duration-00"
                  > Post </div> */}
                  <input type="submit" value="SUBMIT" />
          </div>
      </div>
      </form>
  </>)
}
export default RegisterPage