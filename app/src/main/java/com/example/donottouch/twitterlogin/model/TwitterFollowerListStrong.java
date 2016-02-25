package com.example.donottouch.twitterlogin.model;


import java.util.List;

public class TwitterFollowerListStrong  {

    List<xDetailsP013> users;
    public List<xDetailsP013> getUsers() {
        return users;
    }
    public class xDetailsP013 {
        String id;
        String id_str;
        String name;
        String screen_name;
        String description;
        String followers_count;
        String friends_count;
        String listed_count;
        String created_at;
        String favourites_count;
        String statuses_count;
        String lang;

        @Override
        public String toString() {
            return
                    "id= " + id +
                    "\nid_str= " + id_str +
                    "\nname= " + name +
                    "\nscreen_name= " + screen_name +
                    "\ndescription= " + description +
                    "\nfollowers_count= " + followers_count +
                    "\nfriends_count= " + friends_count +
                    "\nlisted_count= " + listed_count +
                    "\ncreated_at= " + created_at +
                    "\nfavourites_count= " + favourites_count +
                    "\nstatuses_count= " + statuses_count +
                    "\nlang= " + lang +
                    "\nprofile_background_image_url_https= " + profile_background_image_url_https +
                    "\nprofile_image_url_https= " + profile_image_url_https ;
        }


        String profile_background_image_url_https;
        String profile_image_url_https;

        public String getProfile_background_image_url_https() {
            return profile_background_image_url_https;
        }

        public String getProfile_image_url_https() {
            return profile_image_url_https;
        }
    }
}
