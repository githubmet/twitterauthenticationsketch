package com.example.donottouch.twitterlogin.model;

public class TwitterHomeTimelineStrong {
    String id;
    String text;
    String profile_image_url_https;
    String statues_count;
    String friends_count;
    String screen_name;
    userClass user;

    public String getText() {
        return text;
    }

    public String getProfile_image_url_https() {
        return profile_image_url_https;
    }

    public String getStatues_count() {
        return statues_count;
    }

    public String getFriends_count() {
        return friends_count;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public userClass getUser() {
        return user;
    }

    public class userClass{
        String name;
        String location;
        String description;

        public String getName() {
            return name;
        }

        public String getLocation() {
            return location;
        }

        public String getDescription() {
            return description;
        }
    }
    public String getId() {
        return id;
    }
}
