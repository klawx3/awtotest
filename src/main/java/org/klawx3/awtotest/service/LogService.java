package org.klawx3.awtotest.service;

import org.klawx3.awtotest.api.model.LogFeed;
import org.klawx3.awtotest.persistence.model.Hashtag;
import org.klawx3.awtotest.persistence.model.Log;
import org.klawx3.awtotest.repository.HashtagRepository;
import org.klawx3.awtotest.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private HashtagRepository hashtagRepository;

    public List<Log> getLogsByHashtagId(Integer id){
        return logRepository.findLogsByHashTagId(id);
    }

    public void addLogByLogFeed(LogFeed logFeed){
        logFeed.autoSetHashtagsSet();
        logRepository.save(logFeed.getNewLogClone());


    }
}
