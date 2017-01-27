package com.twedittor.domain;

import java.util.List;

/**
 * Created by sumanthdommaraju on 1/24/17.
 */
public class Home {

    private String firstName;
    private String lastName;
    private List<Quote> quotesFromFeed;
    private Long followers;
    private Long following;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Quote> getQuotesFromFeed() {
        return quotesFromFeed;
    }

    public void setQuotesFromFeed(List<Quote> quotesFromFeed) {
        this.quotesFromFeed = quotesFromFeed;
    }

    public Long getFollowers() {
        return followers;
    }

    public void setFollowers(Long followers) {
        this.followers = followers;
    }

    public Long getFollowing() {
        return following;
    }

    public void setFollowing(Long following) {
        this.following = following;
    }
}
