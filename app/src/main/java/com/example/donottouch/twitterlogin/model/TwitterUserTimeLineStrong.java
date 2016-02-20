package com.example.donottouch.twitterlogin.model;

public class TwitterUserTimeLineStrong {
    String id;
    String text;
    String place;
    public String getId() {
        return id;
    }
    public String getText() {
        return text;
    }

    user user;

    public TwitterUserTimeLineStrong.user getUser() {
        return user;
    }

    public class user{
        String name;
        String description;
        String followers_count;
        String statuses_count;
        String friends_count;
        String profile_image_url_https;
        String verified;

        public String getVerified() {
            return verified;
        }

        public String getProfile_image_url_https() {
            return profile_image_url_https;
        }

        public String getFollowers_count() {
            return followers_count;
        }

        public String getStatuses_count() {
            return statuses_count;
        }

        public String getFriends_count() {
            return friends_count;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }
    }
}
