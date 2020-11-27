package org.klawx3.awtotest.persistence.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "aw_log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date creationDate;
    private String host;
    private String details;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST
    )
    @JoinTable(
            name = "aw_hashtag_log",
            joinColumns = {@JoinColumn( name = "log_id" , referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn( name = "hashtag_id" , referencedColumnName = "id")}
    )
    private Set<Hashtag> hashtagSet = new HashSet<>();


    public Log() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Set<Hashtag> getHashtagSet() {
        return hashtagSet;
    }

    public void setHashtagSet(Set<Hashtag> hashtagSet) {
        this.hashtagSet = hashtagSet;
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", host='" + host + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
