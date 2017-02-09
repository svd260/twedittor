package com.twedittor.jms;

import java.io.Serializable;

/**
 * Created by sumanthdommaraju on 2/9/17.
 */
public class Like implements Serializable{

    private Long id;
    private Long quoteId;
    private String userId;
    private Boolean like;

    public Like(Long quoteId, String userId, Boolean like) {
        this.quoteId = quoteId;
        this.userId = userId;
        this.like = like;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Long quoteId) {
        this.quoteId = quoteId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }
}
