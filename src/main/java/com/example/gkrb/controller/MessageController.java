package com.example.gkrb.controller;

import com.example.gkrb.dto.MessageDetailsParam;
import com.example.gkrb.dto.MessageParam;
import com.example.gkrb.dto.response.BaseResponse;
import com.example.gkrb.model.Message;
import com.example.gkrb.service.MessageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/create")
    public BaseResponse<Integer> create(@RequestBody MessageParam messageParam) throws ParseException {
        messageService.create(messageParam);
        return BaseResponse.success("Create successfully", 1);
    }

    @GetMapping("/getMessages")
    public BaseResponse<PageInfo<MessageDetailsParam>> getMessages(@RequestParam int pageNum, @RequestParam int pageSize) {
        return BaseResponse.success("Get messages successfully", messageService.getMessages(pageNum, pageSize));
    }

    @GetMapping("/getMessagesByTags")
    public void getMessagesByTags(@RequestParam String tagValues, @RequestParam int pageNum, @RequestParam int pageSize) {
        //return BaseResponse.success("Get messages successfully", messageService.getMessages(pageNum, pageSize));
    }


}
