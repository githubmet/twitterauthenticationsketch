package com.example.donottouch.twitterlogin.backbone;

import com.example.donottouch.twitterlogin.network.TwitterInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;  //Why What do you want from me???
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

public class GetTwitterRetrofitAndNetwork  {
    public static Retrofit retrofit;
    public static  void getTwitterRetrofit(String AlinanToken,String AlinanTokenSecret){

OkHttpOAuthConsumer ConsumerClient = new OkHttpOAuthConsumer
                (AddObjectToApp.TWITTER_KEY, AddObjectToApp.TWITTER_SECRET);
ConsumerClient.setTokenWithSecret(AlinanToken,AlinanTokenSecret);


OkHttpClient okHttpClient=new OkHttpClient.Builder()
        .addInterceptor(new SigningInterceptor(ConsumerClient))
        .build();

retrofit=new Retrofit.Builder()
        .baseUrl("https://api.twitter.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build();

    }
    public static TwitterInterface getTwitterNetwork(){
        TwitterInterface twitterInterface= retrofit
                .create(TwitterInterface.class);
        return twitterInterface;
    }
}
