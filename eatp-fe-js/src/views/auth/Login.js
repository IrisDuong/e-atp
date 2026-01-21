import React from 'react'
import {Row,Col,Flex, Typography,Form, Input, Button, Card, Divider} from "antd";
import { FcGoogle } from "react-icons/fc";
import { GiPowerButton } from "react-icons/gi";
import ATP_LOGO from "../../public/images/atp_logo.jpg"
import { doLogin } from '../../services/auth/auth.service';
const {Text, Title} = Typography;
function Login() {
  return (
    <div className="login-container">
      <Flex vertical="horizontal">
          <section className="introduction">
            {/* <section className="logo-container">
                <div>
                </div>
            </section> */}
            
                  <img src={ATP_LOGO} width={160} height={160}/>
                  <Title className='title' level={3} strong>Hệ thống quản lý nội bộ <Text> e-ATP</Text></Title>
          </section>
          <section className="login-main">
            <div>
              <Flex vertical>
                  <section className="basic">
                    <div className="login-form">
                      <Card style={{ width: 360 }}>
                        <Form
                          layout="vertical"
                          // onFinish={onFinish}
                        >
                          <Form.Item
                            label="Tài khoản"
                            name="userName"
                            rules={[
                              { required: true, message: 'Vui lòng nhập Tài khoản' },
                              { type: 'userName', message: 'Tài khoản không hợp lệ' },
                            ]}
                          >
                            <Input placeholder="Tài khoản người dùng" />
                          </Form.Item>

                          <Form.Item
                            label="Mật khẩu"
                            name="password"
                            rules={[
                              { required: true, message: 'Vui lòng nhập mật khẩu' },
                            ]}
                          >
                            <Input.Password placeholder="Nhập mật khẩu" />
                          </Form.Item>

                          <Form.Item>
                            <Button
                              icon={<GiPowerButton/>}
                              htmlType="submit"
                              block
                            >
                              Đăng nhập
                            </Button>
                          </Form.Item>
                        </Form>
                      </Card>
                    </div>
                  </section>
                  <Divider>Hoặc</Divider>
                  <section className="sso">
                  
                          <Button
                            icon={<FcGoogle/>}
                            block
                            onClick={()=>{doLogin()}}
                          >
                            Đăng nhập với Google
                          </Button>
                </section>
              </Flex>
            </div>
          </section>
      </Flex>
    </div>
  )
}

export default Login