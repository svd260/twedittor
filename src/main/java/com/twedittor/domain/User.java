package com.twedittor.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sumanthdommaraju on 1/24/17.ß
 */
@Entity
@Table(name = "user", schema = "twedittor")
@NamedQuery(name = "User.findFollowers",query = "select u from User u join u.following f where f.uid = :uid ")
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
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "followers")
    private List<User> following;

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

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
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
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User user = (User) o;
//
//        if (uid != null ? !uid.equals(user.uid) : user.uid != null) return false;
//        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
//        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
//        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
//        if (quotes != null ? !quotes.equals(user.quotes) : user.quotes != null) return false;
//        return following != null ? following.equals(user.following) : user.following == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = uid != null ? uid.hashCode() : 0;
//        result = 31 * result + (userName != null ? userName.hashCode() : 0);
//        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
//        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
//        result = 31 * result + (quotes != null ? quotes.hashCode() : 0);
//        result = 31 * result + (following != null ? following.hashCode() : 0);
//        return result;
//    }
}
