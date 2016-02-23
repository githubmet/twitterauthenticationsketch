package com.example.donottouch.twitterlogin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.donottouch.twitterlogin.R;
import com.example.donottouch.twitterlogin.model.TwitterUserTimeLineStrong;
import com.squareup.picasso.Picasso;

import java.util.List;

public class P003RecyclerViewAdapter extends RecyclerView
        .Adapter<P003RecyclerViewAdapter.P003MyRecyclerViewHolder> {  //VH this is a hint

    Context context;
    List<TwitterUserTimeLineStrong> twitterUserTimeLineStrongList;
    LayoutInflater layoutInflater;
    public P003RecyclerViewAdapter(Context context,
                                   List<TwitterUserTimeLineStrong> twitterUserTimeLineStrongList) {
        this.context=context;
        this.twitterUserTimeLineStrongList=twitterUserTimeLineStrongList;
        layoutInflater=(LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public P003RecyclerViewAdapter.P003MyRecyclerViewHolder onCreateViewHolder
            (ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.p003customrow,parent,false );
        P003MyRecyclerViewHolder p003MyRecyclerViewHolder=new P003MyRecyclerViewHolder(view);

        return p003MyRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(P003RecyclerViewAdapter.P003MyRecyclerViewHolder holder, int position) {

        TwitterUserTimeLineStrong.user user=twitterUserTimeLineStrongList.get(position).getUser();
        holder.textViewCustomRowP003.setText(
                "Name="+user.getName()+
                        "\nStatues count=" +user.getStatuses_count()+
                        "\nFriends count="+user.getFriends_count()+
                        "\nFollowers count=" + user.getFollowers_count()+
                        "\nVerified="+user.getVerified()+
                        "\nTweet Id="+twitterUserTimeLineStrongList.get(position).getId()+
                        "\nPlace="+twitterUserTimeLineStrongList.get(position).getPlace()+
                        "\nCreated at="+twitterUserTimeLineStrongList.get(position).getCreated_at()+
                        "\nId str="+twitterUserTimeLineStrongList.get(position).getId_str()
                        );
        holder.textViewCustomRowBigP003.setText(
                "Text=" + twitterUserTimeLineStrongList.get(position).getText() +
                        "\nDescription=" + user.getDescription()+
                        "\n\nExpanded_url="
        );
        Picasso.with(context)
                .load(user.getProfile_image_url_https())
                .resize(120,120)
                .into(holder.imageViewCustomRowP003);
    }

    @Override
    public int getItemCount() {
        return twitterUserTimeLineStrongList.size();  //This is a trouble Maker
    }

    public class P003MyRecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView textViewCustomRowP003;
        TextView textViewCustomRowBigP003;
        ImageView imageViewCustomRowP003;
        public P003MyRecyclerViewHolder(View itemView) {
            super(itemView);
            textViewCustomRowP003=(TextView)itemView.findViewById(R.id.textViewCustomRowP003);
            textViewCustomRowBigP003 = (TextView) itemView
                    .findViewById(R.id.textViewCustomRowBigP003);
            imageViewCustomRowP003 = (ImageView)itemView.findViewById(R.id.imageViewCustomRowP003);
        }
    }
}
