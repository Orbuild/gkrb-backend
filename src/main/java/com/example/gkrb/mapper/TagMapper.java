package com.example.gkrb.mapper;

import com.example.gkrb.model.Tag;
import org.springframework.stereotype.Repository;

@Repository
public interface TagMapper {

    int deleteByPrimaryKey(Integer tagId);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

}