package com.example.gkrb.service;

import com.example.gkrb.dto.CommentDetailsParam;
import com.example.gkrb.dto.CommentParam;

import java.text.ParseException;
import java.util.List;

public interface CommentService {

    List<CommentDetailsParam> getCommentDetailsByMessageId(int messageId);

    void create(CommentParam commentParam) throws ParseException;

    void delete(int commentId);

}
