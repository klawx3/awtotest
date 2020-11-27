package org.klawx3.awtotest.api.model;

import org.klawx3.awtotest.persistence.model.Hashtag;
import org.klawx3.awtotest.persistence.model.Log;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LogFeed extends Log {

    private List<String> hashtags;

    public LogFeed() {
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public void autoSetHashtagsSet(){
        Set<Hashtag> hashtagSet = new HashSet<>();
        getHashtags().forEach( l -> {
            String hashtagValue = l;
            if(l.startsWith("#"))
                hashtagValue = l.substring(1);
            Hashtag hashtag = new Hashtag();
            hashtag.setDescription(hashtagValue);
            hashtagSet.add(hashtag);
        });
        setHashtagSet(hashtagSet);
    }

    public Log getNewLogClone(){
        Log l = new Log();
        l.setId(getId());
        l.setCreationDate(getCreationDate());
        l.setDetails(getDetails());
        l.setHashtagSet(getHashtagSet());
        l.setHost(getHost());
        return l;
    }

    @Override
    public String toString() {
        return "LogFeed{" +
                "host='" + getHost() +
                "', details='" + getDetails() +
                "', hashtags=" + hashtags +
                "}";
    }
}
