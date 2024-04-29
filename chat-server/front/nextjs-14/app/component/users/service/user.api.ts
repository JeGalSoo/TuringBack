import AxiosConfig from "@/redux/common/configs/axios-config"
import instance from "../../common/configs/axios-config"

export const findAllUsersAPI = async (page: number) =>{
    try{
        const response = await instance().get('/users/list',{
            params: {page, limit: 10}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
}

export const findByIdAPI = async (id: any) =>{
    try{
        const response = await instance().get('/users/detail',{
            params: {id}
        })
        console.log('여기는 findbyid api : '+JSON.stringify(response.data))
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
}

export const deleteByIdAPI = async (id: any) =>{
    try{
        const response = await instance().delete(`/users/delete/${id}`,{
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
}

export const modifyByIdAPI = async (props: any) =>{
    try{
        return (await instance().post('/users/modify',props)).data
        // const response = await instance.post('/users/modify',{
        //     data: {props}
        // })
        // return response.data
    }catch(error){
        console.log(error)
        return error
    }
}

export const loginAPI = async (data:any) => {
    try{
        const response = await instance().post('/auth/login',
            data)
        console.log(response.data)
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
}

export const existIdAPI = async (username:any) => {
    try{
        const response = await instance().get('/auth/check',{
            params: {username}
        })
        console.log('existId테스트입니다'+response.data.message)
        return response.data.message
    }catch(error){
        console.log(error)
        return error
    }
}

export const logoutAPI = async() => {
    try{
        const response = await instance().get('/users/logout',{
            params: {}
        })
        console.log('logout테스트입니다'+response.data.message)
        return response.data.message
    }catch(error){
        console.log(error)
        return error
    }
}