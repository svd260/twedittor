package com.twedittor.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    private User commentedBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quoteId", nullable = false)
    private Quote quote;
    private LocalDateTime timeStamp;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getCommentedBy() {
        return commentedBy;
    }

    public void setCommentedBy(User commentedBy) {
        this.commentedBy = commentedBy;
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

        Comment comment1 = (Comment) o;

        if (comment != null ? !comment.equals(comment1.comment) : comment1.comment != null) return false;
        if (commentedBy != null ? !commentedBy.equals(comment1.commentedBy) : comment1.commentedBy != null)
            return false;
        return timeStamp != null ? timeStamp.equals(comment1.timeStamp) : comment1.timeStamp == null;
    }

    @Override
    public int hashCode() {
        int result = comment != null ? comment.hashCode() : 0;
        result = 31 * result + (commentedBy != null ? commentedBy.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
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
