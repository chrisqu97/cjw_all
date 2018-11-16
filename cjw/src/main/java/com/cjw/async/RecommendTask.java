package com.cjw.async;

import com.cjw.recommend.BaseRecommender;
import com.cjw.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qucl
 * @date 2018/11/12 21:11
 */
@Component
public class RecommendTask {
    @Autowired
    private RecommendService recommendService;

    @Async
    @Transactional(rollbackFor = Exception.class)
    public void createRecommend(Integer userId,Integer size){
        BaseRecommender recommend = recommendService.slopOneRecommend(userId, size);
        recommendService.addList(userId, recommend.getRecommendations());
    }
}
