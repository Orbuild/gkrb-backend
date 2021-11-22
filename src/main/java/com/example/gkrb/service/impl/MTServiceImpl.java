package com.example.gkrb.service.impl;

import com.example.gkrb.mapper.MTMapper;
import com.example.gkrb.model.MT;
import com.example.gkrb.service.MTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MTServiceImpl implements MTService {

    @Autowired
    private MTMapper mtMapper;

    public int insert(MT mt) {
        mtMapper.insert(mt);
        return 1;
    }

}
