import React from 'react'
import {Layout} from "antd";
import MainMenu from './menu/MainMenu';
import TopHeader from './topHeader/TopHeader';
const {Header,Content,Sider} = Layout;
function Home() {
  return (
    <Layout className='home'>
        <Header className='top-header'><TopHeader/></Header>
        {/* <TopHeader/> */}
        <Layout>
            <Sider 
              width={350} className='sider'><MainMenu/></Sider>
            <Content className='content'>content</Content>
        </Layout>
    </Layout>
  )
}

export default Home