import React from 'react';
import { Tabs , Typography, Flex, Row, Col, Select} from 'antd';
import WrapperTabs from '../../common/WrapperTabs';
import CommonCode from './commonCode';
import GeneralCode from './generalCode';

function BaseData() {
    const baseDataTabs = [
      { key: 'commonCode', label: 'Common Code', children: <CommonCode /> },
      { key: 'generalCode', label: 'General Code', children: <GeneralCode /> },
    ];
  return (
    <div className='base-data content-page'>
      <WrapperTabs items={baseDataTabs}></WrapperTabs>
    </div>
  )
}

export default BaseData