package com.eleve.services;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arif on 11/10/16.
 */
public class UtilityService {

    public static ArrayList<String> getHashtags(String hashtag) {
        ArrayList<String> tweetList = new ArrayList<String>();
        Twitter twitter = getTwitterIntanceObject();
        try {
            Query query = new Query(hashtag);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    tweetList.add("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                    //System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);

        } catch (TwitterException te) {
            te.printStackTrace();
        }

        return tweetList;
    }

    public static Twitter getTwitterIntanceObject(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("crWZ7fsX24tDogHDcpT5203cu")
                .setOAuthConsumerSecret("stjb2ihCCG4S4Xc6fL4rIJ3GokjJGYY3E3atoJT54oDXbiiz1O")
                .setOAuthAccessToken("2537104321-iYEyC3aTQUGY25lrpWcqdd7cjn6sHBJnnStGaMz")
                .setOAuthAccessTokenSecret("rDehBAhd9fTxQcnd9pR8JqtWlEOKKu058mOP71bAjvPlY");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        return twitter;
    }

}
