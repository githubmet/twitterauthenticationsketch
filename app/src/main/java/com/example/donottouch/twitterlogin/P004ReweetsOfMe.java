package com.example.donottouch.twitterlogin;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.donottouch.twitterlogin.adapter.P004RecyclerViewAdapter;
import com.example.donottouch.twitterlogin.backbone.GetTwitterRetrofitAndNetwork;
import com.example.donottouch.twitterlogin.model.TwitterReweetsOfMeStrong;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class P004ReweetsOfMe extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p004reweetsofme);

        final RecyclerView recyclerViewP004= (RecyclerView)findViewById(R.id.recyclerViewP004);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(P004ReweetsOfMe.this,
                LinearLayoutManager.VERTICAL,false);
        recyclerViewP004.setLayoutManager(linearLayoutManager);

        TwitterSession twitterSession= Twitter.getSessionManager().getActiveSession();
        TwitterAuthToken twitterAuthToken= twitterSession.getAuthToken();
        String alinanToken=twitterAuthToken.token;
        String alinanSecret=twitterAuthToken.secret;

        GetTwitterRetrofitAndNetwork.getTwitterRetrofit(alinanToken, alinanSecret);
        Call<List<TwitterReweetsOfMeStrong>> twitterReweetsOfMeStrongListCall=
        GetTwitterRetrofitAndNetwork.getTwitterNetwork().getReweetsOfMe();

        twitterReweetsOfMeStrongListCall.enqueue(new Callback<List<TwitterReweetsOfMeStrong>>() {
            @Override
            public void onResponse(Call<List<TwitterReweetsOfMeStrong>> call, Response<List<TwitterReweetsOfMeStrong>> response) {

                RecyclerView.Adapter adapter=new P004RecyclerViewAdapter(P004ReweetsOfMe.this,
                        response.body());
                recyclerViewP004.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<TwitterReweetsOfMeStrong>> call, Throwable t) {

            }
        });
    }
}
