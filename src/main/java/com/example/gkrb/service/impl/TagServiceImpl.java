package com.example.gkrb.service.impl;

import com.example.gkrb.mapper.TagMapper;
import com.example.gkrb.model.Tag;
import com.example.gkrb.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    // @Transactional
    public int insert(String value) {
        Tag queryTag = tagMapper.selectByTagValue(value);
        if(queryTag == null) {
            Tag tag = new Tag();
            tag.setValue(value);
            tagMapper.insert(tag);
            return tag.getTagId();
        }
        return queryTag.getTagId();
    }

    // @Transactional
    public Tag getTagByTagId(int tagId) {
        return tagMapper.selectByPrimaryKey(tagId);
    }

}
