package com.cjw.Dao;

import com.cjw.Dao.Entity.Position;
import com.cjw.Dao.Entity.PositionExample;
import com.cjw.Dao.Mapper.PositionMapper;
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
}
