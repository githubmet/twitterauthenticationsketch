package com.example.donottouch.twitterlogin.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.donottouch.twitterlogin.R;
import com.example.donottouch.twitterlogin.model.TwitterReweetsOfMeStrong;

import java.util.List;

public class P004RecyclerViewAdapter extends RecyclerView.Adapter<P004RecyclerViewAdapter.P004MyViewHolder> { //<VH> hint

    LayoutInflater layoutInflater;
    List<TwitterReweetsOfMeStrong> twitterReweetsOfMeStrongList;
    public P004RecyclerViewAdapter(Context context,
                                   List<TwitterReweetsOfMeStrong> twitterReweetsOfMeStrongList) {
        layoutInflater=(LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.twitterReweetsOfMeStrongList=twitterReweetsOfMeStrongList;
    }

    @Override
    public P004RecyclerViewAdapter.P004MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.p004customrow,parent,false);
        P004MyViewHolder p004MyViewHolder=new P004MyViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(P004RecyclerViewAdapter.P004MyViewHolder holder, int position) {
        holder.textViewCustomRowP004.setText(twitterReweetsOfMeStrongList
                .get(position).getId());
    }

    @Override
    public int getItemCount() {
        return twitterReweetsOfMeStrongList.size();  //troublemaker
    }

    public class P004MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageViewCustomRowP004;
        TextView textViewCustomRowP004;
        public P004MyViewHolder(View itemView) {
            super(itemView);
            imageViewCustomRowP004=(ImageView)itemView.findViewById(R.id.imageViewCustomRowP004);
            textViewCustomRowP004=(TextView)itemView.findViewById(R.id.textViewCustomRowP004);
        }
    }
}
