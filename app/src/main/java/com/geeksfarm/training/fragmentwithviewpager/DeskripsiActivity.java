package com.geeksfarm.training.fragmentwithviewpager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DeskripsiActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);

        MenuMakanan.Makanan makanan = getIntent().getParcelableExtra("makanan");
        String text = makanan.getDeskripsi();
        textView = findViewById(R.id.tv_desk);
        imageView = findViewById(R.id.iv_desk);
        textView.setText(text);
        imageView.setImageResource(makanan.getImage());
    }
}
