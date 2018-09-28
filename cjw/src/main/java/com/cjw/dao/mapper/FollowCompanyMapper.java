package com.cjw.dao.mapper;

import com.cjw.dao.entity.FollowCompany;
import com.cjw.dao.entity.FollowCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FollowCompanyMapper {
    int countByExample(FollowCompanyExample example);

    int deleteByExample(FollowCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FollowCompany record);

    int insertSelective(FollowCompany record);

    List<FollowCompany> selectByExample(FollowCompanyExample example);

    FollowCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FollowCompany record, @Param("example") FollowCompanyExample example);

    int updateByExample(@Param("record") FollowCompany record, @Param("example") FollowCompanyExample example);

    int updateByPrimaryKeySelective(FollowCompany record);

    int updateByPrimaryKey(FollowCompany record);
}