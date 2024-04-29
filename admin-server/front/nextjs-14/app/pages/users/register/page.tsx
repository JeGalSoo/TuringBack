'use client'
import { useState } from "react"
import { useRouter } from "next/navigation"
import axios from "axios"
import { API } from "@/redux/common/enums/API"
import AxiosConfig from "@/redux/common/configs/axios-config"
import { NextPage } from "next"


const JoinPage:NextPage=()=>{
    const [username,setusername]=useState('')
    const [password,setppassword]=useState('')
    const [name,setname]=useState('')
    const [phone,setphone]=useState('')
    const [addressId,setaddressId]=useState('')
    const [job,setjob]=useState('')



    const handleusername = (e:any)=>{
        setusername(e.target.value)
    }
    const handlepassword = (e:any)=>{
        setppassword(e.target.value)
    }
    const handlename = (e:any)=>{
        setname(e.target.value)
    }
    const handlephone = (e:any)=>{
        setphone(e.target.value)
    }
    const handleaddressId = (e:any)=>{
        setaddressId(e.target.value)
    }
    const handlerecommender = (e:any)=>{
        setjob(e.target.value)
    }


    const router = useRouter();

    const url=`${API.SERVER}`
    const data={username, password, name, phone, addressId, job}

    const jclick = () => {
        alert("회원가입")
        axios.post(url, data, AxiosConfig())
            .then(res => { 
                alert(JSON.stringify(res.data))
                router.push("/user/login") 
            })     
    }
 

            
    return(<>
 <div className="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
    <hr/>
<form>
    <br/>
    <label htmlFor="psw"><b>username</b></label>
    <input type="text" placeholder="Enter Password" name="psw" onChange={handleusername} required/>
    <br/>
    <label htmlFor="psw-repeat"><b>password</b></label>
    <input type="password" placeholder="Repeat Password" name="psw-repeat" onChange={handlepassword} required/>
    <br/>
    <label htmlFor="psw-repeat"><b>name</b></label>
    <input type="text" placeholder="Repeat Password" name="psw-repeat" onChange={handlename} required/>
    <br/>
    <label htmlFor="psw-repeat"><b>phone</b></label>
    <input type="text" placeholder="Repeat Password" name="psw-repeat" onChange={handlephone} required/>
    <br/>
    <label htmlFor="psw-repeat"><b>addressId</b></label>
    <input type="text" placeholder="Repeat Password" name="psw-repeat" onChange={handleaddressId} required/>
    <br/>
    <label htmlFor="psw-repeat"><b>job</b></label>
    <input type="text" placeholder="Repeat Password" name="psw-repeat" onChange={handlerecommender} required/>
    <br/>
    <button type="reset" className="cancelbtn" >Cancel</button>
</form>

    <label>
      <input type="checkbox" checked={true} name="remember" style={{marginBottom:"15px"}}/> Remember me
    </label>
    
    <p>By creating an account you agree to our <a href="#" style= {{color:"dodgerblue"}}>Terms & Privacy</a>.</p>

    <div className="clearfix">
      <button type="reset" className="cancelbtn">Cancel</button>
      <button type="submit" className="signupbtn" onClick={jclick}>Sign Up</button>
    </div>
  </div>
    </>)
}
export default JoinPage