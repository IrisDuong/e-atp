import React,{useState, useEffect} from 'react'
import {Space, Button, Flex, Typography} from 'antd';
import {useDispatch,useSelector} from "react-redux";
import { MdAddCircle } from "react-icons/md";
import {IoRemoveCircleSharp  } from "react-icons/io5";
import CommonCodeSearch from './CommonCodeSearch';
import CommonCodeTable from './CommonCodeTable';
function CommonCode() {
    const {listCommonCodes} = useSelector(state=>state.commonCodeStore)
    const [btnSavingDisabled, setbtnSavingDisabled] = useState(true);

    useEffect(()=>{
        if(listCommonCodes && listCommonCodes.length > 0){
            setbtnSavingDisabled(false)
        }else{
            setbtnSavingDisabled(true);
        }
    },[listCommonCodes])
  return (
      <>
          <Flex justify="space-between" align="center" className="mb-4">
              <CommonCodeSearch></CommonCodeSearch>
          </Flex>
          <Flex
              vertical={true}
              gap={25}
          // align="center" className="mb-4"
          >
              <CommonCodeTable/>
          </Flex>
          <Flex justify="space-between" align="center" className="mb-4">
              <Space style={{ marginTop: 16 }}>
                  <Button icon={<MdAddCircle/>} className='new' >New</Button>
                  <Button disabled={btnSavingDisabled} icon={<IoRemoveCircleSharp/>} className='delete'>Delete</Button>
              </Space>
          </Flex>
      </>
  )
}

export default CommonCode