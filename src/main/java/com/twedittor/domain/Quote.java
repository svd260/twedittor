package com.twedittor.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by sumanthdommaraju on 1/24/17.
 */
@Entity
@Table(name = "quote", schema = "twedittor")
public class Quote implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long quoteId;
    @ManyToOne
    @JoinColumn(name="uid", nullable=false)
    @JsonBackReference
    private User user;
    private String message;
    private int likes;
    private int reQoute;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Comment> comments;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<User> likers;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getReQoute() {
        return reQoute;
    }

    public void setReQoute(int reQoute) {
        this.reQoute = reQoute;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public long getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(long quoteId) {
        this.quoteId = quoteId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Set<User> getLikers() {
        return likers;
    }

    public void setLikers(Set<User> likers) {
        this.likers = likers;
    }
}
