package org.klawx3.awtotest.resource;

import org.klawx3.awtotest.api.model.LogFeed;
import org.klawx3.awtotest.persistence.model.Log;
import org.klawx3.awtotest.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LogResource {

    @Autowired
    LogService logService;

    @GetMapping("/api/v1/logs/hashtag/{hashtagId}")
    public ResponseEntity<?> getLogListByHastagId(@PathVariable Integer hashtagId){
        List<Log> logsByHashtagId = logService.getLogsByHashtagId(hashtagId);
        if(!logsByHashtagId.isEmpty())
            return new ResponseEntity<>(logsByHashtagId, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/api/v1/logs")
    public void createLog(@RequestBody LogFeed log){
        logService.addLogByLogFeed(log);
    }
}
