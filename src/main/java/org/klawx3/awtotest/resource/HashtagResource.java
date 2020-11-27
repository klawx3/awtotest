package org.klawx3.awtotest.resource;

import org.klawx3.awtotest.persistence.model.Hashtag;
import org.klawx3.awtotest.service.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HashtagResource {

    @Autowired
    HashtagService hashtagService;

    @PutMapping("/api/v1/hashtags")
    public ResponseEntity<?> modifyHashtag(@RequestBody Hashtag hashtag){
        if(hashtagService.updateHashtag(hashtag))
            return new ResponseEntity<>(hashtag, HttpStatus.OK);
        else
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);


    }

}
