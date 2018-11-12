package com.cjw.recommend;

import lombok.extern.slf4j.Slf4j;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 * @author qucl
 * @date 2018/11/12 15:24
 */
@Slf4j
public class CjwUserBaseRecommender extends BaseRecommender {
    public CjwUserBaseRecommender(Integer userId, Integer size, JDBCDataModel model) {
        super(userId, size, model);
    }

    @Override
    public void build() {
        try {
            UserSimilarity similarity = new PearsonCorrelationSimilarity(this.getModel());

            UserNeighborhood neighborhood = new NearestNUserNeighborhood(3, similarity, this.getModel());

            Recommender recommender = new GenericUserBasedRecommender(this.getModel(), neighborhood, similarity);

            this.setRecommendations(recommender.recommend(this.getUserId(), this.getSize()));

        } catch (TasteException e) {
            log.error(e.getMessage(), e);
        }
    }
}
