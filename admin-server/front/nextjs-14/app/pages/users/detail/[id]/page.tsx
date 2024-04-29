'use client'

import AxiosConfig from "@/app/component/common/configs/axios-config";
import UserColumns, { UserByIdColumns } from "@/app/component/users/module/user-columns";
import { modifyUser } from "@/app/component/users/service/user.service";
import { findUserById } from "@/app/component/users/service/user.service";
import   { getById, jobHandler, nameHandler,  phoneHandler, userSlice } from "@/app/component/users/service/user.slice";
import { API } from "@/redux/common/enums/API";
import { PG } from "@/redux/common/enums/PG";
import { DataGrid } from "@mui/x-data-grid/DataGrid";
import axios from "axios";
import router from "next/router";
import { useEffect, useState } from "react"
import { useDispatch, useSelector } from "react-redux";

export default function BoardDetailPage(props:any) {
    const dispatch = useDispatch()
    const user = useSelector(getById)
    const modifydata = dispatch(nameHandler(user))

    
    if(user !== undefined){
        console.log('allUser is not undefined')
        console.log(user)
    }else{
        console.log('allUser is undefined')
    }

    const url1=`${API.SERVER}/modify`
    const url=`${API.SERVER}/delete/${props.params.id}`
    const dclick = () => {
        alert("삭제")
        axios.delete(url,AxiosConfig())
            .then(res => { 
                alert(JSON.stringify(res.data))
                router.push(PG.USER+"/member") 
            })     
    }

    const jclick = () => {
        dispatch(modifydata)
        dispatch(modifyUser(user))
        console.log(user)
        axios.post(url1,user,AxiosConfig())
    }
    
    useEffect(() => {
        dispatch(findUserById(props.params.id))
    }, [])


    return(<>
    <h2>게시판 상세</h2>
    {props.params.id}번 게시판 상세<br/>
    <div style={{ height: 400, width: "100%" }}>
      {user && <DataGrid
        rows={[user]}
        columns={UserByIdColumns()}
        pageSizeOptions={[5, 10, 20]}
        checkboxSelection
        
      />}
      <button type="reset" className="cancelbtn">Cancel</button>
      <button type="reset" className="cancelbtn" onClick={jclick}>수정</button>
      <button type="submit" className="signupbtn" onClick={dclick}>삭제</button>
    </div>
    {/* <span>id</span> {props.params.id}<br/>
    <span>아이디 : {user.username}</span><br/>
    <span>이름 : {}</span> <br/>
    <span>전화번호 : {}</span> <br/>
    <span>직업 : {}</span> */}
    </>)
}