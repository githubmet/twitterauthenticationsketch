package com.example.donottouch.twitterlogin.model;

public class TwitterUserSearchStrong {
    String name;
    String created_at;
    String location;
    String profile_background_image_url_https;

    @Override
    public String toString() {
        return
                "name=" + name +
                "\ncreated_at=" + created_at +
                        "\nlocation="+location;

    }

    public String getProfile_background_image_url_https() {
        return profile_background_image_url_https;
    }
}
