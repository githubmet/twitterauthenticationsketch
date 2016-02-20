package com.example.donottouch.twitterlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    TwitterLoginButton twitterLoginButton;
    Button buttonGoToMyTwitter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textViewIdName=(TextView)findViewById(R.id.textViewIdName);
        buttonGoToMyTwitter=(Button)findViewById(R.id.buttonGoToMyTwitter);
        buttonGoToMyTwitter.setOnClickListener(this);

        twitterLoginButton=(TwitterLoginButton)findViewById
                (R.id.twitterLoginButton);
        twitterLoginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {

                String katar ="Id="+result.data.getId()+"\nUserName="+result.data.getUserName()+
                        "\nToken="+result.data.getAuthToken().token +
                        "\nSecret="+result.data.getAuthToken().secret;
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
        buttonGoToMyTwitter.setEnabled(true);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonGoToMyTwitter){
            Intent intent =new Intent(MainActivity.this,P000Menu.class);
            startActivity(intent);
        }
    }
}
