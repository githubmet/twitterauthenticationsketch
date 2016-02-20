package com.example.donottouch.twitterlogin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.donottouch.twitterlogin.adapter.P002ArrayAdapter;
import com.example.donottouch.twitterlogin.backbone.GetTwitterRetrofitAndNetwork;
import com.example.donottouch.twitterlogin.model.TwitterHomeTimelineStrong;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class P002HomeTimeline extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p002hometimeline);

        final ListView listViewP002=(ListView)findViewById(R.id.listViewP002);

        TwitterSession twitterSession=Twitter.getSessionManager().getActiveSession();
        TwitterAuthToken twitterAuthToken= twitterSession.getAuthToken();
        String alinanToken=twitterAuthToken.token;
        String alinanaSecret=twitterAuthToken.secret;

        GetTwitterRetrofitAndNetwork.getTwitterRetrofit(alinanToken, alinanaSecret);
        Call<List<TwitterHomeTimelineStrong>> twitterHomeTimeLineStrongListCall=
                GetTwitterRetrofitAndNetwork.getTwitterNetwork().getHomeTimeline();

        twitterHomeTimeLineStrongListCall.enqueue(new Callback<List<TwitterHomeTimelineStrong>>() {
            @Override
            public void onResponse(Call<List<TwitterHomeTimelineStrong>> call, Response<List<TwitterHomeTimelineStrong>> response) {
                ArrayAdapter arrayAdapter=new P002ArrayAdapter(P002HomeTimeline.this,
                        R.layout.p002customrow,response.body());
                listViewP002.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<TwitterHomeTimelineStrong>> call, Throwable t) {

            }
        });
    }
}
