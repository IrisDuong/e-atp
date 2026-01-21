import React from 'react'
import {Row,Col,Flex, Typography} from "antd";
import AuthenProfile from './AuthenProfile';
import TopHeaderNotification from './TopHeaderNotification';
import MultiLanguage from './MultiLanguage';
import TopLogo from "../../../public/images/e-atp-header-logo-2.png"
function TopHeader() {
  
  return (
    <Flex className='top-header-container'>
        <div style={{width:'18.5%'}}><img src={TopLogo} className='top-header-logo'/><Typography.Text>Đồng hành kiến tạo</Typography.Text></div>
        <div style={{width:'81.5%'}}>
          <Flex justify='end'>
              <div style={{width:'30%'}}><TopHeaderNotification/></div>
              <div style={{width:'12%',display:"flex",alignItems:"center"}}><MultiLanguage/></div>
              <div style={{width:'18%',display:"flex",alignItems:"center"}}><AuthenProfile/></div>
          </Flex>
        </div>
    </Flex>
  )
}

export default TopHeader