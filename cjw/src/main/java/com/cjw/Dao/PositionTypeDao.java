package com.cjw.dao;

import com.cjw.common.Constant;
import com.cjw.dao.entity.PositionType;
import com.cjw.dao.entity.PositionTypeExample;
import com.cjw.dao.mapper.PositionTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class PositionTypeDao {
    @Autowired
    private PositionTypeMapper positionTypeMapper;

    public PositionType add(PositionType positionType) {
        positionTypeMapper.insert(positionType);
        return positionType;
    }

    public PositionType findById(Integer id) {
        PositionTypeExample example = new PositionTypeExample();
        example.createCriteria()
                .andPositionTypeIdEqualTo(id)
                .andStateEqualTo(Constant.STATE.VALUE);
        List<PositionType> positionTypes = positionTypeMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(positionTypes)) {
            return positionTypes.get(0);
        }
        return null;
    }

}
