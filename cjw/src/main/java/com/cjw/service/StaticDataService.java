package com.cjw.service;

import com.cjw.dao.entity.StaticData;
import com.cjw.dao.StaticDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaticDataService {
    @Autowired
    private StaticDataDao staticDataDao;

    public Map<String, String> findByTypeCode(String typeCode) {
        List<StaticData> staticDatas = staticDataDao.findByTypeCode(typeCode);
        Map<String, String> map = new HashMap(staticDatas.size());
        for (StaticData data : staticDatas) {
            map.put(data.getTypeName(), data.getTypeValue());
        }
        return map;
    }
}
