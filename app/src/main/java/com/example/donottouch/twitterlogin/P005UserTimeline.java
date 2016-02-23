package com.example.donottouch.twitterlogin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;


public class P005UserTimeline extends Activity  implements View.OnClickListener {
    ListView listViewP005;
    EditText editTextP005;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p005timeline);

        listViewP005=(ListView)findViewById(R.id.listViewP005);
        Button buttonP005=(Button)findViewById(R.id.buttonP005);
        editTextP005=(EditText)findViewById(R.id.editTextP005);

        buttonP005.setOnClickListener(this);
        //This is not good for a developer. I do not like it :.
    }

    @Override
    public void onClick(View v) {
        if(editTextP005.getText().toString().isEmpty()){
            editTextP005.setText("@iyibidunya");
        }
        if(v.getId()==R.id.buttonP005){
            UserTimeline userTimeline= new UserTimeline.Builder()
                    .screenName(editTextP005.getText().toString())
                    .build();
            TweetTimelineListAdapter tweetTimelineListAdapter=new TweetTimelineListAdapter
                    .Builder(P005UserTimeline.this)
                    .setTimeline(userTimeline)
                    .build();

            listViewP005.setAdapter(tweetTimelineListAdapter);
        }
    }
}
