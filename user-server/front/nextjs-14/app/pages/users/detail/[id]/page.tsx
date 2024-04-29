'use client'
import { useSelector } from "react-redux"
import { useDispatch } from "react-redux"
import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";
import { useForm } from "react-hook-form";
import { destroyCookie } from "nookies";
import { deleteById, findUserById, logout, modifyUser } from "@/app/component/users/service/user.service";
import { IUser } from "@/app/component/users/model/user";
import { PG } from "@/redux/common/enums/PG";
import { getById } from "@/app/component/users/service/user.slice";
import { Typography12 } from "@/app/component/common/style/ceil";

export default function UserPage(props: any) {
  const { register, handleSubmit, formState: { errors } } = useForm();
  const dispatch = useDispatch();
  const router = useRouter();
  const userInfo = useSelector(getById);
  useEffect(() => {
    if (props.params.id != 0) {
        console.log('여기는 디테일페이지 처음 : '+props.params.id)
      dispatch(findUserById(props.params.id))
    }
  }, [])
  const handleCancel = () => {
    alert("회원 정보 수정을 취소합니다.")
    router.back();
  }
  const onSubmit=(user: IUser)=>{
    dispatch(modifyUser(user))
      .then((res: any) => {
        console.log(res.payload)
        if(res?.payload==='SUCCESS'){
          alert("회원 정보 수정 완료");
          router.push(`${PG.BOARD}/list`);
        }else if(res?.payload==='FAILURE'){
          alert("회원 정보 수정 실패");
        }
      })
      .catch((error: any) => {
      }).finally(()=>{
        location.reload();
      });
  }

  const handleWithDrawal = () => {
    dispatch(deleteById(props.params.id)).
      then((res: any) => {
        console.log(res.payload.message)
        if (res.payload.message === 'SUCCESS') {
          alert('회원 탈퇴 완료')
          destroyCookie(null, 'accessToken')
          router.push('/');
            } else {
          alert('회원 탈퇴 실패');
        }
  })
  }
  return (
    <>
      <form onSubmit={handleSubmit(onSubmit)} className=" max-w-md mx-auto mb-10 mt-10">
        <label htmlFor="large" className="block mb-2 text-base font-medium text-gray-900 dark:text-white">Large select</label>
        <div className="editor mx-auto w-10/12 flex flex-col text-gray-800 border border-gray-300 p-4 shadow-lg max-w-2xl">
          {Typography12('회원 정보 수정', "1.5rem")}
          <input
            {...register('id')}
            type="hidden"
            value={props.params.id} />
          <div className="username-wrapper">
            <input
              {...register('username',{required:true})}
              className="username mt-2 bg-gray-100 border border-gray-300 p-2 mb-4 outline-none"
              type="text"
              value={userInfo.username} //----------------------------------------
              readOnly
            />
            <span className="hover-message">Hover message here</span>
          </div>
          <input
            {...register('password', {maxLength: 20,required:true })}
            className="password bg-gray-100 border border-gray-300 p-2 mb-4 outline-none"
            placeholder="Password"
            type="text"
            name="password"
            defaultValue={userInfo.password} //---------------------------------------
            />
          <input
            {...register('name', {maxLength: 20, required:true })}
            className="name bg-gray-100 border border-gray-300 p-2 mb-4 outline-none"
            placeholder="Name"
            type="text"
            name="name"
            defaultValue={userInfo.name} //-------------------------------------------
             />
          <input
            {...register('phone', { maxLength: 20, required:true })}
            className="phone bg-gray-100 border border-gray-300 p-2 mb-4 outline-none"
            placeholder="Phone"
            type="text"
            name="phone"
            defaultValue={userInfo.phone} //-------------------------------------------
           />
          <input
            {...register('job', { maxLength: 20,required:true })}
            className="job bg-gray-100 border border-gray-300 p-2 mb-4 outline-none"
            placeholder="Job"
            type="text"
            name="job"
            defaultValue={userInfo.job} //-------------------------------------------
            />
          {/* <!-- buttons --> */}
          <div className="buttons flex justify-center gap-5">
            <div className="btn justify-items-center overflow-hidden relative w-30 bg-white text-blue-500 p-3 px-4 rounded-xl font-bold uppercase -- behtmlFore:block behtmlFore:absolute behtmlFore:h-full behtmlFore:w-1/2 behtmlFore:rounded-full
          behtmlFore:bg-pink-400 behtmlFore:top-0 behtmlFore:left-1/4 behtmlFore:transition-transhtmlForm behtmlFore:opacity-0 behtmlFore:hover:opacity-100 hover:text-200 hover:behtmlFore:animate-ping transition-all duration-00
          border border-gray-300 shadow-lg text-lg
          hover:bg-blue-100 focus:shadow-outline focus:outline-none
          "
              onClick={handleCancel}>취소</div>
            <input
              type="submit" value="수정"
              className="btn  overflow-hidden relative w-30 bg-white text-blue-500 p-3 px-4 rounded-xl font-bold uppercase -- behtmlFore:block behtmlFore:absolute behtmlFore:h-full behtmlFore:w-1/2 behtmlFore:rounded-full
          behtmlFore:bg-pink-400 behtmlFore:top-0 behtmlFore:left-1/4 behtmlFore:transition-transhtmlForm behtmlFore:opacity-0 behtmlFore:hover:opacity-100 hover:text-200 hover:behtmlFore:animate-ping transition-all duration-00
          border border-gray-300 shadow-lg text-lg
          hover:bg-blue-100 focus:shadow-outline focus:outline-none"
            />
          </div>
        </div>
        <div className="btn justify-items-center overflow-hidden relative ml-24 max-w-60 my-10 bg-blue-500 text-white text-center p-3 mx-16 rounded-xl text-xl font-bold uppercase -- behtmlFore:block behtmlFore:absolute behtmlFore:h-full behtmlFore:w-1/2 behtmlFore:rounded-full
          behtmlFore:bg-pink-400 behtmlFore:top-0 behtmlFore:left-1/4 behtmlFore:transition-transhtmlForm behtmlFore:opacity-0 behtmlFore:hover:opacity-100 hover:text-200 hover:behtmlFore:animate-ping transition-all duration-00
          border border-gray-300 shadow-lg hover:bg-blue-400 focus:shadow-outline focus:outline-none"
          onClick={handleWithDrawal}>회원 탈퇴</div>
      </form>
    </>);
}
// export default RegisterPage
//       <button type="reset" className="cancelbtn" onClick={jclick}>수정</button>
//       <button type="submit" className="signupbtn" onClick={dclick}>틸퇴</button>