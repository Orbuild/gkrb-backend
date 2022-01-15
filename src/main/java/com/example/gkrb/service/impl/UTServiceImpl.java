package com.example.gkrb.service.impl;

import com.example.gkrb.mapper.UTMapper;
import com.example.gkrb.model.MT;
import com.example.gkrb.model.UT;
import com.example.gkrb.service.TagService;
import com.example.gkrb.service.UTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UTServiceImpl implements UTService {

    @Autowired
    private UTMapper utMapper;

    @Autowired
    private TagService tagService;

    public void insert(String userId, String value) {
        int tagId = tagService.insert(value);
        UT ut = new UT();
        ut.setUserId(userId);
        ut.setTagId(tagId);
        utMapper.insert(ut);
    }

}
