package com.cjw.service;

import com.cjw.common.Constant;
import com.cjw.dao.PositionInterestDao;
import com.cjw.dao.entity.PositionInterest;
import com.cjw.pojo.PositionInterestPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author qucl
 * @date 2018/10/30 15:15
 */
@Service
public class PositionInterestService {
    @Autowired
    private PositionInterestDao positionInterestDao;

    public void add(PositionInterestPojo positionInterestPojo) {
        PositionInterest positionInterest = new PositionInterest();
        positionInterest.setUserId(positionInterestPojo.getUserId());
        positionInterest.setPositionId(positionInterestPojo.getPositionId());
        positionInterest.setPreference(positionInterestPojo.getPreference());
        positionInterest.setState(Constant.State.VALUE);
        positionInterest.setCreateTime(new Date());
        positionInterestDao.add(positionInterest);
    }
}
