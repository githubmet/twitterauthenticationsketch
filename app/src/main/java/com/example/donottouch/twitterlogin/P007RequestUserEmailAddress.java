package com.example.donottouch.twitterlogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;

public class P007RequestUserEmailAddress extends Activity {
    TwitterAuthClient twitterAuthClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p007requestuseremailaddress);

        final TextView textViewP007= (TextView)findViewById(R.id.textViewP007);

        TwitterSession twitterSession= Twitter.getSessionManager().getActiveSession();

        twitterAuthClient=new TwitterAuthClient();
        twitterAuthClient.requestEmail(twitterSession, new Callback<String>() {
            @Override
            public void success(Result<String> result) {
                    textViewP007.setText(result.response.getBody().toString());
            }

            @Override
            public void failure(TwitterException e) {
                Toast.makeText(P007RequestUserEmailAddress.this, "Cancalled",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
