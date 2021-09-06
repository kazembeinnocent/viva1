package com.example.akaka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class stories extends AppCompatActivity {
   ListView listView;
//    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);

        String[] tFolktale = getResources().getStringArray(R.array.title_folktale);
        String [] dFolktale = getResources().getStringArray(R.array.details_folktale);
        listView = (ListView) findViewById(R.id.listViewId);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(stories.this,R.layout.sample_view,tFolktale);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String t = dFolktale[position];
                Intent intent = new Intent(stories.this,stories2.class);
                intent.putExtra("Folktale",t);
                startActivity(intent);
            }
        });
    }
}