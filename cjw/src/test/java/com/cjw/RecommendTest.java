package com.cjw;

import com.cjw.recommend.BaseRecommender;
import com.cjw.recommend.CjwSlopOneRecommender;
import com.cjw.utils.RecommendUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author qucl
 * @date 2018/11/12 15:42
 */
public class RecommendTest extends TestBase {
    @Autowired
    private RecommendUtils recommendUtils;

    @Test
    public void fun() {
        try {
            BaseRecommender recommender = new CjwSlopOneRecommender(1, 3, recommendUtils.getModel());
            recommender.build();
            recommender.printResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
