package com.example.donottouch.twitterlogin.network;

import com.example.donottouch.twitterlogin.model.TwitterFollowerListStrong;
import com.example.donottouch.twitterlogin.model.TwitterFollowerListWhatAHellCursorStrong;
import com.example.donottouch.twitterlogin.model.TwitterHomeTimelineStrong;
import com.example.donottouch.twitterlogin.model.TwitterMentionTimelineStrong;
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
    Call<List<TwitterMentionTimelineStrong>> getMentionTimeline();

    @GET("/1.1/users/show.json")
    Call<TwitterUsersShowStrong> getUsersShow(@Query("user_id") long id);

    @GET("/1.1/users/search.json")
    Call<List<TwitterUserSearchStrong>> getUsersSearch(@Query("q") String query);

    @GET("1.1/followers/list.json?skip_status=true&include_user_entities=false")
    Call<TwitterFollowerListWhatAHellCursorStrong> getFollowersListWhatAHellCursor
            (@Query("screen_name") String screen_name);

    @GET("1.1/followers/list.json")
    Call<TwitterFollowerListStrong> getFollowerList();//(@Query("screen_name") String screenName );
}


/*    @GET("https://api.twitter.com/1.1/followers/list.json")
    Call<TwitterFollowersListStrong> getFollowersList(
            @Query("screen_name") String screenName
    );*/


/*
    @GET("/1.1/users/show.json")
    void show(@Query("user_id") long id, Callback<User> cb);
*/
