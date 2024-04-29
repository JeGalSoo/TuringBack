import CompanyRows from "@/app/component/rows/company-rows"
import { NextPage } from "next"
import { Main } from "next/document"
interface IArticle{
  company : string,
  contact : string,
  country : string
}
  const Company=(props:IArticle)=>{
    return(
      <tr>
        <td>{props.company}</td>
        <td>{props.contact}</td>
        <td>{props.country}</td>
      </tr>
    
    )
  }
const CompanyPage:NextPage=()=>{

    const articlesMap = CompanyRows().map((v,i)=>(<Company key={i}{...v}/>))

    return (<>
     <table>
        <thead>
      <tr>
      <th>Company</th>
      <th>Contact</th>
      <th>Country</th>
      </tr>
      </thead>
      <tbody>
      {articlesMap}
      </tbody>
      </table>
    </>)
   
}
export default CompanyPage