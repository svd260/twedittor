package com.twedittor.controller;

import com.twedittor.domain.Home;
import com.twedittor.service.HomeFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by sumanthdommaraju on 1/24/17.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    private final HomeFeedService homeFeedService;
    private static final String USER_ID = "userId";

    @Autowired
    public HomeController(HomeFeedService homeFeedService) {
        this.homeFeedService = homeFeedService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Home getHome(HttpSession session) {
        Home home = new Home();
        String userId = (String) session.getAttribute(USER_ID);
        home.setName(userId);
        home.setQuotesFromFeed(homeFeedService.getFeed(userId));
        return home;
    }
}
