package com.cjw.service;

import com.cjw.dao.entity.StaticData;
import com.cjw.dao.StaticDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StaticDataService {
    @Autowired
    private StaticDataDao staticDataDao;
    private List<StaticData> all;

    public Map<String, String> findByTypeCode(String typeCode) {
        if (this.all == null) {
            findAll();
        }
        List<StaticData> staticDatas = all.stream().filter(staticData -> staticData.getTypeCode().equals(typeCode)).collect(Collectors.toList());
        Map<String, String> map = new HashMap<>(staticDatas.size());
        for (StaticData data : staticDatas) {
            map.put(data.getTypeValue(), data.getTypeName());
        }
        return map;
    }

    private void findAll() {
        this.all = staticDataDao.findAll();
    }
}
