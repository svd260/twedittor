package com.twedittor.service;

import com.twedittor.domain.Quote;
import com.twedittor.domain.User;
import com.twedittor.repository.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.threeten.bp.LocalDateTime;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by sumanthdommaraju on 1/25/17.
 */
public class HomeFeedServiceImplTest {

    private UserDao mockUserDao = mock(UserDao.class);
    @InjectMocks
    private HomeFeedServiceImpl homeFeedService;

    @Before
    public void setUp() {
        homeFeedService = new HomeFeedServiceImpl(mockUserDao);
    }

    @Test
    public void testGetFeed() {
        when(mockUserDao.findUserByUserId(anyString())).thenReturn(getMockUser());
        List<Quote> quotes = homeFeedService.getFeed("Sam");
        assertEquals(6, quotes.size());
        //TODO test order based on timestamp. Latest messages should come first.
    }

    private User getMockUser() {
        User user = new User();
        user.setUserId("Sam");

        User fUser1 = new User();
        fUser1.setName("noah");

        User fUser2 = new User();
        fUser2.setName("Seth");

        User fUser3 = new User();
        fUser3.setName("colbert");

        Quote quote3 = new Quote();
        quote3.setQuoteId(1); quote3.setMessage("After all, tomorrow is another day!"); quote3.setTimeStamp(LocalDateTime.now());
        Quote quote4 = new Quote();
        quote4.setQuoteId(2); quote4.setMessage("may the force with you"); quote4.setTimeStamp(LocalDateTime.now());
        Quote quote2 = new Quote();
        quote2.setQuoteId(3); quote2.setMessage("Houston, we have a problem."); quote2.setTimeStamp(LocalDateTime.now());
        Quote quote1 = new Quote();
        quote1.setQuoteId(4); quote1.setMessage("Hasta la vista, baby."); quote1.setTimeStamp(LocalDateTime.now());
        Quote quote5 = new Quote();
        quote5.setQuoteId(5); quote5.setMessage("Bond. James Bond."); quote5.setTimeStamp(LocalDateTime.now());
        Quote quote6 = new Quote();
        quote6.setQuoteId(6); quote6.setMessage("just in time"); quote6.setTimeStamp(LocalDateTime.now());

        fUser1.setQuotes(Arrays.asList(quote1, quote2));
        fUser2.setQuotes(Arrays.asList(quote6, quote4, quote3));
        fUser3.setQuotes(Arrays.asList(quote5));
        user.setFollowing(Arrays.asList(fUser1, fUser2, fUser3));
        return user;
    }
}
