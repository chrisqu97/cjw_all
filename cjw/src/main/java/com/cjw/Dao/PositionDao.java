package com.cjw.dao;

import com.cjw.dao.entity.Position;
import com.cjw.dao.entity.PositionExample;
import com.cjw.dao.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class PositionDao {
    @Autowired
    private PositionMapper positionMapper;

    public Position add(Position position) {
        positionMapper.insert(position);
        return position;
    }

    public int update(Position position) {
        return positionMapper.updateByPrimaryKey(position);
    }

    public Position findById(Integer id) {
        PositionExample example = new PositionExample();
        example.createCriteria()
                .andPositionIdEqualTo(id);
        List<Position> positions = positionMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(positions)) {
            return positions.get(0);
        }
        return null;
    }

    public List<Position> findByCompanyId(Integer companyId){
        PositionExample example = new PositionExample();
        example.createCriteria()
                .andCompanyIdEqualTo(companyId);
        example.setOrderByClause("position_id desc");
        List<Position> positions = positionMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(positions)) {
            return positions;
        }
        return null;
    }
}
