package com.cjw.service;

import com.alibaba.fastjson.JSON;
import com.cjw.common.Constant;
import com.cjw.dao.CompanyDao;
import com.cjw.dao.PositionDao;
import com.cjw.dao.UserDao;
import com.cjw.dao.entity.Position;
import com.cjw.pojo.PlacePojo;
import com.cjw.pojo.PositionPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {
    @Autowired
    private PositionDao positionDao;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private UserDao userDao;

    public PositionPojo add(PositionPojo positionPojo) {
        Position position = new Position();
        position.setPositionName(positionPojo.getPositionName());
        position.setPositionType(positionPojo.getPositionType());
        PlacePojo placePojo = new PlacePojo();
        placePojo.setProvince(positionPojo.getPlace().get(0));
        placePojo.setCity(positionPojo.getPlace().get(1));
        placePojo.setArea(positionPojo.getPlace().get(2));
        position.setPlace(JSON.toJSONString(placePojo));
        position.setEducationalRequirements(positionPojo.getEducationalRequirements());
        position.setExperienceRequirements(positionPojo.getExperienceRequirements());
        position.setSalary(positionPojo.getSalary());
        position.setDescription(positionPojo.getDescription());
        position.setCompanyId(positionPojo.getCompanyId());
        position.setUserId(positionPojo.getUserId());
        position.setState(Constant.STATE.VALUE);
        positionDao.add(position);
        positionPojo.setPositionId(position.getPositionId());
        return positionPojo;
    }

    public PositionPojo findById(Integer positionId) {
        Position position = positionDao.findById(positionId);
        if (position != null) {
            PositionPojo positionPojo = new PositionPojo();
            positionPojo.setPositionId(position.getPositionId());
            positionPojo.setPositionName(position.getPositionName());
            positionPojo.setPositionType(position.getPositionType());
        }
        return null;
    }
}
