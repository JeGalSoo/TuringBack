'use client'

import { useRef, useState } from "react"
import Link from "next/link";
import './globals.css'
import { NextPage } from "next";
import { PG } from "@/redux/common/enums/PG";
import { existId, loginUser } from "./component/users/service/user.service";
import { useDispatch } from "react-redux";
import { useRouter } from "next/navigation";
import { IUser } from "./component/users/model/user";
import { parseCookies, setCookie } from 'nookies';
import { jwtDecode } from "jwt-decode";


const SERVER = 'http://localhost:8080'
const HomePage: NextPage = () => {
  const passwordRef = useRef<HTMLInputElement>(null);
  const dispatch = useDispatch()
  const [isWrongId, setIsWrongId] = useState('')
  const [isWrongPw, setIsWrongPw] = useState('')
  const [isCheckId, setIsCheckId] = useState('')
  const [user, setUser] = useState({} as IUser)//뜻 : IUser user = new IUser(보안의 기능도 있음-그냥 각자 선언해서 받으면 보여짐)

  const router = useRouter()

  // const handleUsername = (e: any) => {
  //   setUser({
  //     ...user,username:e.target.value})//...은 ...뒤에오는 형식을 상속한다는 뜻
  //   const ID_CHECK = /^[a-zA-Z]+[]{5,19}$/g;
  // //   //한 글자에 대한 조건은 []로 나타낸다. +는 중간에 다른 글자들이 들어온다는 뜻
  // //   //{5,19}는 맨 앞에 첫[]글자 빼고 5자~19자라는 뜻
  // //   //첫글자 영어 소문자만이면 [a-z], 대문자만 [A-Z], 한글[ㄱ-힣], 숫자[0-9]
  // //   //영어 대소문자로 시작하는 6~20자리의 영어 대소문자 또는 숫자
  // //   if(e.match(ID_CHECK)){
  // //   }else{
  // //     alert('잘못된 형식의 아이디 입니다.')
  // //   }
  // }

  const handleUsername = (e: any) => {
    const ID_CHECK = /^[a-zA-Z][a-zA-Z]{2,19}$/g
    if (ID_CHECK.test(e.target.value)) {
      setIsWrongId("false")
      setUser({
        ...user, username: e.target.value
      })
    } else {
      setIsWrongId("true")
    }
  }

  const handlePassword = (e: any) => {
    // const PW_CHECK = /^[0-9]$/g
    // const PW_CHECK = /^[a-zA-Z0-9\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]+[a-zA-Z\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]{5,19}$/g;
    // if (PW_CHECK.test(e.target.value)) {
      setUser({
        ...user, password: e.target.value
      })
    // } else {
    //   setIsWrongPw("true")
    // }
  }



  // useEffect(() => {
  //   if (existdata === "false") {
  //     setIsCheckId("true")
  //   }
  //   if (logindata.message === "SUCCESS") {
  //     setCookie({}, 'message', logindata.message, { httpOnly: false, path: '/' })
  //     setCookie({}, 'token', logindata.token, { httpOnly: false, path: '/' })
  //     console.log('서버에서 넘어온 메시지' + parseCookies().message)
  //     console.log('서버에서 넘어온 토큰' + parseCookies().token)
  //     console.log('토큰을 decode한 내용 : ' + JSON.stringify(jwtDecode<any>(parseCookies().token)))
  //     // router.push(`${PG.BOARD}/list`)
  //   } else {
  //     console.log('LOGIN FAIL')
  //   }
  // }, [logindata])

  const handleSubmit = () => {
    dispatch(existId(user.username))
      .then((res: any) => {
        console.log('1111'+res.payload)
        if (res.payload === 'true') {
          dispatch(loginUser(user))
            .then((res: any) => {
              setCookie({}, 'message', res.payload.message, { httpOnly: false, path: '/' })
              setCookie({}, 'accessToken', res.payload.accessToken, { httpOnly: false, path: '/' })
              console.log('서버에서 넘어온 메시지' + parseCookies().message)
              console.log('서버에서 넘어온 토큰' + parseCookies().accessToken)
              console.log('토큰을 decode한 내용 : ' + JSON.stringify(jwtDecode<any>(parseCookies().accessToken)))
              router.push(`${PG.BOARD}/list`)
            })
            .catch((err: any) => {
              console.log('로그인 실패')
            })
        } else {
          console.log('아이디가 존재하지 않습니다')
          setIsWrongId('false')
          setIsCheckId('false')
        }
      })
      .catch((err: any) => { })
      .finally(() => {
        console.log('최종적으로 반드시 이뤄져야 할 로직')
      })
    //dispatch(loginUser(user))
    if (passwordRef.current) {
      passwordRef.current.value = "";
    }
  }


  return (<div className="text-center" >
    <h1 >Welcome to react world  !!</h1><br />
    <div className="flex items-center justify-center w-full px-5 sm:px-0">
      <div className="flex bg-white rounded-lg shadow-lg border overflow-hidden max-w-sm lg:max-w-4xl w-full">
        <div
          className="hidden md:block lg:w-1/2 bg-cover bg-blue-700"
          style={{
            backgroundImage: `url(https://www.tailwindtap.com//assets/components/form/userlogin/login_tailwindtap.jpg)`,
          }}
        ></div>
        <div className="w-full p-8 lg:w-1/2">
          <p className="text-xl text-gray-600 text-center">Welcome back!</p>
          <div className="mt-4">
            <label className="block text-gray-700 text-sm font-bold mb-2">
              ID
            </label>
            <input
              onChange={handleUsername}
              className="text-gray-700 border border-gray-300 rounded py-2 px-4 block w-full focus:outline-2 focus:outline-blue-700"
              type="email"
              required
            />
          </div>
          {isWrongId !== '' && (isWrongId == "true" ?
            (<pre><h6 className="text-red-500">잘못된 형식입니다.</h6></pre>) :
            (<pre><h6 className="text-blue-500">올바른 형식입니다.</h6></pre>))}
          {isCheckId && (<pre>
            <h6 className="text-red-500">아이디틀림.</h6>
          </pre>)}
          <div className="mt-4 flex flex-col justify-between">
            <div className="flex justify-between">
              <label className="block text-gray-700 text-sm font-bold mb-2">
                Password
              </label>
            </div>
            <input
              ref={passwordRef}
              onChange={handlePassword}
              className="text-gray-700 border border-gray-300 rounded py-2 px-4 block w-full focus:outline-2 focus:outline-blue-700"
              type="password"
            />
            {isWrongPw !== '' && (isWrongPw == "true" ?
              (<pre><h6 className="text-red-500">잘못된 형식입니다.</h6></pre>) :
              (<pre><h6 className="text-blue-500">올바른 형식입니다.</h6></pre>))}
            <a
              href="#"
              className="text-xs text-gray-500 hover:text-gray-900 text-end w-full mt-2"
            >
              Forget Password?
            </a>
          </div>
          <div className="mt-8">
            <button
              onClick={handleSubmit}
              className="bg-blue-700 text-white font-bold py-2 px-4 w-full rounded hover:bg-blue-600">
              Login
            </button>
          </div>
          <a
            href="#"
            className=" flex items-center justify-center mt-4 text-white rounded-lg shadow-md hover:bg-gray-100"
          >
            <div className="flex px-5 justify-center w-full py-3">
              <div className="min-w-[30px]">
                <svg className="h-6 w-6" viewBox="0 0 40 40">
                  <path
                    d="M36.3425 16.7358H35V16.6667H20V23.3333H29.4192C28.045 27.2142 24.3525 30 20 30C14.4775 30 10 25.5225 10 20C10 14.4775 14.4775 9.99999 20 9.99999C22.5492 9.99999 24.8683 10.9617 26.6342 12.5325L31.3483 7.81833C28.3717 5.04416 24.39 3.33333 20 3.33333C10.7958 3.33333 3.33335 10.7958 3.33335 20C3.33335 29.2042 10.7958 36.6667 20 36.6667C29.2042 36.6667 36.6667 29.2042 36.6667 20C36.6667 18.8825 36.5517 17.7917 36.3425 16.7358Z"
                    fill="#FFC107"
                  />
                  <path
                    d="M5.25497 12.2425L10.7308 16.2583C12.2125 12.59 15.8008 9.99999 20 9.99999C22.5491 9.99999 24.8683 10.9617 26.6341 12.5325L31.3483 7.81833C28.3716 5.04416 24.39 3.33333 20 3.33333C13.5983 3.33333 8.04663 6.94749 5.25497 12.2425Z"
                    fill="#FF3D00"
                  />
                  <path
                    d="M20 36.6667C24.305 36.6667 28.2167 35.0192 31.1742 32.34L26.0159 27.975C24.3425 29.2425 22.2625 30 20 30C15.665 30 11.9842 27.2359 10.5975 23.3784L5.16254 27.5659C7.92087 32.9634 13.5225 36.6667 20 36.6667Z"
                    fill="#4CAF50"
                  />
                  <path
                    d="M36.3425 16.7358H35V16.6667H20V23.3333H29.4192C28.7592 25.1975 27.56 26.805 26.0133 27.9758C26.0142 27.975 26.015 27.975 26.0158 27.9742L31.1742 32.3392C30.8092 32.6708 36.6667 28.3333 36.6667 20C36.6667 18.8825 36.5517 17.7917 36.3425 16.7358Z"
                    fill="#1976D2"
                  />
                </svg>
              </div>
              <div className="flex w-full justify-center">
                <h1 className="whitespace-nowrap text-gray-600 font-bold">
                  Sign in with Google
                </h1>
              </div>
            </div>
          </a>
          <div className="mt-4 flex items-center w-full text-center">
            <Link
              href="pages/users/join"
              className="text-xs text-gray-500 capitalize text-center w-full"
            >
              Don&apos;t have any account yet?
              <span className="text-blue-700"> Sign Up</span>
            </Link>
          </div>
        </div>
      </div>
    </div>
  </div>)

}
export default HomePage