'use client';
import { useEffect, useState } from 'react';
import { useRouter, useSearchParams } from 'next/navigation';
import { PG } from '@/redux/common/enums/PG';
import LinkButton, { linkButtonTitles } from '@/app/atoms/button/LinkButton';
import Link from 'next/link';
import { destroyCookie, parseCookies } from 'nookies';
import { useDispatch } from 'react-redux';
import { logout } from '../../users/service/user.service';
import { jwtDecode } from 'jwt-decode';

const pages = [/*'회원가입','로그인',*/ '카운터', '게시판목록', '게시글목록', '사용자목록'];
const rou = [PG.USER + "/join", PG.USER + "/login"];
const settings = ['Profile', 'Account', 'Dashboard', 'Logout'];
interface decodeType{
  iss? : string
  exp? : string
  sub? : string
  username?:string
  name?:string
  job? : string
  id?:number
}


function Header() {
  const router = useRouter();
  const dispatch = useDispatch();
  const [showProfile, setShowProfile] = useState(false)
  const decodeData:decodeType = jwtDecode<any>(parseCookies().accessToken)

  useEffect(() => {
    if (parseCookies().accessToken) {
      setShowProfile(true)
    } else {
      setShowProfile(false)
    }
  }, [parseCookies().accessToken])

  const logoutHandler = () => {
    console.log('로그아웃 적용 전 : ' + parseCookies().accessToken)
    dispatch(logout())
      .then((res: any) => {
        destroyCookie(null, 'accessToken')
        setShowProfile(false)
        router.push('/')
      })
      .catch((err: any) => {
        console.log('logout 실행에서 에러가 발생함' + err)
      })
  }

  const myPageHandler = () => {
    router.push(`${PG.USER}/detail/${decodeData.id}`)
  }


  const [anchorElNav, setAnchorElNav] = useState<null | HTMLElement>(null);
  const [anchorElUser, setAnchorElUser] = useState<null | HTMLElement>(null);

  const handleOpenNavMenu = (event: React.MouseEvent<HTMLElement>) => {
    setAnchorElNav(event.currentTarget);
  };
  const handleOpenUserMenu = (event: React.MouseEvent<HTMLElement>) => {
    setAnchorElUser(event.currentTarget);
  };


  // const handleCloseNavMenu = (event: any) => {
  //   switch(event.target.innerText){
  //     // case "회원가입" : router.push(PG.USER+"/join"); break;
  //     // case "로그인" : router.push(PG.USER+"/login"); break;
  //     case "카운터" : router.push(PG.DEMO+"/counter"); break;
  //     case "게시판목록" : router.push(PG.BOARD); break;
  //     case "게시글목록" : router.push(PG.BOARD+"/article"); break;
  //     case "사용자목록" : router.push(PG.USER+"/member"); break;
  //   }
  // };

  const handleCloseUserMenu = () => {
    setAnchorElUser(null);
  };

  return (<nav className="bg-white border-gray-200 dark:bg-gray-900">
    <div className="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
      <Link href="/" className="flex items-center space-x-3 rtl:space-x-reverse">
        <img src="https://flowbite.com/docs/images/logo.svg" className="h-8" alt="Flowbite Logo" />
        <span className="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">Flowbite</span>
      </Link>
      {!showProfile && <button type="button" className="flex text-sm bg-gray-800 rounded-full md:me-0 focus:ring-4 focus:ring-gray-300 dark:focus:ring-gray-600" id="user-menu-button" aria-expanded="false" data-dropdown-toggle="user-dropdown" data-dropdown-placement="bottom">
        <span className="sr-only">Open user menu</span>
        <img className="w-8 h-8 rounded-full" src="/public/img/images.png" alt="user photo" />
      </button>}
      {showProfile &&
        <div className="flex px-4 py-3 float-end">
          <span className="block text-sm text-gray-900 dark:text-white">{decodeData.username}</span>
          <span className="block text-sm  text-gray-500 truncate dark:text-gray-400 mx-5" onClick={myPageHandler}>마이페이지</span>
          <span className="block text-sm  text-gray-500 truncate dark:text-gray-400" onClick={logoutHandler}><a href='#'></a> Logout </span> 
        </div>
      }
      <div className="items-center justify-between hidden w-full md:flex md:w-auto md:order-1" id="navbar-user">
        <ul className="flex flex-col font-medium p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:space-x-8 rtl:space-x-reverse md:flex-row md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700">
          {linkButtonTitles.map((item) => (
            <li key={item.id}>
              <LinkButton id={item.id} title={item.title} path={item.path} />
            </li>
          ))}

        </ul>
      </div>
    </div>
  </nav>);
}
export default Header;