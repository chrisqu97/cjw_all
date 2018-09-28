package com.cjw.dao.mapper;

import com.cjw.dao.entity.SeeCompany;
import com.cjw.dao.entity.SeeCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeeCompanyMapper {
    int countByExample(SeeCompanyExample example);

    int deleteByExample(SeeCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SeeCompany record);

    int insertSelective(SeeCompany record);

    List<SeeCompany> selectByExample(SeeCompanyExample example);

    SeeCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SeeCompany record, @Param("example") SeeCompanyExample example);

    int updateByExample(@Param("record") SeeCompany record, @Param("example") SeeCompanyExample example);

    int updateByPrimaryKeySelective(SeeCompany record);

    int updateByPrimaryKey(SeeCompany record);
}