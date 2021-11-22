package com.example.gkrb.mapper;

import com.example.gkrb.model.MT;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MTMapper {

    int deleteByPrimaryKey(@Param("messageId") Integer messageId, @Param("tagId") Integer tagId);

    int insert(MT record);

    int insertSelective(MT record);

}