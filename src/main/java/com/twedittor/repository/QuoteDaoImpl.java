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

    @Override
    public Quote findById(Long quoteId) {
        Quote quote = null;
        try {   //TODO
            quote = getResultForQuery("SELECT q FROM Quote q WHERE q.quoteId = :quoteId", new String[]{"quoteId"}, new Object[]{quoteId});
        } catch (Exception e) {
            //TODO log
        }
        return quote;
    }
}
