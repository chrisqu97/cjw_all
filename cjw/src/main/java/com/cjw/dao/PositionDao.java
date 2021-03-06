package com.cjw.dao;

import com.cjw.common.Constant;
import com.cjw.dao.entity.Position;
import com.cjw.dao.entity.PositionExample;
import com.cjw.dao.mapper.PositionMapper;
import com.cjw.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
                .andPositionIdEqualTo(id)
                .andStateEqualTo(Constant.State.VALUE);
        List<Position> positions = positionMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(positions)) {
            return positions.get(0);
        }
        return null;
    }

    public List<Position> findByCompanyId(Integer companyId) {
        PositionExample example = new PositionExample();
        example.createCriteria()
                .andCompanyIdEqualTo(companyId)
                .andStateEqualTo(Constant.State.VALUE);
        example.setOrderByClause("position_id desc");
        return positionMapper.selectByExample(example);
    }

    public List<Position> findByPositionName(String positionName) {
        PositionExample example = new PositionExample();
        example.createCriteria()
                .andPositionNameLike(positionName + "%")
                .andStateEqualTo(Constant.State.VALUE);
        example.setOrderByClause("position_id desc");
        return positionMapper.selectByExample(example);
    }

    public List<String> getPositionName(String positionName) {
        return positionMapper.getPositionName(positionName + "%");
    }

    public List<Position> findByPositionIds(List<Integer> positionIds) {
        if (CollectionUtils.isNotEmpty(positionIds)) {
            PositionExample example = new PositionExample();
            example.createCriteria()
                    .andPositionIdIn(positionIds)
                    .andStateEqualTo(Constant.State.VALUE);
            example.setOrderByClause("position_id desc");
            return positionMapper.selectByExample(example);
        }
        return new ArrayList<>();
    }

    public Integer countAll() {
        PositionExample example = new PositionExample();
        example.createCriteria()
                .andStateEqualTo(Constant.State.VALUE);
        example.setOrderByClause("position_id desc");
        return positionMapper.countByExample(example);
    }

    public List<Integer> getAllPositionIdsByPositionType(Integer positionType) {
        return positionMapper.getAllPositionIdsByPositionType(positionType);
    }

    public List<Integer> getAllPositionIds() {
        return positionMapper.getAllPositionIds();
    }
}
