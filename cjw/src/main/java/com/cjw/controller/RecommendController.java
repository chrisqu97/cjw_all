package com.cjw.controller;

import com.cjw.async.RecommendTask;
import com.cjw.pojo.RecommendPojo;
import com.cjw.pojo.ResultPojo;
import com.cjw.recommend.BaseRecommender;
import com.cjw.service.RecommendService;
import com.cjw.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qucl
 * @date 2018/11/12 17:54
 */
@RestController
@RequestMapping("/Recommend")
public class RecommendController {
    @Autowired
    private RecommendService recommendService;
    @Autowired
    private RecommendTask recommendTask;

    /**
     * 推荐（默认为slopeOne）
     *
     * @param recommendPojo
     * @return
     */
    @RequestMapping(value = "/createRecommend", method = RequestMethod.POST)
    public ResultPojo createRecommend(@RequestBody RecommendPojo recommendPojo) {
        ResultPojo resultPojo = new ResultPojo();

        if (recommendPojo.getUserId() == null) {
            resultPojo.setMessage("用户id为空");
            return resultPojo;
        }
        if (recommendPojo.getSize() == null) {
            resultPojo.setMessage("推荐数为空");
            return resultPojo;
        }

        //异步任务 推荐时间过长
        recommendTask.createRecommend(recommendPojo.getUserId(), recommendPojo.getSize());

        resultPojo.setSuccess(true);
        resultPojo.setMessage("推荐职位正在生成中 请等待");
        return resultPojo;
    }

    /**
     * 获取推荐的职位id列表
     *
     * @param recommendPojo
     * @return
     */
    @RequestMapping(value = "/getRecommend", method = RequestMethod.POST)
    public ResultPojo getRecommend(@RequestBody RecommendPojo recommendPojo) {
        ResultPojo resultPojo = new ResultPojo();

        if (recommendPojo.getUserId() == null) {
            resultPojo.setMessage("用户id为空");
            return resultPojo;
        }

        List<Integer> positonIds = recommendService.getRecommend(recommendPojo.getUserId());
        recommendPojo.setPositionIds(positonIds);

        resultPojo.setSuccess(true);
        if (CollectionUtils.isNotEmpty(positonIds)){
            resultPojo.setMessage("获取推荐的职位id列表成功");
        }else{
            resultPojo.setMessage("数据生成中请等待");
        }
        resultPojo.setData(recommendPojo);
        return resultPojo;
    }
}
