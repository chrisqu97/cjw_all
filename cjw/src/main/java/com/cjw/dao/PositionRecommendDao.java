package com.cjw.dao;

import com.cjw.common.Constant;
import com.cjw.dao.entity.PositionRecommend;
import com.cjw.dao.entity.PositionRecommendExample;
import com.cjw.dao.mapper.PositionRecommendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author qucl
 * @date 2018/11/12 16:10
 */
@Component
public class PositionRecommendDao {
    @Autowired
    private PositionRecommendMapper positionRecommendMapper;

    public void add(PositionRecommend positionRecommend) {
        positionRecommendMapper.insert(positionRecommend);
    }

    public void update(PositionRecommend positionRecommend) {
        positionRecommendMapper.updateByPrimaryKey(positionRecommend);
    }

    /**
     * 根据用户id获取职位id列表
     *
     * @param userId
     * @return
     */
    public List<Integer> findForPositionIdsByUserId(Integer userId) {
        return positionRecommendMapper.findForPositionIdsByUserId(userId);
    }

    public List<PositionRecommend> findByUserId(Integer userId) {
        PositionRecommendExample example = new PositionRecommendExample();
        example.createCriteria()
                .andUserIdEqualTo(userId)
                .andStateEqualTo(Constant.State.VALUE);
        return positionRecommendMapper.selectByExample(example);
    }
}
