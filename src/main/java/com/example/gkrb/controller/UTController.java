package com.example.gkrb.controller;

import com.example.gkrb.dto.UserRegisterParam;
import com.example.gkrb.dto.response.BaseResponse;
import com.example.gkrb.service.UTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/ut")
public class UTController {

    @Autowired
    private UTService utService;

    @PostMapping("/insert")
    public BaseResponse<Integer> insert(@RequestParam String userId, @RequestParam String value) {
        utService.insert(userId, value);
        return BaseResponse.success("Insert successfully", 1);
    }

}
