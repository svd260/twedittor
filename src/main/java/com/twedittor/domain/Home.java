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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Home home = (Home) o;

        if (firstName != null ? !firstName.equals(home.firstName) : home.firstName != null) return false;
        if (lastName != null ? !lastName.equals(home.lastName) : home.lastName != null) return false;
        if (quotesFromFeed != null ? !quotesFromFeed.equals(home.quotesFromFeed) : home.quotesFromFeed != null)
            return false;
        if (followers != null ? !followers.equals(home.followers) : home.followers != null) return false;
        return following != null ? following.equals(home.following) : home.following == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (quotesFromFeed != null ? quotesFromFeed.hashCode() : 0);
        result = 31 * result + (followers != null ? followers.hashCode() : 0);
        result = 31 * result + (following != null ? following.hashCode() : 0);
        return result;
    }
}
