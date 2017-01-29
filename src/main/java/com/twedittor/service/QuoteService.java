package com.twedittor.service;

import com.twedittor.domain.Quote;

/**
 * Created by sumanthdommaraju on 1/29/17.
 */
public interface QuoteService {
    Boolean post(Quote quote, String uid);
}
