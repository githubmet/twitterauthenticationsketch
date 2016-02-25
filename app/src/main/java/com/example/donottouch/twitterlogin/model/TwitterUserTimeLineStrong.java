package com.example.donottouch.twitterlogin.model;

import java.util.List;
import java.util.Map;

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
    public String getPlace() {
        return place;
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

        String created_at;
        String  id_str;
    public String getCreated_at() {
        return created_at;
    }

    public String getId_str() {
        return id_str;
    }
}
