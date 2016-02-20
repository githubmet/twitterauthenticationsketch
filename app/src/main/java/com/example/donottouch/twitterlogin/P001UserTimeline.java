package com.example.donottouch.twitterlogin;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.donottouch.twitterlogin.adapter.P001ArrayAdapter;
import com.example.donottouch.twitterlogin.backbone.GetTwitterRetrofitAndNetwork;
import com.example.donottouch.twitterlogin.model.TwitterUserTimeLineStrong;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class P001UserTimeline extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p001usertimeline);
        final ListView listViewP001=(ListView)findViewById(R.id.listViewP001);
        TextView textViewP001=(TextView)findViewById(R.id.textViewP001);

        //bu sayede intent.putExtras() ile tasimaktan kurtulduk...
        TwitterSession twitterSession= Twitter.getSessionManager().getActiveSession();
        String alinanToken2= twitterSession.getAuthToken().token;
        String alinanSecret2= twitterSession.getAuthToken().secret;
        String screenName2= twitterSession.getUserName();

        textViewP001.setText(screenName2);

        GetTwitterRetrofitAndNetwork.getTwitterRetrofit(alinanToken2, alinanSecret2);
        Call<List<TwitterUserTimeLineStrong>> twitterUserTimeLineStrongListCall=
                GetTwitterRetrofitAndNetwork.getTwitterNetwork().getUserTimeLine(screenName2);
        twitterUserTimeLineStrongListCall.enqueue(new Callback<List<TwitterUserTimeLineStrong>>() {
            @Override
            public void onResponse(Call<List<TwitterUserTimeLineStrong>> call, Response<List<TwitterUserTimeLineStrong>> response) {
                List<TwitterUserTimeLineStrong> twitterUserTimeLineStrongList= response.body();
                ArrayAdapter arrayAdapter=new P001ArrayAdapter(P001UserTimeline.this,
                        R.layout.p001customrow,twitterUserTimeLineStrongList);
                listViewP001.setAdapter(arrayAdapter);
            }
            @Override
            public void onFailure(Call<List<TwitterUserTimeLineStrong>> call, Throwable t) {

            }
        });

    }
}