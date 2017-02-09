package com.twedittor.controller;

import com.twedittor.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sumanthdommaraju on 2/9/17.
 */
@Controller
@RequestMapping("/quote")
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @RequestMapping(value = "like/{quoteId}", method = RequestMethod.GET)
    public ResponseEntity addLike(@PathVariable Long quoteId) {
        likeService.incrementLike(quoteId, "svd260");
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "unlike/{quoteId}", method = RequestMethod.GET)
    public ResponseEntity removeLike(@PathVariable Long quoteId) {
        likeService.decrementLike(quoteId, "svd260");
        return new ResponseEntity(HttpStatus.OK);
    }
}
