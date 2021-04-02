package com.example.tools_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetailActivity extends AppCompatActivity {

    private ImageView imageViewDrill;
    private TextView textViewTitle;
    private TextView textViewDrillInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);

        imageViewDrill = findViewById(R.id.imageViewDrillDet);
        textViewTitle = findViewById(R.id.textViewDrillName);
        textViewDrillInfo = findViewById(R.id.textViewDrillInfo);

        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId", -1);
            imageViewDrill.setImageResource(resId);
            textViewTitle.setText(title);
            textViewDrillInfo.setText(info);
        } else {
            Intent backToCategory = new Intent(this, DrillCategoryActivity.class);
            startActivity(backToCategory);
        }
    }
}