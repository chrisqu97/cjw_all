package com.cjw.recommend;

import com.cjw.utils.CollectionUtils;
import lombok.Data;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import java.util.List;

/**
 * @author qucl
 * @date 2018/11/12 14:37
 */
@Data
public abstract class BaseRecommender {
    private Integer userId;
    private Integer size;
    private JDBCDataModel model;
    private List<RecommendedItem> recommendations;

    public BaseRecommender(Integer userId, Integer size, JDBCDataModel model) {
        this.userId = userId;
        this.size = size;
        this.model = model;
    }

    /**
     * 构造模式
     */
    public abstract void build();

    /**
     * 结果打印
     */
    public void printResult() {
        if(CollectionUtils.isNotEmpty(recommendations)){
            for(RecommendedItem item:recommendations) {
                System.out.println(item.getItemID());
            }
        }
    }
}
