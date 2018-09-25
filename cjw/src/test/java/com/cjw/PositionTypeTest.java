package com.cjw;

import com.cjw.common.Constant;
import com.cjw.dao.PositionTypeDao;
import com.cjw.dao.entity.PositionType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PositionTypeTest extends TestBase {
    @Autowired
    private PositionTypeDao positionTypeDao;

    @Test
    public void fun(){
        PositionType positionType=new PositionType();
        positionType.setPositionTypeName("类型三");
//        positionType.setParent(0);
        positionType.setState(Constant.STATE.VALUE);
        positionTypeDao.add(positionType);
        System.out.println(positionType);
    }
}
