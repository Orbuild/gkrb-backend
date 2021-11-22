package com.example.gkrb.controller;

import com.example.gkrb.dto.MessageParam;
import com.example.gkrb.dto.response.BaseResponse;
import com.example.gkrb.model.Message;
import com.example.gkrb.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/create")
    public BaseResponse<Integer> create(@RequestBody MessageParam messageParam) {

        return BaseResponse.success("Create successfully", 1);
    }

}
