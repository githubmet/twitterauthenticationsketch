package com.example.donottouch.twitterlogin;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.donottouch.twitterlogin.adapter.P013RecyclerViewAdapter;
import com.example.donottouch.twitterlogin.backbone.GetTwitterRetrofitAndNetwork;
import com.example.donottouch.twitterlogin.model.TwitterFollowerListStrong;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class P013FollowersList extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p013followerslist);

        final RecyclerView recyclerViewP013= (RecyclerView)findViewById(R.id.recyclerViewP013);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(
                P013FollowersList.this,LinearLayoutManager.VERTICAL,false);
        recyclerViewP013.setLayoutManager(linearLayoutManager);

        TwitterSession twitterSession=Twitter.getSessionManager().getActiveSession();
        TwitterAuthToken twitterAuthToken= twitterSession.getAuthToken();
        String alinanToken=twitterAuthToken.token;
        String alinanSecret=twitterAuthToken.secret;

        GetTwitterRetrofitAndNetwork.getTwitterRetrofit(alinanToken, alinanSecret);
        Call<TwitterFollowerListStrong> twitterFollowerListStrongCall=
                GetTwitterRetrofitAndNetwork.getTwitterNetwork().getFollowerList();
                //(screenName);  Ayni hesap oluyor

        twitterFollowerListStrongCall.enqueue(new Callback<TwitterFollowerListStrong>() {
            @Override
            public void onResponse(Call<TwitterFollowerListStrong> call, Response<TwitterFollowerListStrong> response) {
                TwitterFollowerListStrong twitterFollowerListStrong= response.body();
                List<TwitterFollowerListStrong.xDetailsP013> xDetailsP013List =
                        twitterFollowerListStrong.getUsers();

                RecyclerView.Adapter adapter=new P013RecyclerViewAdapter(P013FollowersList.this
                        ,xDetailsP013List);
                recyclerViewP013.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<TwitterFollowerListStrong> call, Throwable t) {

            }
        });
    }
}
