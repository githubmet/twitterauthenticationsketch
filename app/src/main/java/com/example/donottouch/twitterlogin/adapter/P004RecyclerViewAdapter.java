package com.example.donottouch.twitterlogin.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.donottouch.twitterlogin.R;
import com.example.donottouch.twitterlogin.model.TwitterMentionTimelineStrong;
import com.squareup.picasso.Picasso;

import java.util.List;

public class P004RecyclerViewAdapter extends RecyclerView.Adapter<P004RecyclerViewAdapter.P004MyViewHolder> { //<VH> hint

    LayoutInflater layoutInflater;
    List<TwitterMentionTimelineStrong> twitterMentionTimelineStrongList;
    Context context;
    public P004RecyclerViewAdapter(Context context,
                                   List<TwitterMentionTimelineStrong> twitterMentionTimelineStrongList) {
        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.twitterMentionTimelineStrongList = twitterMentionTimelineStrongList;
        this.context=context;
    }

    @Override
    public P004RecyclerViewAdapter.P004MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.p004customrow, parent, false);
        P004MyViewHolder p004MyViewHolder = new P004MyViewHolder(view);
        return p004MyViewHolder;
    }

    @Override
    public void onBindViewHolder(P004RecyclerViewAdapter.P004MyViewHolder holder, int position) {
        TwitterMentionTimelineStrong.userDetail userDetail =
                twitterMentionTimelineStrongList.get(position).getUser();
        holder.textViewCustomRowP004.setText(
                "id= " + twitterMentionTimelineStrongList.get(position).getId() +
                        "\ncreated_at= " + twitterMentionTimelineStrongList.get(position).getCreated_at() +
                        "\nfollowers_count= " + userDetail.getFollowers_count() +
                        "\nfriends_count= " + userDetail.getFriends_count() +
                        "\nstatues_count= " + userDetail.getStatues_count() +
                        "\nscreen_name= " + userDetail.getScreen_name()
        );
        holder.textViewCustomRowBigP004.setText(
                "text= " + twitterMentionTimelineStrongList.get(position).getText() +
                        "\n\ndescription= " + userDetail.getDescription()
        );

        Picasso.with(context)
                .load(userDetail.getProfile_image_url_https())
                .resize(120, 120)
                .into(holder.imageViewCustomRowP004);



        List<TwitterMentionTimelineStrong.yDetails.xDetails> xDetailsList=
            twitterMentionTimelineStrongList.get(position).getEntities().getUser_mentions();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<xDetailsList.size();i++){
            sb.append(
                    "id="+xDetailsList.get(i).getId()+
                            "\nid_str=" + xDetailsList.get(i).getId_str() +
                            "\nname=" + xDetailsList.get(i).getName() +
                            "\nscreen_name=" + xDetailsList.get(i).getScreen_name()
            );
        }
        holder.textViewXP004.setText(sb.toString());

    }
    @Override
    public int getItemCount() {
        return twitterMentionTimelineStrongList.size();  //troublemaker
    }

    public class P004MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageViewCustomRowP004;
        TextView textViewCustomRowP004;
        TextView textViewCustomRowBigP004;
        TextView textViewXP004;
        public P004MyViewHolder(View itemView) {
            super(itemView);
            imageViewCustomRowP004=(ImageView)itemView.findViewById(R.id.imageViewCustomRowP004);
            textViewCustomRowP004=(TextView)itemView.findViewById(R.id.textViewCustomRowP004);
            textViewCustomRowBigP004=(TextView)itemView.findViewById(R.id.textViewCustomRowBigP004);
            textViewXP004= (TextView)itemView.findViewById(R.id.textViewXP004);
        }
    }
}
