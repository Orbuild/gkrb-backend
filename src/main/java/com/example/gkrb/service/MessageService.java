package com.example.gkrb.service;

import com.example.gkrb.dto.MessageParam;

import java.text.ParseException;

public interface MessageService {

    void create(MessageParam messageParam) throws ParseException;

}
