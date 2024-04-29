'use client'

import { Button } from "@mui/material";
import { useState } from "react";
export default function Counter(){
    const [count,setCount]=useState(1)

    const plus=(()=>{
        setCount(count+1)
    })
    const minus=(()=>{
        setCount(count-1)
    })

    return (<>
    <h1>Counter : {count}</h1>
    <Button onClick={plus}>+</Button>
    <Button onClick={minus}>-</Button>
    </>)
}
