import React,{useEffect, useState} from 'react'
import {Dropdown, Typography, Avatar, Space} from "antd";
import {useSelector,useDispatch} from "react-redux";
import { MdContactSupport } from "react-icons/md";
import { IoIosArrowDown } from "react-icons/io";
import { FaUserGear } from "react-icons/fa6";
import { IoLogOutSharp } from "react-icons/io5";
import { doLogout } from '../../../services/auth/auth.service';
const {Text} = Typography;
function AuthenProfile() {
    /** state */
    const {authenticatedUser} = useSelector(state=>state.authStore)
    const [authenProfile, setAuthenProfile] = useState({
                name: "",
                email: "",
                avatar:""

    })
    const authenProfileActions = [
        {
            key:"profile",
            label:"Hồ sơ",
            icon:<FaUserGear/>
        },
        {
            key:"support",
            label:"Trợ giúp",
            icon:<MdContactSupport/>
        },
        {
            key:"logout",
            label:"Đăng xuất",
            icon:<IoLogOutSharp/>
        }
    ]

    const handleChangeActions = ({key}) =>{
        switch(key){
            case "logout":
                doLogout();
            default: console.log("authen profile actions");
        }
    }
    useEffect(()=>{
        const splittedName =  authenticatedUser.name.split(" ");
        const lastName = splittedName[splittedName.length-1].trim().substring(0,1);
        const avatar =  authenticatedUser.avatar ? authenticatedUser.avatar :lastName;
        setAuthenProfile({
                name: authenticatedUser.name,
                email: authenticatedUser.email,
                avatar
        })
    },authenticatedUser)
  return (
    <div className='authen-profile'>
            <Avatar>{authenProfile.avatar}</Avatar>
            <Dropdown menu={{items:authenProfileActions,onClick:handleChangeActions}}>
                <div>
                    <Text>{authenProfile.name}</Text>
                    <IoIosArrowDown/>
                </div>
            </Dropdown>
    </div>
  )
}

export default AuthenProfile