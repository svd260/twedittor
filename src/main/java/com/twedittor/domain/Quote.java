package com.twedittor.domain;

import org.threeten.bp.LocalDateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sumanthdommaraju on 1/24/17.
 */
@Entity
@Table(name = "quote", schema = "twedittor")
public class Quote implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long quoteId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    private String message;
    private int likes;
    private int reQoute;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Comment> comments;
    private LocalDateTime timeStamp;

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

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quote quote = (Quote) o;

        if (likes != quote.likes) return false;
        if (reQoute != quote.reQoute) return false;
        if (user != null ? !user.equals(quote.user) : quote.user != null) return false;
        if (message != null ? !message.equals(quote.message) : quote.message != null) return false;
        if (comments != null ? !comments.equals(quote.comments) : quote.comments != null) return false;
        return timeStamp != null ? timeStamp.equals(quote.timeStamp) : quote.timeStamp == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + likes;
        result = 31 * result + reQoute;
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }

    public long getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(long quoteId) {
        this.quoteId = quoteId;
    }
}
