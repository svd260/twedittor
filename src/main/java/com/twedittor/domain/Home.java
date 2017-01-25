package com.twedittor.domain;

import java.util.List;

/**
 * Created by sumanthdommaraju on 1/24/17.
 */
public class Home {

    private String name;
    private List<Quote> quotesFromFeed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Quote> getQuotesFromFeed() {
        return quotesFromFeed;
    }

    public void setQuotesFromFeed(List<Quote> quotesFromFeed) {
        this.quotesFromFeed = quotesFromFeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Home home = (Home) o;

        if (name != null ? !name.equals(home.name) : home.name != null) return false;
        return quotesFromFeed != null ? quotesFromFeed.equals(home.quotesFromFeed) : home.quotesFromFeed == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (quotesFromFeed != null ? quotesFromFeed.hashCode() : 0);
        return result;
    }
}
