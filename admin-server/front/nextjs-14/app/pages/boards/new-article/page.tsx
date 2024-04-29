import AxiosConfig from "@/redux/common/configs/axios-config";
import { API } from "@/redux/common/enums/API";
import { Button } from "@mui/material";
import axios from "axios";
import { useRouter } from "next/router";
import { useState } from "react";

export default function NewArticle(){
    const [title,setTitle] = useState('')
    const [content,setContent] = useState('')

    const handletitle = (e:any)=>{
        setTitle(e.target.value)
    }
    const handlecontent = (e:any)=>{
        setContent(e.target.value)
    }

    const router = useRouter()

    const url = `${API.SERVER}/articleSave}`
    const data = {'title':title, 'content':content}

    const handleClick = (()=>{
        alert("완료")
        axios.post(url,data,AxiosConfig())
        .then(res => {
            JSON.stringify(res.data)
            router.push("/boards/articles")
        })
    })

    return (<>
    <input name="title" onChange={handletitle}/>
    <input name="content" onChange={handlecontent}/>
    <Button type="submit" onClick={handleClick}>개시</Button>
    </>)
}