package com.twedittor.controller;

import com.twedittor.domain.User;
import com.twedittor.service.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by sumanthdommaraju on 1/27/17.
 */
@Controller
@RequestMapping("/following")
public class FollowingController {

    private final FollowingService followingService;

    @Autowired
    public FollowingController(FollowingService followingService) {
        this.followingService = followingService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getFollowing(HttpSession session) {
//        Home home = new Home();
//        String userName = "svd260";//(String) session.getAttribute(USER_NAME);//TODO
//        home.setName(userName);
//        home.setQuotesFromFeed(

        return followingService.getFollowing("svd260");
    }
}
