package com.cjw.dao;

import com.cjw.common.Constant;
import com.cjw.dao.entity.PositionType;
import com.cjw.dao.entity.PositionTypeExample;
import com.cjw.dao.mapper.PositionTypeMapper;
import com.cjw.pojo.PositionTypePojo;
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

    public List<PositionType> findAll() {
        PositionTypeExample example = new PositionTypeExample();
        example.setOrderByClause("position_type_id desc");
        List<PositionType> positionTypes = positionTypeMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(positionTypes)) {
            return positionTypes;
        }
        return null;
    }

    public List<PositionTypePojo> findAllType() {
        List<PositionTypePojo> allType = positionTypeMapper.findAllType();
        if (!CollectionUtils.isEmpty(allType)) {
            return allType;
        }
        return null;
    }

    public PositionTypePojo findOneType(Integer id) {
        PositionTypePojo oneType = positionTypeMapper.findOneType(id);
        if (oneType != null) {
            return oneType;
        }
        return null;
    }

}
