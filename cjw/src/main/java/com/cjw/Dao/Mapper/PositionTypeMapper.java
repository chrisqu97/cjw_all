package com.cjw.dao.mapper;

import com.cjw.dao.entity.PositionType;
import com.cjw.dao.entity.PositionTypeExample;
import com.cjw.pojo.PositionTypePojo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PositionTypeMapper {
    int countByExample(PositionTypeExample example);

    int deleteByExample(PositionTypeExample example);

    int deleteByPrimaryKey(Integer positionTypeId);

    int insert(PositionType record);

    int insertSelective(PositionType record);

    List<PositionType> selectByExample(PositionTypeExample example);

    PositionType selectByPrimaryKey(Integer positionTypeId);

    int updateByExampleSelective(@Param("record") PositionType record, @Param("example") PositionTypeExample example);

    int updateByExample(@Param("record") PositionType record, @Param("example") PositionTypeExample example);

    int updateByPrimaryKeySelective(PositionType record);

    int updateByPrimaryKey(PositionType record);

    @Select("select a.position_type_id as positionTypeId, a.position_type_name as positionName3, b.position_type_name as positionName2,c.position_type_name as positionName1\n" +
            "from position_type a\n" +
            "left join position_type b on a.parent = b.position_type_id\n" +
            "left join position_type c on b.parent = c.position_type_id\n" +
            "where b.position_type_id is not null and c.position_type_id is not null;")
    List<PositionTypePojo> findAllType();

    @Select("select a.position_type_id as positionTypeId, a.position_type_name as positionName3, b.position_type_name as positionName2,c.position_type_name as positionName1\n" +
            "from position_type a\n" +
            "left join position_type b on a.parent = b.position_type_id\n" +
            "left join position_type c on b.parent = c.position_type_id\n" +
            "where b.position_type_id is not null and c.position_type_id is not null and a.position_type_id =#{id};")
    PositionTypePojo findOneType(@Param("id") Integer id);
}