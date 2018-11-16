package com.cjw.dao.mapper;

import com.cjw.dao.entity.PositionRecommend;
import com.cjw.dao.entity.PositionRecommendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PositionRecommendMapper {
    int countByExample(PositionRecommendExample example);

    int deleteByExample(PositionRecommendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PositionRecommend record);

    int insertSelective(PositionRecommend record);

    List<PositionRecommend> selectByExample(PositionRecommendExample example);

    PositionRecommend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PositionRecommend record, @Param("example") PositionRecommendExample example);

    int updateByExample(@Param("record") PositionRecommend record, @Param("example") PositionRecommendExample example);

    int updateByPrimaryKeySelective(PositionRecommend record);

    int updateByPrimaryKey(PositionRecommend record);

    @Select("select position_id from position_recommend where user_id =#{userId}")
    List<Integer> findForPositionIdsByUserId(@Param("userId")Integer userId);
}