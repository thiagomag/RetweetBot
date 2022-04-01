package br.com.thiago.retweetbot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "TweetSearch", url = "https://api.twitter.com/2")
public interface TweeterClient {

    @GetMapping("/tweets/search/recent?query=")
    ResponseEntity<String> tweetSearch(@RequestParam String query, @RequestHeader("Authorization") String bearerToken);

    @GetMapping("/users/by/username/{userName}")
    ResponseEntity<String> getUserDataByUserName(@PathVariable String userName, @RequestHeader("Authorization") String bearerToken);

    @PostMapping("/users/{id}/retweets")
    ResponseEntity<String> retweetById(@PathVariable String id,
                                       @RequestHeader("Signature Method") String signature,
                                       @RequestHeader("Consumer Key") String consumerKey,
                                       @RequestHeader("Consumer Secret") String consumerSecret,
                                       @RequestHeader("Access Token") String accessToken,
                                       @RequestHeader("Token Secret") String tokenSecret);
}