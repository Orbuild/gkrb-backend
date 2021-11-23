package com.example.gkrb.mapper;

import com.example.gkrb.model.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {

    int deleteByPrimaryKey(Integer messageId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer messageId);

    List<Message> selectAllMessages();

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

}