import { ConstructionOutlined } from '@mui/icons-material'
import axios, { AxiosInstance } from 'axios'
import { Console } from 'console'
import { parseCookies } from 'nookies'

// export default function AxiosConfig(){
//     return {
//         headers: {
//             "Cache-Control": "no-cache",
//             "Content-Type": "application/json",
//             Authorization: `Bearer blah ~`,
//             "Access-Control-Allow-Origin": "*",
//         }
//     }
// }

export default function instance(){
const instance = axios.create({ baseURL: process.env.NEXT_PUBLIC_API_URL})
setInterceptor(instance)
return instance
}


export const setInterceptor = (inputInstance:AxiosInstance)=>{
    inputInstance.interceptors.request.use(
    (config)=>{
        config.headers["Content-Type"] = "application/json"
        config.headers['Authorization'] = `Bearer ${parseCookies().accessToken}`
        return config
    },
    (error)=>{
        console.log('axios interceptor의 request에서 발생한 에러부분 : '+error)
        return Promise.reject(error)
    }
)

inputInstance.interceptors.response.use(
    (response)=>{
        if(response.status === 404)
            console.log('axios interceptor의 response에서 발생한 에러부분 : 토큰이 없어서 404로 넘어감')
        return response
    },
)
return inputInstance
}