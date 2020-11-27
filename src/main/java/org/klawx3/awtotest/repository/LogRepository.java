package org.klawx3.awtotest.repository;

import org.klawx3.awtotest.persistence.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log,Integer> {
    @Query(value = "SELECT aw_log.* FROM aw_log " +
            "INNER JOIN aw_hashtag_log ON aw_log.id = aw_hashtag_log.log_id " +
            "WHERE hashtag_id = :hid", nativeQuery = true)
    List<Log> findLogsByHashTagId(@Param("hid") Integer hashtagId);
}
