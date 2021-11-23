package com.example.gkrb.mapper;

import com.example.gkrb.model.MT;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MTMapper {

    int deleteByPrimaryKey(@Param("messageId") Integer messageId, @Param("tagId") Integer tagId);

    int insert(MT record);

    int insertSelective(MT record);

    List<MT> getMTByMessageId(int messageId);

    List<MT> getMtByTagId(int tagId);

}