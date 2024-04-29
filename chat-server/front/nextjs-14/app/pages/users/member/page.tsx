

'use client'

import UserColumns from "@/app/component/users/module/user-columns";
import { findAllUsers } from "@/app/component/users/service/user.service";
import { getAllUsers } from "@/app/component/users/service/user.slice";
import { DataGrid } from "@mui/x-data-grid/DataGrid";
import { NextPage } from "next";
import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";


import React from "react";

interface IArticle {
    id: number,
    title: string,
    content: string,
    writer: string,
    registerDate: string
}

const UsersPage: NextPage = () => {
    const [pageSize, setPageSize] = useState(5);
    const dispatch = useDispatch()
 
   const allUsers: [] = useSelector(getAllUsers)

    if(allUsers !== undefined){
        console.log('allUser is not undefined')
        
        console.log('length is '+ allUsers.length)
        for(let i=0; i< allUsers.length; i++){
            console.log(JSON.stringify(allUsers[i]))
        }
    }else{
        console.log('allUser is undefined')
    }
    

    useEffect(() => {
        dispatch(findAllUsers(1))
    }, [])


    return (<>
        <h2>사용자 목록</h2>``
        <div style={{ height: 400, width: "100%" }}>
      {allUsers && <DataGrid
        rows={allUsers}
        columns={UserColumns()}
        pageSizeOptions={[5, 10, 20]}
        checkboxSelection
      />}
    </div>
    </>)
}

export default UsersPage