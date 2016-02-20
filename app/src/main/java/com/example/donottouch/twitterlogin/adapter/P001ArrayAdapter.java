package com.example.donottouch.twitterlogin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.donottouch.twitterlogin.model.TwitterUserTimeLineStrong;
import com.example.donottouch.twitterlogin.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class P001ArrayAdapter extends ArrayAdapter<TwitterUserTimeLineStrong> {
    Context context;
    List<TwitterUserTimeLineStrong> twitterUserTimeLineStrongList;
    public P001ArrayAdapter(Context context, int resource,List<TwitterUserTimeLineStrong>
                            twitterUserTimeLineStrongList) {
        super(context, resource,twitterUserTimeLineStrongList);
        this.twitterUserTimeLineStrongList=twitterUserTimeLineStrongList;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.p001customrow,parent,false);
        TextView textViewCustomRowSmallP001= (TextView)view.findViewById(R.id.textViewCustomRowSmallP001);
        TextView textViewCustomRowBigP001= (TextView)view.findViewById(R.id.textViewCustomRowBigP001);
        ImageView imageViewCustomRowP001= (ImageView)view.findViewById(R.id.imageViewCustomRowP001);

        TwitterUserTimeLineStrong.user user= twitterUserTimeLineStrongList.get(position).getUser();

        textViewCustomRowSmallP001.setText(
                "Tweet Id=" + twitterUserTimeLineStrongList.get(position).getId() +
                        "\nname="+user.getName()+
                        "\nfollowers count="+user.getFollowers_count()+
                        "\nfriends count="+user.getFriends_count()+
                        "\nstatuses count="+user.getStatuses_count()
        );
        textViewCustomRowBigP001.setText(
                "verified="+user.getVerified()+
                "\nTweet Text=" + twitterUserTimeLineStrongList.get(position).getText() +
                        "\n\ndescription="+user.getDescription()
        );
        Picasso.with(context)
                .load(user.getProfile_image_url_https())
                .resize(80,80)
                .into(imageViewCustomRowP001);

        return view;
    }
}

