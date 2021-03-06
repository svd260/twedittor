package com.twedittor.service;

import com.twedittor.domain.Quote;
import com.twedittor.domain.User;
import com.twedittor.repository.UserDao;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by sumanthdommaraju on 1/25/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class HomeFeedServiceImplTest {

    @Mock
    private UserDao mockUserDao;
    @InjectMocks
    private HomeFeedServiceImpl homeFeedService;

    @Before
    public void setUp() {
    }

    @Test
    @Ignore
    public void testGetFeed() throws InterruptedException {
        when(mockUserDao.findUserByUserId(anyString())).thenReturn(getMockUser());
        List<Quote> quotes = null;//TODO //homeFeedService.getFeed("Sam");
        assertEquals(5, quotes.size());
        int[] quoteIdsExpectedOrder = {3,4,2,1,5};
        for(int i = 0; i < quoteIdsExpectedOrder.length; i++) {
            assertEquals(quoteIdsExpectedOrder[i], quotes.get(i).getQuoteId());
        }
    }

    private User getMockUser() throws InterruptedException {
        User user = new User();
        user.setUserName("Sam");

        User fUser1 = new User();
        fUser1.setFirstName("noah");
        User fUser2 = new User();
        fUser2.setFirstName("Seth");
        User fUser3 = new User();
        fUser3.setFirstName("colbert");
        Quote quote3 = new Quote();
        quote3.setQuoteId(3); quote3.setMessage("After all, tomorrow is another day!"); quote3.setTimeStamp(new Timestamp(System.currentTimeMillis()));
        Thread.sleep(1000);         //to make sure quotes timestamp differs atleast by 1 sec, so that the order can be tested
        Quote quote4 = new Quote();
        quote4.setQuoteId(4); quote4.setMessage("may the force with you"); quote4.setTimeStamp(new Timestamp(System.currentTimeMillis()));
        Thread.sleep(1000);
        Quote quote2 = new Quote();
        quote2.setQuoteId(2); quote2.setMessage("Houston, we have a problem."); quote2.setTimeStamp(new Timestamp(System.currentTimeMillis()));
        Thread.sleep(1000);
        Quote quote1 = new Quote();
        quote1.setQuoteId(1); quote1.setMessage("Hasta la vista, baby."); quote1.setTimeStamp(new Timestamp(System.currentTimeMillis()));
        Thread.sleep(1000);
        Quote quote5 = new Quote();
        quote5.setQuoteId(5); quote5.setMessage("Bond. James Bond."); quote5.setTimeStamp(new Timestamp(System.currentTimeMillis()));

//        fUser1.setQuotes(Arrays.asList(quote1, quote2));
//        fUser2.setQuotes(Arrays.asList(quote4, quote3));
//        fUser3.setQuotes(Arrays.asList(quote5));
//        user.setFollowing(Arrays.asList(fUser1, fUser2, fUser3));
        return user;
    }
}
