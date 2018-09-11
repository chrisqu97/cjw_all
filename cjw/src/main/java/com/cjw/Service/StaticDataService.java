package com.cjw.Service;

import com.cjw.Dao.Entity.StaticData;
import com.cjw.Dao.StaticDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaticDataService {
    @Autowired
    private StaticDataDao staticDataDao;

    public Map<String,String> findByTypeCode(String typeCode){
        List<StaticData> staticDatas = staticDataDao.findByTypeCode(typeCode);
        Map<String,String> map=new HashMap<>();
        for(StaticData data:staticDatas){
            map.put(data.getTypeName(),data.getTypeValue());
        }
        return map;
    }
}
