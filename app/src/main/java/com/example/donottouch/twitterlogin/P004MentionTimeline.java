package com.example.donottouch.twitterlogin;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.donottouch.twitterlogin.adapter.P004RecyclerViewAdapter;
import com.example.donottouch.twitterlogin.backbone.GetTwitterRetrofitAndNetwork;
import com.example.donottouch.twitterlogin.model.TwitterMentionTimelineStrong;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class P004MentionTimeline extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p004reweetsofme);
        TextView textViewP004= (TextView)findViewById(R.id.textViewP004);

        final RecyclerView recyclerViewP004= (RecyclerView)findViewById(R.id.recyclerViewP004);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(P004MentionTimeline.this,
                LinearLayoutManager.VERTICAL,false);
        recyclerViewP004.setLayoutManager(linearLayoutManager);

        TwitterSession twitterSession= Twitter.getSessionManager().getActiveSession();
        TwitterAuthToken twitterAuthToken= twitterSession.getAuthToken();
        String alinanToken=twitterAuthToken.token;
        String alinanSecret=twitterAuthToken.secret;
        String screenName=twitterSession.getUserName();

        textViewP004.setText(screenName);

        GetTwitterRetrofitAndNetwork.getTwitterRetrofit(alinanToken, alinanSecret);
        Call<List<TwitterMentionTimelineStrong>> twitterReweetsOfMeStrongListCall=
        GetTwitterRetrofitAndNetwork.getTwitterNetwork().getMentionTimeline();

        twitterReweetsOfMeStrongListCall.enqueue(new Callback<List<TwitterMentionTimelineStrong>>() {
            @Override
            public void onResponse(Call<List<TwitterMentionTimelineStrong>> call, Response<List<TwitterMentionTimelineStrong>> response) {

                RecyclerView.Adapter adapter=new P004RecyclerViewAdapter(P004MentionTimeline.this,
                        response.body());
                recyclerViewP004.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<TwitterMentionTimelineStrong>> call, Throwable t) {

            }
        });
    }
}
