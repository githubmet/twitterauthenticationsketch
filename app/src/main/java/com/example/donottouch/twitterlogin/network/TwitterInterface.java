package com.example.donottouch.twitterlogin.network;

import com.example.donottouch.twitterlogin.model.TwitterHomeTimelineStrong;
import com.example.donottouch.twitterlogin.model.TwitterUserTimeLineStrong;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TwitterInterface {
    @GET("/1.1/statuses/user_timeline.json")
    Call<List<TwitterUserTimeLineStrong>> getUserTimeLine(@Query("screen_name") String screenName);

    @GET("/1.1/statuses/home_timeline.json")
    Call<List<TwitterHomeTimelineStrong>> getHomeTimeline();
}
