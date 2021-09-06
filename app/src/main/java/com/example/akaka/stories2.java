package com.example.akaka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class stories2 extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories2);
        textView = findViewById(R.id.txt);
        String dFolktale = getIntent().getStringExtra("Folktale");
        textView.setText(dFolktale);
    }
}