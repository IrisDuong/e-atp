import React,{ useState} from 'react'
import {useDispatch,useSelector} from "react-redux";
import {Form, Button} from 'antd';
import { RiSearch2Line } from "react-icons/ri";
import CustomFormItem from '../../../common/CustomFormItem';
import {searchListCommonCode} from "../../../../services/setting/baseData/commonCode.service"
import {setListCommonCodes} from "../../../../store/setting/baseData/commonCode";
function CommonCodeSearch() {
      const dispatch = useDispatch();
      const codeTypes = [
          { value: 'M', label: 'Multi' },
          { value: 'S', label: 'Single' }
      ];
      const groupCodes = [
          { value: 'sys', label: 'System' },
          { value: 'mem', label: 'Member' },
          { value: 'stock', label: 'Stock' },
          { value: 'fin', label: 'Financial' },
          { value: 'prd', label: 'Product' },
      ]
      const useYns = [
          { value: 'Y', label: 'Use' },
          { value: 'N', label: 'Unuse' },
      ]
      const [searchParams, setSearchParams] = useState({
          commonCodeName: '',
          featureCodeNo: groupCodes[0].value,
          codeTypeNo: codeTypes[0].value,
          useStatusNo: useYns[0].value
      });

      /** events */
      const handleFormItemChange = e =>{
          const {name,value} = e;
          setSearchParams(prevState=>{
            return {
              ...prevState,[name]:value
            }
          })
      }

      const handleSearch = async () => {
        let result = await searchListCommonCode(searchParams);
        if(result){
          dispatch(setListCommonCodes(result))
        }
      }
  return (
        <>
          <Form layout="inline" className='search-form'>
              <CustomFormItem
                name="featureCodeNo"
                type="select"
                label="Features Group"
                defaultValue={searchParams.featureCodeNo}
                onChange={handleFormItemChange}
                data={groupCodes}
              />
              <CustomFormItem
                name="commonCodeName"
                type="input"
                label="Common Code Name"
                value={searchParams.commonCodeName}
                onChange={handleFormItemChange}
                placeholder="Input Common Name"
              />
              <CustomFormItem
                name="codeTypeNo"
                type="select"
                label="Type"
                defaultValue={searchParams.codeTypeNo}
                onChange={handleFormItemChange}
                data={codeTypes}
              />
              <CustomFormItem
                name="useStatusNo"
                type="select"
                label="Use Y/N"
                defaultValue={searchParams.useStatusNo}
                onChange={handleFormItemChange}
                data={useYns}
              />
            <Form.Item>
              <Button
                icon={<RiSearch2Line />}
                className="search"
                onClick={handleSearch}
                >
                Search
              </Button>
            </Form.Item>
          </Form>
        </>
  )
}

export default CommonCodeSearch