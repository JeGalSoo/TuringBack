'use client'
import AxiosConfig from "@/redux/common/configs/axios-config"
import { API } from "@/redux/common/enums/API"
import axios from "axios"
import { NextPage } from "next"
import { Router, useRouter } from "next/router"
import { useState } from "react" 


const DeletePage:NextPage=()=>{
const [username,setusername]=useState('')
const url=`${API.SERVER}/delete`
const data={'usernae' : username}


const handleusername = (e:any)=>{
    setusername(e.target.value)
}
const jclick = () => {
    alert("회원가입")
    axios.post(url, data, AxiosConfig())
        .then(res => { 
            alert(JSON.stringify(res.data))
        })     
}
    return (<>
     <div className="container">

    <h2>탈퇴신청</h2>
    아이디를 입력하세요
    <input type="text" onChange={handleusername} />
    <button type="submit" onClick={jclick}>삭제</button>
    </div>
    </>)
}
export default DeletePage