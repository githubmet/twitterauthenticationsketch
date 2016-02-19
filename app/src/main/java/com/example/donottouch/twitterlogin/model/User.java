package com.example.donottouch.twitterlogin.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    String id_str;
    String name;
    String screen_name;

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id_str);
        dest.writeString(name);
        dest.writeString(screen_name);
    }
    protected User(Parcel in) {
        id_str= in.readString();
        name= in.readString();
        screen_name= in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
