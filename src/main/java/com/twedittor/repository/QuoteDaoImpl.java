package com.twedittor.repository;

import com.twedittor.domain.Quote;
import org.springframework.stereotype.Repository;

/**
 * Created by sumanthdommaraju on 1/29/17.
 */
@Repository
public class QuoteDaoImpl extends AbstractDao<Quote> implements QuoteDao {

    @Override
    public void save(Quote quote) {
        super.save(quote);
    }
}
