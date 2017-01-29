package com.twedittor.controller;

import com.twedittor.domain.User;
import com.twedittor.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by sumanthdommaraju on 1/29/17.
 */
@Controller
@RequestMapping("/followers")
public class FollowersController {

    private final FollowerService followerService;

    @Autowired
    public FollowersController(FollowerService followerService) {
        this.followerService = followerService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getFollowers() {
        return followerService.findFollowers("svd260");
    }
}
