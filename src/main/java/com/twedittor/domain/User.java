package com.twedittor.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sumanthdommaraju on 1/24/17.ß
 */
@Entity
@Table(name = "user", schema = "twedittor")
@NamedQuery(name = "User.findFollowers",query = "select u from User u join u.following f where f.followed = :uid ")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    private String userName;
    private String firstName;
    private String lastName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy="user")
    @JsonManagedReference
    private List<Quote> quotes;
    @OneToMany(mappedBy = "follower")
    @JsonIgnore
    private List<Relationship> following;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public List<Relationship> getFollowing() {
        return following;
    }

    public void setFollowing(List<Relationship> following) {
        this.following = following;
    }

    public Long getId() {
        return uid;
    }

    public void setId(Long uid) {
        this.uid = uid;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!uid.equals(user.uid)) return false;
        if (!userName.equals(user.userName)) return false;
        if (!firstName.equals(user.firstName)) return false;
        return lastName.equals(user.lastName);
    }

    @Override
    public int hashCode() {
        int result = uid.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }

}
