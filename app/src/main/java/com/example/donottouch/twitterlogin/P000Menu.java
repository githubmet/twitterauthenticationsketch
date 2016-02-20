package com.example.donottouch.twitterlogin;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class P000Menu extends Activity implements AdapterView.OnItemClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p000menu);
        ListView listViewMenuP000=(ListView)findViewById(R.id.listViewMenuP000);
        String[] activityName=getResources().getStringArray(R.array.activity_name);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1);
        listViewMenuP000.setAdapter(arrayAdapter);
        arrayAdapter.addAll(activityName);

        listViewMenuP000.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        try {
            Class className= Class.forName("com.example.donottouch.twitterlogin."+
                    parent.getItemAtPosition(position));

            Intent intent =new Intent(P000Menu.this,className);
            startActivity(intent);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
