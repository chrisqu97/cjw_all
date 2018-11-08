package com.cjw.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
import com.cjw.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.mahout.math.jet.random.Poisson;
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
            positionPojo.setSkillDescription(position.getSkillDescription());
            positionPojo.setEducationBackground(position.getEducationBackground());
            if (StringUtils.isNotEmpty(position.getWelfare())) {
                positionPojo.setWelfare(JSON.parseArray(position.getWelfare(), String.class));
            }
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
            setPositionPojos(searchPojo, positions);
        }
        return searchPojo;
    }

    private Map<String, String> getUserMap() {
        List<User> allUser = userDao.getUserIdAndUserName();
        Map<String, String> users = new HashMap<>(allUser.size());
        if (CollectionUtils.isNotEmpty(allUser)) {
            for (User user : allUser) {
                users.put(user.getUserId() + "", user.getUserName());
            }
        }
        return users;
    }

    public PositionSearchPojo findByPositionName(PositionSearchPojo searchPojo) {
        PageHelper.startPage(searchPojo.getPageNum(), searchPojo.getPageSize());
        List<Position> positions = positionDao.findByPositionName(searchPojo.getPositionName());
        if (CollectionUtils.isNotEmpty(positions)) {
            setPositionPojos(searchPojo, positions);
        }
        return searchPojo;
    }

    private void setPositionPojos(PositionSearchPojo searchPojo, List<Position> positions) {
        Map<String, String> users = getUserMap();
        SimpleDateFormat sf = DateUtils.getDateFormat();
        List<PositionPojo> positionPojos = new ArrayList<>();
        PageInfo pageInfo = new PageInfo<>(positions, searchPojo.getPageSize());

        createPositionPojo(positions, users, sf, positionPojos);

        searchPojo.setPositionPojos(positionPojos);
        searchPojo.setTotalCount((int) pageInfo.getTotal());
        searchPojo.setTotalPage(pageInfo.getPages());
    }

    private void createPositionPojo(List<Position> positions, Map<String, String> users, SimpleDateFormat sf, List<PositionPojo> positionPojos) {
        for (Position position : positions) {
            PositionPojo positionPojo = new PositionPojo();
            positionPojo.setPositionId(position.getPositionId());
            positionPojo.setPositionName(position.getPositionName());
            positionPojo.setPlace(JSON.parseArray(position.getPlace(), String.class));
            positionPojo.setSalary(position.getSalary());
            positionPojo.setCreateTime(sf.format(position.getCreateTime()));
            positionPojo.setUserId(position.getUserId());
            positionPojo.setUserName(users.get(position.getUserId() + ""));
            positionPojo.setWelfare(JSON.parseArray(position.getWelfare(), String.class));
            positionPojo.setEducationalRequirements(position.getEducationalRequirements());
            positionPojos.add(positionPojo);
        }
    }

    public List<String> getPositionName(String positionName) {
        List<String> list = positionDao.getPositionName(positionName);
        if (CollectionUtils.isEmpty(list)) {
            list = new ArrayList<>();
        }
        return list;
    }

}
