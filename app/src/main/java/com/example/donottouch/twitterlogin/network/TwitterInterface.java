package com.example.donottouch.twitterlogin.network;

import com.example.donottouch.twitterlogin.model.TwitterHomeTimelineStrong;
import com.example.donottouch.twitterlogin.model.TwitterReweetsOfMeStrong;
import com.example.donottouch.twitterlogin.model.TwitterUserSearchStrong;
import com.example.donottouch.twitterlogin.model.TwitterUserTimeLineStrong;
import com.example.donottouch.twitterlogin.model.TwitterUsersShowStrong;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TwitterInterface {
    @GET("/1.1/statuses/user_timeline.json")
    Call<List<TwitterUserTimeLineStrong>> getUserTimeLine(@Query("screen_name") String screenName);

    @GET("/1.1/statuses/home_timeline.json")
    Call<List<TwitterHomeTimelineStrong>> getHomeTimeline();

    @GET("/1.1/statuses/mentions_timeline.json")
    Call<List<TwitterReweetsOfMeStrong>> getReweetsOfMe();

    @GET("/1.1/users/show.json")
    Call<TwitterUsersShowStrong> getUsersShow(@Query("user_id") long id);

    @GET("/1.1/users/search.json")
    Call<List<TwitterUserSearchStrong>> getUsersSearch(@Query("q") String query);

}


/*
    @GET("/1.1/users/show.json")
    void show(@Query("user_id") long id, Callback<User> cb);
*/
