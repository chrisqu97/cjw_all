package com.cjw.dao;

import com.cjw.dao.entity.PositionInterest;
import com.cjw.dao.mapper.PositionInterestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qucl
 * @date 2018/10/30 15:12
 */
@Component
public class PositionInterestDao {
    @Autowired
    private PositionInterestMapper positionInterestMapper;

    public void add(PositionInterest positionInterest) {
        positionInterestMapper.insert(positionInterest);
    }
}
