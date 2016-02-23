package com.example.donottouch.twitterlogin;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.donottouch.twitterlogin.adapter.P003RecyclerViewAdapter;
import com.example.donottouch.twitterlogin.backbone.GetTwitterRetrofitAndNetwork;
import com.example.donottouch.twitterlogin.model.TwitterUserTimeLineStrong;
import com.example.donottouch.twitterlogin.network.TwitterInterface;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class P003UserTimelineRecyclerView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p003usertimelinerecyclerview);

        final RecyclerView recyclerViewP003=(RecyclerView)findViewById(R.id.recyclerViewP003);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false);
        recyclerViewP003.setLayoutManager(linearLayoutManager);


        TwitterSession twitterSession=Twitter.getSessionManager().getActiveSession();
        TwitterAuthToken twitterAuthToken= twitterSession.getAuthToken();
        String alinanToken= twitterAuthToken.token;
        String alinanaSocket=twitterAuthToken.secret;
        String screenName=twitterSession.getUserName();

        GetTwitterRetrofitAndNetwork.getTwitterRetrofit(alinanToken,alinanaSocket);
        TwitterInterface twitterInterface= GetTwitterRetrofitAndNetwork.getTwitterNetwork();
        Call<List<TwitterUserTimeLineStrong>> twitterUserTimelineStrongListCall=
                twitterInterface.getUserTimeLine(screenName);

        twitterUserTimelineStrongListCall.enqueue(new Callback<List<TwitterUserTimeLineStrong>>() {
            @Override
            public void onResponse(Call<List<TwitterUserTimeLineStrong>> call, Response<List<TwitterUserTimeLineStrong>> response) {

                RecyclerView.Adapter adapter=new P003RecyclerViewAdapter(
                        P003UserTimelineRecyclerView.this,response.body());
                recyclerViewP003.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<TwitterUserTimeLineStrong>> call, Throwable t) {

            }
        });
    }
}
