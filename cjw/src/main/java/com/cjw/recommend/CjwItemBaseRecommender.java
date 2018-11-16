package com.cjw.recommend;

import lombok.extern.slf4j.Slf4j;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

/**
 * @author qucl
 * @date 2018/11/12 14:36
 */
@Slf4j
public class CjwItemBaseRecommender extends BaseRecommender {
    public CjwItemBaseRecommender(Integer userId, Integer size, JDBCDataModel model) {
        super(userId, size, model);
    }

    @Override
    public void build() {
        try {
            ItemSimilarity similarity = new PearsonCorrelationSimilarity(this.getModel());

            Recommender recommender = new GenericItemBasedRecommender(this.getModel(), similarity);

            this.setRecommendations(recommender.recommend(this.getUserId(), this.getSize()));
        } catch (TasteException e) {
            log.error(e.getMessage(), e);
        }
    }
}
