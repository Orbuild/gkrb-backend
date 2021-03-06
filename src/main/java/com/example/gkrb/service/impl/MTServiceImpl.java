package com.example.gkrb.service.impl;

import com.example.gkrb.mapper.MTMapper;
import com.example.gkrb.model.MT;
import com.example.gkrb.service.MTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MTServiceImpl implements MTService {

    @Autowired
    private MTMapper mtMapper;

    // @Transactional
    public void insert(MT mt) {
        mtMapper.insert(mt);
    }

    // @Transactional
    public List<MT> getMTByMessageId(int messageId) {
        return mtMapper.getMTByMessageId(messageId);
    }

}
