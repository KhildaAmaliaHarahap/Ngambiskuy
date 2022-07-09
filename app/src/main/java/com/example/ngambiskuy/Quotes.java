package com.example.ngambiskuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Quotes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        ImageView imageView = findViewById(R.id.image_view);


        String url = "https://fitriology.files.wordpress.com/2014/03/belajar.png";
        Picasso.get().load(url).into(imageView);

    }
}