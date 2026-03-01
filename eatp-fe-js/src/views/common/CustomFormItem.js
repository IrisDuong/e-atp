import React from 'react'
import { Input, Form, Select } from 'antd';

function CustomFormItem({type,name,label,data,defaultValue,placeholder,onChange,iconEl}) {
    const handleChange = e =>{
        let changedValue = e;
        if(Object.hasOwn(e,"target") && e.target instanceof HTMLElement){
            changedValue = e.target.value;
        }
        return onChange({name,value:changedValue});
    }
    const formItem = ()=>{
        switch(type){
            case "select":
                return(
                    <Form.Item label={label}>
                        <Select
                            name={name}
                            defaultValue={defaultValue}
                            onChange={handleChange}
                        >
                            {
                                data.map(item=>(<Select.Option key={item.value} value={item.value}>{item.label}</Select.Option>))
                            }
                        </Select>
                    </Form.Item>
                );
                break;
            case "basic-input":
                return(
                    <Form.Item label={label}>
                        <Input
                            name={name}
                            placeholder={placeholder}
                            value={data}
                            onChange={handleChange}
                        >
                        </Input>
                    </Form.Item>
                )
        }
    }
  return formItem();
}

export default CustomFormItem;