import React from 'react'
import { Space, Badge, Menu} from 'antd'
import { IoMailUnreadOutline } from "react-icons/io5";
import { RiNotification3Line } from "react-icons/ri";
function TopHeaderNotification() {
  return (
    <div>
        <Space align='right' style={{alignItems:"center"}}>
            <div className="header-icon-container">
                <div>
                    <span>
                        <Badge count={5} size="small">
                            <IoMailUnreadOutline className="header-icon"/>
                        </Badge>
                    </span>
                    <span>
                        <Badge count={5} size="small">
                            <RiNotification3Line className="header-icon"/>
                        </Badge>
                    </span>
                    <span>
                    </span>
                </div>
            </div>
        </Space>
    </div>
  )
}

export default TopHeaderNotification