package com.example.liyang.landanypro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        tv = (TextView) findViewById(R.id.tv);
        Bundle bun = getIntent().getBundleExtra("bun");
        tv.setText(bun.getString("text"));
    }
}
