package com.example.donottouch.twitterlogin.network;

import com.example.donottouch.twitterlogin.model.TwitterFollowerStrong;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TwitterFollowerInterface {
    @GET("1.1/followers/list.json?skip_status=true&include_user_entities=false")
    Call<TwitterFollowerStrong> getFollowers(@Query("cursor") String cursor,@Query("screen_name") String screen_name);
}
