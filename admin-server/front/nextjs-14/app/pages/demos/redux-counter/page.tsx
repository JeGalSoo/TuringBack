'use client'
import AddIcon from '@mui/icons-material/Add';
import RemoveIcon from '@mui/icons-material/Remove';
import { useSelector, useDispatch } from 'react-redux'
import { handlePlus, handleMinus, getCount } from '@/redux/features/counter/counter.slice'
import { NextPage } from 'next';

// export default function Counter() {
//     const count = useSelector(getCount)
//     const dispatch = useDispatch()
//     return (<>
//         <div className="text-center mt-500" style={{ marginTop: '100px' }}>
//             <h1>Redux Counter : {count}</h1>
//             <AddIcon onClick={() => dispatch(handlePlus())} /><br />
//             <RemoveIcon onClick={() => dispatch(handleMinus())} /><br />
//         </div>
//     </>)
// }
const CounterPage:NextPage=()=>{

    const count = useSelector(getCount)
    const dispatch = useDispatch()

//const [count,setCount] = useState(Number)

// const handlePlus = () =>{
// setCount(count+1)
// }

// const handleMinus =() =>{
// setCount(count-1)
// }
    return(<div className="text-center mt-500" style={{marginTop:'100px'}}>
    <h1>Redux Counter : {count}</h1>
  
    <AddIcon color="secondary" sx={{ fontSize: 100 }} onClick = {()=>dispatch(handlePlus())}/>
    <RemoveIcon color="secondary" sx={{ fontSize: 100 }} onClick = {()=>dispatch(handleMinus())} />
    

    
    </div>)
}
export default CounterPage