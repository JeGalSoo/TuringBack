import { useEffect, useState } from "react"
import axios from "axios"
import { API } from "@/redux/common/enums/API"
import AxiosConfig from "@/redux/common/configs/axios-config"

export default function ArticleRows(){
  const [articles, setArticles] = useState([])
    const url = `${API.SERVER}/all-articles`
    useEffect(() => {
      axios.get(url, AxiosConfig())
        .then(res => {
         const message = res.data.message
          if (message === 'SUCCESS') {
             setArticles(res.data.result)
            
          } else if (message === 'FAIL') {
            console.log("게시글이 없습니다.")
          } else {
            console.log("지정되지 않은 값")
          }
        })
    }, [])
return articles

}