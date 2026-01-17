import React,{useEffect, useState} from 'react'
import {Navigate} from "react-router-dom";
import {useSelector,useDispatch} from "react-redux";
import {setAuthenticatedUser} from "../../store/auth"
import Home from './Home';
function Main() {
    /** state */
    const dispatch = useDispatch();
    const [isLogged,setIsLogged] = useState(null);
    const {authenticatedUser} = useSelector(state=>state.authStore)

    /** events */
    useEffect(()=>{
        if(authenticatedUser){
            setIsLogged(true)
        }else{
            const authenticatedUser = {
                name: "Tran Ngoc Chau Bang",
                email: "phongpt@atp.com",
                picture:""
            }
            // const authenticatedUser = null;
            setIsLogged(authenticatedUser != null?true:false);
            dispatch(setAuthenticatedUser(authenticatedUser));
        }

    },[])
    if(isLogged === null) return <div></div>
   return isLogged ? <Home/> : <Navigate to="/authen/login" replace={true}/>;
}

export default Main