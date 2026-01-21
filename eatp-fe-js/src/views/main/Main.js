import React,{useEffect, useState} from 'react'
import {Navigate, useSearchParams} from "react-router-dom";
import {useSelector,useDispatch} from "react-redux";
import {setAuthenticatedUser} from "../../store/auth";
import {getAuthentication} from "../../services/auth/auth.service";
import Home from './Home';
function Main() {
    /** state */
    const dispatch = useDispatch();
    const [isLogged,setIsLogged] = useState(null);
    const {authenticatedUser} = useSelector(state=>state.authStore);
    const [searchParams,setSearchParams] = useSearchParams();

    /** events */
    const checkLogin = async ()=>{
            const authenticatedUser = await getAuthentication();
            setIsLogged(authenticatedUser != null?true:false);
            dispatch(setAuthenticatedUser(authenticatedUser));
    }
    const handlePostLogout = ()=>{
        if(searchParams.has("isLogged") && searchParams.get("isLogged") && searchParams.get("isLogged") === "false"){
                setIsLogged(false);
                dispatch(setAuthenticatedUser(null));
        }
    }
    useEffect(()=>{
        if(searchParams.has("isLogged") && searchParams.get("isLogged") && searchParams.get("isLogged") === "false"){
                setIsLogged(false);
                dispatch(setAuthenticatedUser(null));
        }else{
            if(authenticatedUser){
                setIsLogged(true)
            }else{
                checkLogin();
            }
        }},[]);
    if(isLogged === null) return <div></div>
    return isLogged ? <Home/> : <Navigate to="/authen/login" replace={true}/>;
}

export default Main