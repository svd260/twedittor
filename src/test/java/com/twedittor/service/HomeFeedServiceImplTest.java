package com.twedittor.service;

import com.twedittor.domain.User;
import com.twedittor.repository.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by sumanthdommaraju on 1/25/17.
 */
public class HomeFeedServiceImplTest {

    @Mock
    private UserDao mockUserDao;
    @InjectMocks
    private HomeFeedServiceImpl homeFeedService;

    @Before
    public void setUp() {

    }

    @Test
    public void testGetFeed() {
        when(mockUserDao.findUserByUserId(anyString())).thenReturn(getMockUser());
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
        return user;
    }
}
