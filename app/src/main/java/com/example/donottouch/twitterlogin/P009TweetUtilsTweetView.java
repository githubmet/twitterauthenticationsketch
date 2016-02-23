package com.example.donottouch.twitterlogin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.twitter.sdk.android.tweetui.TweetView;

import java.util.Arrays;
import java.util.List;

public class P009TweetUtilsTweetView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p009tweetutilstweetview);

        final LinearLayout linearLayoutP009=(LinearLayout)findViewById(R.id.linearLayoutP009);
        //
        List<Long> tweetIds=Arrays.asList(510908133917487104L);
        TweetUtils.loadTweets(tweetIds, new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> result) {
                for( Tweet gex:result.data){
                    linearLayoutP009.addView(new TweetView(P009TweetUtilsTweetView.this,
                            gex,R.style.tw__TweetDarkStyle));

                    //TweetView and TweetCompatView can be associated and added in
                    //The Api Callback success.
                }
            }

            @Override
            public void failure(TwitterException e) {

            }
        });
    }
}
