package com.example.donottouch.twitterlogin.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.donottouch.twitterlogin.R;
import com.example.donottouch.twitterlogin.model.TwitterHomeTimelineStrong;
import com.squareup.picasso.Picasso;

import java.util.List;

public class P002ArrayAdapter extends ArrayAdapter<TwitterHomeTimelineStrong> {
    List<TwitterHomeTimelineStrong> twitterHomeTimelineStrongs;
    Context context;
    public P002ArrayAdapter(Context context, int resource,
                            List<TwitterHomeTimelineStrong> twitterHomeTimelineStrongs) {
        super(context, resource,twitterHomeTimelineStrongs);
        this.twitterHomeTimelineStrongs=twitterHomeTimelineStrongs;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.p002customrow,parent,false);
        TextView textViewCustomRowP002=(TextView)view.findViewById(R.id.textViewCustomRowP002);
        TextView textViewCustomRowBigP002=(TextView)view.findViewById(R.id.textViewCustomRowBigP002);
        ImageView imageViewCustomRowP002=(ImageView)view.findViewById(R.id.imageViewCustomRowP002);
        TwitterHomeTimelineStrong.userClass userClass= twitterHomeTimelineStrongs.get(position).getUser();

        textViewCustomRowP002.setText(
                "Tweet Id="+twitterHomeTimelineStrongs.get(position).getId()+
                        "\nUser name="+userClass.getName()+
                        "\nScreen name="+twitterHomeTimelineStrongs.get(position).getScreen_name()+
                        "\nStatus count="+twitterHomeTimelineStrongs.get(position).getStatues_count()+
                        "\nFriends count="+twitterHomeTimelineStrongs.get(position).getFriends_count()+
                        "\nLocation="+userClass.getLocation()

        );
        textViewCustomRowBigP002.setText(
                "Tweet text="+twitterHomeTimelineStrongs.get(position).getText()+
                        "\n\nUser description="+userClass.getDescription()
        );

        Picasso.with(context)
                .load(twitterHomeTimelineStrongs.get(position).getProfile_image_url_https())
                .resize(150,150)
                .into(imageViewCustomRowP002);
        return view;
    }
}
