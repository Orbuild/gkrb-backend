package com.example.gkrb.mapper;

import com.example.gkrb.model.UT;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UTMapper {
    int deleteByPrimaryKey(@Param("tagId") Integer tagId, @Param("userId") Integer userId);

    int insert(UT record);

    int insertSelective(UT record);
}