package org.klawx3.awtotest.repository;

import org.klawx3.awtotest.persistence.model.Hashtag;
import org.klawx3.awtotest.persistence.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag,Integer> {
    @Query(value = "from Hashtag where description = :hname")
    Hashtag findHashtagByName(@Param("hname") String hashtagName);
}
