package com.example.gkrb.service;

import com.example.gkrb.model.Tag;

import java.util.List;

public interface TagService {

    int insert(String value);

    Tag getTagByTagId(int tagId);

}
