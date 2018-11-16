package com.cjw.schedule;

import com.cjw.recommend.BaseRecommender;
import com.cjw.service.RecommendService;
import com.cjw.service.UserService;
import com.cjw.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * @author qucl
 * @date 2018/11/13 10:46
 */
@Configuration
public class RecommendSchedule{
    @Autowired
    private UserService userService;
    @Autowired
    private RecommendService recommendService;
    /**
     * 推荐数
     */
    private final static Integer SIZE = 3;

    /**
     * 每天0点更新推荐信息
     */
    @Scheduled(cron = "0 0 0 1/1 * ? ")
    public void updateUserRecommend() {
        List<Integer> allUserIds = userService.getAllUserIds();
        if (CollectionUtils.isNotEmpty(allUserIds)) {
            for (Integer userId : allUserIds) {
                BaseRecommender recommender = recommendService.slopOneRecommend(userId, SIZE);
                recommendService.addList(userId, recommender.getRecommendations());
            }
        }
    }

}
