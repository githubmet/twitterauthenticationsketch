package com.example.donottouch.twitterlogin.model;


import java.util.List;

public class TwitterMentionTimelineStrong {
    String id;
    String text;
    String created_at;

    public String getCreated_at() {
        return created_at;
    }

    public String getText() {
        return text;
    }
    public String getId() {
        return id;
    }


    userDetail user;
    public userDetail getUser() {
        return user;
    }
    public class userDetail{
        String profile_image_url_https;
        String description;
        String followers_count;
        String statues_count;
        String friends_count;
        String screen_name;

        public String getProfile_image_url_https() {
            return profile_image_url_https;
        }

        public String getDescription() {
            return description;
        }

        public String getFollowers_count() {
            return followers_count;
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
    }

    yDetails entities;
    public yDetails getEntities() {
        return entities;
    }
    public class yDetails{
     List<xDetails> user_mentions;
        public List<xDetails> getUser_mentions() {
            return user_mentions;
        }
        public class xDetails{
                String id;
                String id_str;
                String name;
                String screen_name;

            public String getScreen_name() {
                return screen_name;
            }
            public String getId() {
                return id;
            }
            public String getId_str() {
                return id_str;
            }
            public String getName() {
                return name;
            }
        }
    }
}










