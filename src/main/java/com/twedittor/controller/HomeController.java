package com.twedittor.controller;

import com.twedittor.domain.Home;
import com.twedittor.domain.Quote;
import com.twedittor.service.HomeFeedService;
import com.twedittor.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by sumanthdommaraju on 1/24/17.
 */
@RestController
@RequestMapping("/")
public class HomeController {

    private final HomeFeedService homeFeedService;
    private final QuoteService quoteService;

    @Autowired
    public HomeController(HomeFeedService homeFeedService, QuoteService quoteService) {
        this.homeFeedService = homeFeedService;
        this.quoteService = quoteService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Home getHome(HttpSession session) {
//        Home home = new Home();
//        String userName = "svd260";//(String) session.getAttribute(USER_NAME);//TODO
//        home.setName(userName);
//        home.setQuotesFromFeed(

        return homeFeedService.getFeed("svd260");
    }

    @RequestMapping(value = "quote",method = RequestMethod.POST)//, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postQuote(@RequestBody String msg) {
        Quote quote = new Quote();
         quote.setMessage(msg);
        Boolean posted = quoteService.post(quote, "svd260");
        ResponseEntity<String> responseEntity = null;
        if(posted) {
            responseEntity = new ResponseEntity<String>("posted Successfully", HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<String>("post failed", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
