package com.cjw.service;

import com.alibaba.fastjson.JSON;
import com.cjw.common.Constant;
import com.cjw.dao.CompanyDao;
import com.cjw.dao.PositionDao;
import com.cjw.dao.UserDao;
import com.cjw.dao.entity.Company;
import com.cjw.dao.entity.Position;
import com.cjw.dao.entity.User;
import com.cjw.pojo.PositionPojo;
import com.cjw.pojo.PositionSearchPojo;
import com.cjw.utils.CollectionUtils;
import com.cjw.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

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
        position.setPlace(JSON.toJSONString(positionPojo.getPlace()));
        position.setEducationalRequirements(positionPojo.getEducationalRequirements());
        position.setExperienceRequirements(positionPojo.getExperienceRequirements());
        position.setSalary(positionPojo.getSalary());
        position.setDescription(positionPojo.getDescription());
        position.setCompanyId(positionPojo.getCompanyId());
        position.setUserId(positionPojo.getUserId());
        position.setState(Constant.State.VALUE);
        Date date = new Date();
        position.setCreateTime(date);
        position.setUpdateTime(date);
        positionDao.add(position);
        positionPojo.setPositionId(position.getPositionId());
        return positionPojo;
    }

    public PositionPojo findById(Integer positionId, Map<String, String> types) {
        Position position = positionDao.findById(positionId);
        if (position != null) {
            PositionPojo positionPojo = new PositionPojo();
            positionPojo.setPositionId(position.getPositionId());
            positionPojo.setPositionName(position.getPositionName());
            positionPojo.setPositionType(position.getPositionType());
            positionPojo.setPositionTypeName(types.get(position.getPositionType() + ""));
            positionPojo.setPlace(JSON.parseArray(position.getPlace(), String.class));
            positionPojo.setEducationalRequirements(position.getEducationalRequirements());
            positionPojo.setExperienceRequirements(position.getExperienceRequirements());
            positionPojo.setSalary(position.getSalary());
            positionPojo.setDescription(position.getDescription());
            if (position.getCompanyId() != null) {
                positionPojo.setCompanyId(position.getCompanyId());
                Company company = companyDao.findById(position.getCompanyId());
                positionPojo.setCompanyName(company.getCompanyName());
            }
            if (position.getUserId() != null) {
                positionPojo.setUserId(position.getUserId());
                User user = userDao.findById(position.getUserId());
                positionPojo.setUserName(user.getUserName());
            }
            try {
                SimpleDateFormat sf = DateUtils.getDateTimeFormat();
                positionPojo.setCreateTime(sf.format(position.getCreateTime()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return positionPojo;
        }
        return null;
    }

    public PositionSearchPojo findByCompanyId(PositionSearchPojo searchPojo) {
        PageHelper.startPage(searchPojo.getPageNum(), searchPojo.getPageSize());
        List<Position> positions = positionDao.findByCompanyId(searchPojo.getCompanyId());
        if (CollectionUtils.isNotEmpty(positions)) {
            List<User> allUser = userDao.findAll();
            Map<String, String> users = new HashMap<>();
            if (CollectionUtils.isNotEmpty(allUser)) {
                for (User user : allUser) {
                    users.put(user.getUserId() + "", user.getUserName());
                }
            }
            Company company = companyDao.findById(searchPojo.getCompanyId());
            SimpleDateFormat sf = DateUtils.getDateTimeFormat();
            List<PositionPojo> positionPojos = new ArrayList<>();
            PageInfo pageInfo = new PageInfo<>(positions, searchPojo.getPageSize());
            for (Position position : positions) {
                PositionPojo positionPojo = new PositionPojo();
                positionPojo.setPositionId(position.getPositionId());
                positionPojo.setPositionName(position.getPositionName());
                positionPojo.setPlace(JSON.parseArray(position.getPlace(), String.class));
                positionPojo.setSalary(position.getSalary());
                positionPojo.setCreateTime(sf.format(position.getCreateTime()));
                positionPojo.setUserId(position.getUserId());
                positionPojo.setUserName(users.get(position.getUserId() + ""));
                positionPojos.add(positionPojo);
            }
            searchPojo.setPositionPojos(positionPojos);
            searchPojo.setTotalCount((int) pageInfo.getTotal());
            searchPojo.setTotalPage(pageInfo.getPages());
        }
        return searchPojo;
    }
}
