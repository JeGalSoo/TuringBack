import { touchRippleClasses } from "@mui/material"
import { useRouter } from "next/navigation"

interface IMoveButton{
    text:string,
    path:string
}
export default function MoveButton({text,path}:IMoveButton){

    const router = useRouter()
    

    return (<>
    <button onClick={()=>router.push(path)} type="button" className="text-white bg-blue-700 hover:bg-blue-800 focus:outline-none focus:ring-4 focus:ring-blue-300 font-medium rounded-full text-sm px-5 py-2.5 text-center me-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">사용금지</button>
    <span className="relative px-5 py-2.5 transition-all ease-in duration-75 bg-white dark:bg-gray-900 rounded-md group-hover:bg-opacity-0">
        {text}
    </span>
    </>)
}