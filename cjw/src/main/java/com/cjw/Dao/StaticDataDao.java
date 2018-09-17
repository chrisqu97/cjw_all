package com.cjw.dao;

import com.cjw.dao.entity.StaticData;
import com.cjw.dao.entity.StaticDataExample;
import com.cjw.dao.mapper.StaticDataMapper;
import com.cjw.common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class StaticDataDao {
    @Autowired
    private StaticDataMapper staticDataMapper;

//    public StaticData findById(Integer id){
//        return staticDataMapper.selectByPrimaryKey(id);
//    }

    public List<StaticData> findByTypeCode(String typeCode) {
        StaticDataExample example = new StaticDataExample();
        example.createCriteria()
                .andTypeCodeEqualTo(typeCode)
                .andStateEqualTo(Constant.STATE.VALUE);
        List<StaticData> staticDatas = staticDataMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(staticDatas)) {
            return staticDatas;
        } else {
            return null;
        }
    }
}
