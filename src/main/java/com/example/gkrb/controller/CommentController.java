package com.example.gkrb.controller;

import com.example.gkrb.dto.CommentParam;
import com.example.gkrb.dto.UserRegisterParam;
import com.example.gkrb.dto.response.BaseResponse;
import com.example.gkrb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping("/create")
    public BaseResponse<Integer> create(@RequestBody CommentParam commentParam) throws ParseException {
        commentService.create(commentParam);
        return BaseResponse.success("Create successfully", 1);
    }

    @GetMapping("/delete")
    public BaseResponse<Integer> delete(@RequestParam int commentId) throws ParseException {
        commentService.delete(commentId);
        return BaseResponse.success("Delete successfully", 1);
    }



}
