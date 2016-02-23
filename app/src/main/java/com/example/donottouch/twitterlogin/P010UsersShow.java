package com.example.donottouch.twitterlogin;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.donottouch.twitterlogin.backbone.GetTwitterRetrofitAndNetwork;
import com.example.donottouch.twitterlogin.model.TwitterUsersShowStrong;
import com.example.donottouch.twitterlogin.network.TwitterInterface;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class P010UsersShow extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p010usersshow);
        final TextView textViewP010= (TextView)findViewById(R.id.textViewP010);
        final ImageView imageViewTopP010= (ImageView)findViewById(R.id.imageViewTopP010);
        final ImageView imageViewBottomP010= (ImageView)findViewById(R.id.imageViewBottomP010);

        TwitterSession twitterSession= Twitter.getSessionManager().getActiveSession();
        Long userIdLong= twitterSession.getUserId();
        String alinanToken=twitterSession.getAuthToken().token;
        String alinanSecret=twitterSession.getAuthToken().secret;

        GetTwitterRetrofitAndNetwork.getTwitterRetrofit(alinanToken, alinanSecret);
        TwitterInterface  twitterInterface= GetTwitterRetrofitAndNetwork
                .getTwitterNetwork();
        Call<TwitterUsersShowStrong> twitterUsersShowStrongCall= twitterInterface
                .getUsersShow(userIdLong);
        twitterUsersShowStrongCall.enqueue(new Callback<TwitterUsersShowStrong>() {
            @Override
            public void onResponse(Call<TwitterUsersShowStrong> call, Response<TwitterUsersShowStrong> response) {
                TwitterUsersShowStrong twitterUsersShowStrong= response.body();
                textViewP010.setText(twitterUsersShowStrong.toString());

                Picasso.with(P010UsersShow.this)
                        .load(twitterUsersShowStrong.getProfile_background_image_url_https())
                        .into(imageViewBottomP010);

                Picasso.with(P010UsersShow.this)
                        .load(twitterUsersShowStrong.getProfile_background_image_url_https())
                        .into(imageViewTopP010);

            }

            @Override
            public void onFailure(Call<TwitterUsersShowStrong> call, Throwable t) {

            }
        });
    }
}
