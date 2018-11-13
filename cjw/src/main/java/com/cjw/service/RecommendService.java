package com.cjw.service;

import com.cjw.common.Constant;
import com.cjw.dao.PositionDao;
import com.cjw.dao.PositionRecommendDao;
import com.cjw.dao.entity.PositionRecommend;
import com.cjw.recommend.BaseRecommender;

import com.cjw.recommend.CjwItemBaseRecommender;
import com.cjw.recommend.CjwSlopOneRecommender;
import com.cjw.recommend.CjwUserBaseRecommender;
import com.cjw.utils.CollectionUtils;
import com.cjw.utils.RecommendUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author qucl
 * @date 2018/11/12 16:18
 */
@Service
@Slf4j
public class RecommendService {
    @Autowired
    private RecommendUtils recommendUtils;
    @Autowired
    private PositionRecommendDao positionRecommendDao;

    /**
     * slopOne
     *
     * @param userId
     * @param size
     */
    public BaseRecommender slopOneRecommend(Integer userId, Integer size) {
        BaseRecommender recommender = null;
        try {
            recommender = new CjwSlopOneRecommender(userId, size, recommendUtils.getModel());
            recommender.build();
            return recommender;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return recommender;
    }

    /**
     * 以用户为基础
     *
     * @param userId
     * @param size
     */
    public BaseRecommender userBaseRecommend(Integer userId, Integer size) {
        BaseRecommender recommender = null;
        try {
            recommender = new CjwUserBaseRecommender(userId, size, recommendUtils.getModel());
            recommender.build();
            return recommender;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return recommender;
    }

    /**
     * 以职位为基础
     *
     * @param userId
     * @param size
     */
    public BaseRecommender itemBaseRecommend(Integer userId, Integer size) {
        BaseRecommender recommender = null;
        try {
            recommender = new CjwItemBaseRecommender(userId, size, recommendUtils.getModel());
            recommender.build();
            return recommender;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return recommender;
    }

    /**
     * 批量添加
     *
     * @param userId
     * @param items
     */
    public void addList(Integer userId, List<RecommendedItem> items) {
        if (CollectionUtils.isNotEmpty(items)) {
            List<PositionRecommend> positionRecommends = positionRecommendDao.findByUserId(userId);
            if (CollectionUtils.isNotEmpty(positionRecommends)) {
                //清除已有的推荐数据
                for (PositionRecommend positionRecommend : positionRecommends) {
                    positionRecommend.setState(Constant.State.INVALUE);
                    positionRecommendDao.update(positionRecommend);
                }
            }
            for (RecommendedItem item : items) {
                PositionRecommend recommend = new PositionRecommend();
                recommend.setUserId(userId);
                recommend.setPositionId((int) item.getItemID());
                recommend.setState(Constant.State.VALUE);
                recommend.setCreateTime(new Date(System.currentTimeMillis()));
                positionRecommendDao.add(recommend);
            }

        }
    }

    /**
     * 获取推荐的职位id列表
     *
     * @param userId
     * @return
     */
    public List<Integer> getRecommend(Integer userId) {
        return positionRecommendDao.findForPositionIdsByUserId(userId);
    }
}
