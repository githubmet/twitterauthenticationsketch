package com.example.donottouch.twitterlogin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;


public class P006SearchTimeline extends Activity implements View.OnClickListener {
    EditText editTextP006;
    ListView listViewP006;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p006searchtimeline);

        editTextP006= (EditText)findViewById(R.id.editTextP006);
        Button buttonP006= (Button)findViewById(R.id.buttonP006);
        listViewP006= (ListView)findViewById(R.id.listViewP006);

        buttonP006.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(editTextP006.getText().toString().isEmpty()){
            editTextP006.setText("#nightcore");
        }

        if(v.getId()==R.id.buttonP006){
            SearchTimeline searchTimeline=new SearchTimeline.Builder()
                    .query(editTextP006.getText().toString())
                    .build();
               TweetTimelineListAdapter tweetTimelineListAdapter= new TweetTimelineListAdapter
                       .Builder(P006SearchTimeline.this)
                       .setTimeline(searchTimeline)
                       .build();
            listViewP006.setAdapter(tweetTimelineListAdapter);
        }
    }
}
