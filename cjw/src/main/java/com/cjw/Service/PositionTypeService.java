package com.cjw.service;

import com.cjw.dao.PositionTypeDao;
import com.cjw.dao.entity.PositionType;
import com.cjw.pojo.PositionTypePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PositionTypeService {
    @Autowired
    private PositionTypeDao positionTypeDao;
    private static Map<String, String> allType;

    public PositionTypePojo findOneType(Integer id) {
        return positionTypeDao.findOneType(id);
    }

    public List<PositionTypePojo> findAllType() {
        return positionTypeDao.findAllType();
    }

    public Map<String, String> findAll() {
        List<PositionType> all = positionTypeDao.findAll();
        if (!CollectionUtils.isEmpty(all)) {
            Map<String, String> types = new HashMap<>(all.size());
            for (PositionType type : all) {
                types.put(type.getPositionTypeId() + "", type.getPositionTypeName());
            }
            return types;
        }
        return null;
    }
}
