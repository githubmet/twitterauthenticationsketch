package com.example.donottouch.twitterlogin.adapter;

import com.example.donottouch.twitterlogin.R;
import com.example.donottouch.twitterlogin.model.TwitterUserSearchStrong;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class P011ArrayAdapter extends ArrayAdapter<TwitterUserSearchStrong> {

    Context context;
    List<TwitterUserSearchStrong> twitterUserSearchStrongList;
    public P011ArrayAdapter(Context context, int resource,List<TwitterUserSearchStrong>
                            twitterUserSearchStrongList) {
        super(context, resource,twitterUserSearchStrongList);
        this.context=context;
        this.twitterUserSearchStrongList=twitterUserSearchStrongList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.p011customrow,parent,false );

        TextView textViewCustomRowP011=(TextView)view.findViewById(R.id.textViewCustomRowP011);
        ImageView imageViewCustomRowP011= (ImageView)view.findViewById(R.id.imageViewCustomRowP011);

        textViewCustomRowP011.setText(twitterUserSearchStrongList.get(position).toString());
        Picasso.with(context)
                .load(twitterUserSearchStrongList.get(position).getProfile_background_image_url_https())
                .into(imageViewCustomRowP011);
        return view;
    }
}
