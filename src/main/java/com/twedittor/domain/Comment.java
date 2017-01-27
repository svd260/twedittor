package com.twedittor.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sumanthdommaraju on 1/24/17.
 */

@Entity
@Table(name = "comment", schema = "twedittor")
public class Comment implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String comment;
    @ManyToOne
    @JoinColumn(name="uid", nullable=false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quoteId", nullable = false)
    private Quote quote;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
}
