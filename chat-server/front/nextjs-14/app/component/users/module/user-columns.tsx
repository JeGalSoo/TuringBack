import { Typography } from "@mui/material";
import { GridColDef } from "@mui/x-data-grid";
import { UserColumn } from "../model/user-Column";
import { PG } from "@/redux/common/enums/PG";
import Link from "next/link";
import { Typography12 } from "../../common/style/ceil";
import { jobHandler, nameHandler, phoneHandler, usernameHandler } from "@/app/component/users/service/user.slice";

import { useDispatch } from "react-redux";
// import { Typography12 } from "../../common/style/ceil";


interface CellType{
    row : UserColumn
}


export default function UserColumns(): GridColDef[]{

    return [
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'id',
            headerName: 'No.',
            renderCell: ({row}:CellType) =>  Typography12(row.id,"1.2rem")
            }
        ,
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'username',
            headerName: '이름',
            renderCell: ({row}:CellType) =>  <Typography textAlign="center" sx={{fontSize:"1.2rem"}}>
                <Link href={`${PG.USER}/detail/${row.id}`} className="underline" > {row.username} </Link></Typography>
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'password',
            headerName: '비밀번호',
            renderCell: ({row}:CellType) =>  <Typography textAlign="center" sx={{fontSize:"1.2rem"}}>  {row.password}</Typography>
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'name',
            headerName: '이름',
            renderCell: ({row}:CellType) =>  <Typography textAlign="center" sx={{fontSize:"1.2rem"}}>  {row.name}</Typography>
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'phone',
            headerName: '전화번호',
            renderCell: ({row}:CellType) =>  <Typography textAlign="center" sx={{fontSize:"1.2rem"}}>  {row.phone}</Typography>
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'job',
            headerName: '직업',
            renderCell: ({row}:CellType) =>  <Typography textAlign="center" sx={{fontSize:"1.2rem"}}>  {row.job}</Typography>
        },
    ]
}



export  function UserByIdColumns(): GridColDef[]{
    const dispatch = useDispatch();


    const handleusername = (e:any) => dispatch(usernameHandler(e.target.value))
    const handlename = (e:any) => dispatch(nameHandler(e.target.value))
    const handlephone = (e:any) => dispatch(phoneHandler(e.target.value))
    const handlejob = (e:any) => dispatch(jobHandler(e.target.value))


    return [
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'id',
            headerName: 'No.',
            renderCell: ({row}:CellType) =>  Typography12(row.id,"1.2rem")
            }
        ,
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'username',
            headerName: '이름',
            renderCell: ({row}:CellType) =>  <input type="text" defaultValue={row.username} onChange={handleusername}></input>
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'name',
            headerName: '이름',
            renderCell: ({row}:CellType) =>  <input type="text" defaultValue={row.name} onChange={handlename}></input> 
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'phone',
            headerName: '전화번호',
            renderCell: ({row}:CellType) =>  <input type="text" defaultValue={row.phone} onChange={handlephone}></input>
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'job',
            headerName: '직업',
            renderCell: ({row}:CellType) =>   <input type="text" defaultValue={row.job} onChange={handlejob}></input>
        }
    ]
}