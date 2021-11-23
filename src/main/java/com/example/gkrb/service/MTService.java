package com.example.gkrb.service;

import com.example.gkrb.model.MT;

import java.util.List;

public interface MTService {

    void insert(MT mt);

    List<MT> getMTByMessageId(int messageId);

}
