package com.twedittor.repository;

import com.twedittor.domain.Quote;

/**
 * Created by sumanthdommaraju on 1/29/17.
 */
public interface QuoteDao {
    void save(Quote quote);

    Quote findById(Long quoteId);
}
