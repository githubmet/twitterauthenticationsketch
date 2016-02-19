package com.example.donottouch.twitterlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.List;

import com.example.donottouch.twitterlogin.backbone.GetTwitterRetrofitAndNetwork;
import com.example.donottouch.twitterlogin.model.TwitterFollowerStrong;
import com.example.donottouch.twitterlogin.model.User;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TwitterLoginButton twitterLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView= (ListView)findViewById(R.id.listView);
        final TextView textViewIdName=(TextView)findViewById(R.id.textViewIdName);

        twitterLoginButton=(TwitterLoginButton)findViewById
                (R.id.twitterLoginButton);
        twitterLoginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {


                String tokenSecret="Token="+result.data.getAuthToken().token+
                        "\nSecret="+result.data.getAuthToken().secret;

                String katar ="Id="+result.data.getId()+"\nUserName="+result.data.getUserName();
                textViewIdName.setText(katar);
            }

            @Override
            public void failure(TwitterException e) {
                Toast.makeText(MainActivity.this,"Bad Authentication",Toast.LENGTH_LONG).show();
            }
        });
    }
    //Next, pass the result of Authentication Activity back to the button
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Pass the activity result to the login button.
        twitterLoginButton.onActivityResult(requestCode, resultCode, data);
    }
}




/*
GetTwitterRetrofitAndNetwork.getTwitterRetrofit(
result.data.getAuthToken().token,result.data.getAuthToken().secret);
GetTwitterRetrofitAndNetwork.getTwitterNetwork()
.getFollowers("-1", "iyibidunya")
.enqueue(new retrofit2.Callback<TwitterFollowerStrong>() {
@Override
public void onResponse(Call<TwitterFollowerStrong> call, Response<TwitterFollowerStrong> response) {
    List<User> userList=response.body().getUsers();

    ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,
            android.R.layout.simple_list_item_1,userList);
    listView.setAdapter(arrayAdapter);
}

@Override
public void onFailure(Call<TwitterFollowerStrong> call, Throwable t) {

}
});*/