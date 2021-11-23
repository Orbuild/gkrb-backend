package com.example.gkrb.service;

import com.example.gkrb.dto.CommentDetailsParam;

import java.util.List;

public interface CommentService {

    List<CommentDetailsParam> getCommentDetailsByMessageId(int messageId);

}
