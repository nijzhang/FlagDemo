package com.example.a15625.flagdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class showFlag extends AppCompatActivity {

    TextView textView ;
    ImageView imageView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_flag);

        textView = (TextView)findViewById(R.id.textView2);
        imageView = (ImageView)findViewById(R.id.image2);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        int imageId = Integer.parseInt(intent.getStringExtra("image"));

        textView.setText(""+name);
        imageView.setImageResource(imageId);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(RESULT_OK,intent);
        finish();
    }
}
