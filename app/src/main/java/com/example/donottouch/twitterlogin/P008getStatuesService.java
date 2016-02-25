package com.example.donottouch.twitterlogin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;

public class P008getStatuesService extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p008getstatusesservice);
        final TextView textViewP008= (TextView)findViewById(R.id.textViewP008);

        //Twitter.getApiClient(). HATA
        TwitterApiClient twitterApiClient= TwitterCore.getInstance().getApiClient();
        StatusesService statusesService=twitterApiClient.getStatusesService();
        statusesService.show(524971209851543553L, null, null, null, new Callback<Tweet>() {
            @Override
            public void success(Result<Tweet> result) {
                Tweet tweet= result.data;
                 textViewP008.setText(
                         "Tweet Text="+tweet.text+
                                "\nCreated At=" +tweet.createdAt
                 );
            }

            @Override
            public void failure(TwitterException e) {

            }
        });

    }
}
