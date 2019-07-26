package com.czxy.score.service.impl;

import com.czxy.score.dao.LogMapper;
import com.czxy.score.domain.Log;
import com.czxy.score.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @version v 1.0
 * @date 2019/7/25
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void addLog(Log log) {
        logMapper.insert(log);


    }
}
