'use client'

import { PG } from "@/redux/common/enums/PG";
import { NextPage } from "next";
import Link from "next/link";

const UserPage:NextPage=()=> {
  return (<>
    <h3>오늘도 확실하고 다양하게 먹어보자</h3>
    <Link href={PG.USER+"/login"} >login</Link><br/>
    <Link href={PG.USER+"/join"} >join</Link><br/>
    <Link href={PG.USER+"/delete"} >delete</Link><br/>
    <Link href={PG.USER+"/update"} >update</Link><br/>
    <Link href={PG.USER+"/member"} >memberlist</Link>

  </>)

}
export default UserPage