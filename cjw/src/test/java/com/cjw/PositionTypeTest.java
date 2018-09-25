package com.cjw;

import com.cjw.common.Constant;
import com.cjw.dao.PositionTypeDao;
import com.cjw.dao.entity.PositionType;
import com.cjw.dao.mapper.PositionMapper;
import com.cjw.dao.mapper.PositionTypeMapper;
import com.cjw.pojo.PositionTypePojo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PositionTypeTest extends TestBase {
    @Autowired
    private PositionTypeDao positionTypeDao;
    @Autowired
    private PositionTypeMapper positionTypeMapper;

    @Test
    public void fun() {
        PositionType positionType = new PositionType();
        positionType.setPositionTypeName("类型三");
//        positionType.setParent(0);
        positionType.setState(Constant.STATE.VALUE);
        positionTypeDao.add(positionType);
        System.out.println(positionType);
    }

    @Test
    public void fun2() {
        List<PositionTypePojo> all = positionTypeMapper.findAllType();
        System.out.println(all);
    }

    @Test
    public void fun3() {
        PositionTypePojo one = positionTypeMapper.findOneType(3);
        System.out.println(one);
    }
}
