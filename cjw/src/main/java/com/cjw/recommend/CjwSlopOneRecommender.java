package com.cjw.recommend;

import lombok.extern.slf4j.Slf4j;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;

import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.recommender.Recommender;

/**
 * @author qucl
 * @date 2018/11/12 15:04
 */
@Slf4j
public class CjwSlopOneRecommender extends BaseRecommender {
    public CjwSlopOneRecommender(Integer userId, Integer size, JDBCDataModel model) {
        super(userId, size, model);
    }

    @Override
    public void build() {
        try {
            SlopeOneRecommender slopeonemodel = new SlopeOneRecommender(this.getModel());

            Recommender recommender = new CachingRecommender(slopeonemodel);

            this.setRecommendations(recommender.recommend(this.getUserId(), this.getSize()));

        } catch (TasteException e) {
            log.error(e.getMessage(), e);
        }
    }
}
