'use client'

import axios from "axios"
import {useState}from "react"
import {useRouter} from "next/navigation"
import { config } from "process"
import { API } from "@/redux/common/enums/API"
import AxiosConfig from "@/redux/common/configs/axios-config"
import { NextPage } from "next"


const LoginPage:NextPage=()=> {

    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')


    const handleUsername = (e: any) => {
        setUsername(e.target.value)
    }

    const handlePassword = (e: any) => {
        setPassword(e.target.value)
    }
    const router = useRouter();

        const url = `${API.SERVER}/login`
        const data = {'username':username, 'password':password }
        

    const handleSubmit = () => {
        axios.post(url, data, AxiosConfig())
            .then(res => { 
                const message=res.data.message
                alert(message)
                if(message === 'SUCCESS'){
                                        
                 }else if (message === 'FAIL'){
                 }else if (message === 'WRONG._PASSWORD'){
                 }else{
                 }
            })
    }
    return (<>
        <h2>로그인 하세요</h2>
        <h3>아이디를 입력하세요</h3>
        <input type="text" onChange={handleUsername} />
        <h3>비밀번호를 입력하세요</h3>
        <input type="text" onChange={handlePassword} /><br />
        <button onClick={handleSubmit}>전송</button>

    </>)
}
export default LoginPage