
package com.example.brandtweet.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.brandtweet.model.TweetRequest;
import com.example.brandtweet.model.TweetResponse;
import com.example.brandtweet.service.TweetService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {
	    "http://localhost:5173",
	    "https://DivyaGowdKornepalli.github.io"
	})
public class TweetController {

    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping("/generate")
    public TweetResponse generateTweets(
            @RequestBody TweetRequest request) {

        return tweetService.generateTweets(request);
    }
}
