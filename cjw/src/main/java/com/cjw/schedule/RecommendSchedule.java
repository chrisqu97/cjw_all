package com.cjw.schedule;

import com.cjw.recommend.BaseRecommender;
import com.cjw.service.RecommendService;
import com.cjw.service.UserService;
import com.cjw.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author qucl
 * @date 2018/11/13 10:46
 */
@Component
public class RecommendSchedule {
    @Autowired
    private UserService userService;
    @Autowired
    private RecommendService recommendService;
    /**
     * 推荐数
     */
    private Integer size = 3;

    /**
     * 每天0点更新推荐信息
     */
    @Scheduled(cron = "0 0 0 * * ? *")
    public void updateUserRecommend() {
        List<Integer> allUserIds = userService.getAllUserIds();
        if (CollectionUtils.isNotEmpty(allUserIds)) {
            for (Integer userId : allUserIds) {
                BaseRecommender recommender = recommendService.slopOneRecommend(userId, size);
                recommendService.addList(userId, recommender.getRecommendations());
            }
        }
    }
}
