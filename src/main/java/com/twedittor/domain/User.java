package com.twedittor.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sumanthdommaraju on 1/24/17.
 */
@Entity
@Table(name = "user", schema = "twedittor")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    private String userName;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy="user")
    private List<Quote> quotes;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "followers")
    private List<User> following;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }

    public Long getId() {
        return uid;
    }

    public void setId(Long uid) {
        this.uid = uid;
    }
}
