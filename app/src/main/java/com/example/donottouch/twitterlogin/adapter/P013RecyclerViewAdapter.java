package com.example.donottouch.twitterlogin.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.donottouch.twitterlogin.R;
import com.example.donottouch.twitterlogin.model.TwitterFollowerListStrong;
import com.squareup.picasso.Picasso;

import java.util.List;

public class P013RecyclerViewAdapter extends RecyclerView.Adapter<P013RecyclerViewAdapter.MyViewHolderP013> {  //<VH>

    LayoutInflater layoutInflater;
    List<TwitterFollowerListStrong.xDetailsP013> xDetailsP013List;
    Context context;
    public P013RecyclerViewAdapter(Context context, List<TwitterFollowerListStrong
            .xDetailsP013> xDetailsP013List) {
        layoutInflater=(LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        this.xDetailsP013List=xDetailsP013List;
        this.context=context;
    }

    @Override
    public P013RecyclerViewAdapter.MyViewHolderP013 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.p013customrow,parent,false);
        MyViewHolderP013 myViewHolderP013=new MyViewHolderP013(view);
        return myViewHolderP013;
    }

    @Override
    public void onBindViewHolder(P013RecyclerViewAdapter.MyViewHolderP013 holder, int position) {
        TwitterFollowerListStrong.xDetailsP013  xDetailsP013= xDetailsP013List.get(position);
        holder.textViewCustomRowP013.setText(xDetailsP013.toString());

        Picasso.with(context)
                .load(xDetailsP013.getProfile_image_url_https())
                .into(holder.imageViewCustomRowLeftP013);

        Picasso.with(context)
                .load(xDetailsP013.getProfile_background_image_url_https())
                .into(holder.imageViewCustomRowRightP013);
    }

    @Override
    public int getItemCount() {  //bela
        return xDetailsP013List.size();
    }

    public class MyViewHolderP013 extends RecyclerView.ViewHolder{

        ImageView imageViewCustomRowLeftP013;
        ImageView imageViewCustomRowRightP013;
        TextView textViewCustomRowP013;
        public MyViewHolderP013(View itemView) {
            super(itemView);
            textViewCustomRowP013= (TextView)itemView.findViewById
                    (R.id.textViewCustomRowP013);
            imageViewCustomRowLeftP013=(ImageView)itemView.findViewById
                    (R.id.imageViewCustomRowLeftP013);
            imageViewCustomRowRightP013=(ImageView)itemView.findViewById
                    (R.id.imageViewCustomRowRightP013);
        }
    }
}
