package com.example.donottouch.twitterlogin.model;

public class TwitterUsersShowStrong {
    String created_at;
    String description;
    String favourites_count;
    String follow_request_sent;
    String followers_count;
    String following;
    String friends_count;
    String lang;
    String listed_count;
    String location;
    String name;
    String notifications;

    String screen_name;
    String statuses_count;
    String time_zone;

    @Override
    public String toString() {
        return "created_at=" + created_at +
                "\ndescription=" + description +
                "\nfavourites_count=" + favourites_count +
                "\nfollow_request_sent=" + follow_request_sent +
                "\nfollowers_count=" + followers_count +
                "\nfollowing=" + following +
                "\nfriends_count=" + friends_count +
                "\nlang=" + lang +
                "\nlisted_count=" + listed_count +
                "\nlocation=" + location +
                "\nname=" + name +
                "\nnotifications=" + notifications +
                "\nscreen name="+screen_name+
                "\nstatuses count"+statuses_count+
                "\ntime zone"+time_zone;
    }

    String profile_background_image_url_https;
    String profile_banner_url;

    public String getProfile_background_image_url_https() {
        return profile_background_image_url_https;
    }

    public String getProfile_banner_url() {
        return profile_banner_url;
    }
}
