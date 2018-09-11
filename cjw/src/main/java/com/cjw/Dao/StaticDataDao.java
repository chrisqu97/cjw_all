package com.cjw.Dao;

import com.cjw.Dao.Entity.StaticData;
import com.cjw.Dao.Entity.StaticDataExample;
import com.cjw.Dao.Mapper.StaticDataMapper;
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

    public List<StaticData> findByTypeCode(String typeCode){
        StaticDataExample example=new StaticDataExample();
        example.createCriteria()
                .andTypeCodeEqualTo(typeCode)
                .andStateEqualTo(Constant.STATE.VALUE);
        List<StaticData> staticDatas = staticDataMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(staticDatas)){
            return staticDatas;
        }else{
            return null;
        }
    }
}
