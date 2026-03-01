import React, {useState} from 'react'
import { Tabs , Flex,} from 'antd';

function WrapperTabs({items, onChange}) {
  return (
      <Flex gap="middle" vertical>
          <Tabs
            className="page-tabs"
            items={items}
          >
          </Tabs>
      </Flex>
  )
}

export default WrapperTabs