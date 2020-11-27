package org.klawx3.awtotest.service;

import org.klawx3.awtotest.persistence.model.Hashtag;
import org.klawx3.awtotest.repository.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HashtagService {

    @Autowired
    private HashtagRepository hashtagRepository;

    public boolean updateHashtag(Hashtag hashtag){
        var optional = hashtagRepository.findById(hashtag.getId());
        if(optional.isPresent()){
            Hashtag h = optional.get();
            h.setDescription(hashtag.getDescription());
            hashtagRepository.save(h);
            return true;
        }
        return false;
    }
}
