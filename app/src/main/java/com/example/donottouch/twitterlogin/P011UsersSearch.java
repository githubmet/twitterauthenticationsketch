package com.example.donottouch.twitterlogin;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.donottouch.twitterlogin.adapter.P011ArrayAdapter;
import com.example.donottouch.twitterlogin.backbone.GetTwitterRetrofitAndNetwork;
import com.example.donottouch.twitterlogin.model.TwitterUserSearchStrong;
import com.example.donottouch.twitterlogin.model.TwitterUsersShowStrong;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class P011UsersSearch extends Activity implements View.OnClickListener {
    String alinanToken;
    String alinanSecret;
    EditText editTextP011;
    ListView listViewP011;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p011userssearch);

        listViewP011= (ListView)findViewById(R.id.listViewP011);
        editTextP011= (EditText)findViewById(R.id.editTextP011);
        Button buttonP011= (Button)findViewById(R.id.buttonP011);
        buttonP011.setOnClickListener(this);

        TwitterSession twitterSession=Twitter.getSessionManager().getActiveSession();
        TwitterAuthToken twitterAuthToken= twitterSession.getAuthToken();
        alinanToken=twitterAuthToken.token;
        alinanSecret=twitterAuthToken.secret;

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonP011){
            GetTwitterRetrofitAndNetwork.getTwitterRetrofit(alinanToken, alinanSecret);
            Call<List<TwitterUserSearchStrong>> twitterUserSearchStrongListCall=
                    GetTwitterRetrofitAndNetwork.getTwitterNetwork()
                            .getUsersSearch(editTextP011.getText().toString());
            twitterUserSearchStrongListCall.enqueue(new Callback<List<TwitterUserSearchStrong>>() {
                @Override
                public void onResponse(Call<List<TwitterUserSearchStrong>> call, Response<List<TwitterUserSearchStrong>> response) {

                    List<TwitterUserSearchStrong> twitterUserSearchStrongList= response.body();
                    ArrayAdapter arrayAdapter=new P011ArrayAdapter(P011UsersSearch.this,
                            R.layout.p011customrow,twitterUserSearchStrongList);

                    listViewP011.setAdapter(arrayAdapter);
                }

                @Override
                public void onFailure(Call<List<TwitterUserSearchStrong>> call, Throwable t) {

                }
            });
        }
    }
}
