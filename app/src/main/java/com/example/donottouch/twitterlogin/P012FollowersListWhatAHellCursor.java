package com.example.donottouch.twitterlogin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.donottouch.twitterlogin.backbone.GetTwitterRetrofitAndNetwork;
import com.example.donottouch.twitterlogin.model.TwitterFollowerListWhatAHellCursorStrong;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class P012FollowersListWhatAHellCursor extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p012followerslist);

        final TextView textViewP012= (TextView)findViewById(R.id.textViewP012);

        TwitterSession twitterSession= Twitter.getSessionManager().getActiveSession();
        TwitterAuthToken twitterAuthToken=twitterSession.getAuthToken();
        String screenName=twitterSession.getUserName();
        String alinanToken=twitterAuthToken.token;
        String alinanSecret=twitterAuthToken.secret;

        GetTwitterRetrofitAndNetwork.getTwitterRetrofit(alinanToken, alinanSecret);
        Call<TwitterFollowerListWhatAHellCursorStrong> twitterFollowersListStrongCall=
                GetTwitterRetrofitAndNetwork.getTwitterNetwork().getFollowersListWhatAHellCursor(screenName);
        twitterFollowersListStrongCall.enqueue(new Callback<TwitterFollowerListWhatAHellCursorStrong>() {
            @Override
            public void onResponse(Call<TwitterFollowerListWhatAHellCursorStrong> call, Response<TwitterFollowerListWhatAHellCursorStrong> response) {
                TwitterFollowerListWhatAHellCursorStrong twitterFollowersListStrong= response.body();
                textViewP012.setText(
                        "next_cursor="+twitterFollowersListStrong.getNext_cursor()+
                        "\nnext_cursor_str="+twitterFollowersListStrong.getNext_cursor_str()+
                        "\nprevious_cursor="+twitterFollowersListStrong.getPrevious_cursor()+
                        "\nprevious_cursor_str="+twitterFollowersListStrong.getPrevious_cursor_str()
                );
            }

            @Override
            public void onFailure(Call<TwitterFollowerListWhatAHellCursorStrong> call, Throwable t) {

            }
        });

    }
}