package com.example.student.arminianexpresapp.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.student.arminianexpresapp.R;
import com.example.student.arminianexpresapp.adapter.AdapterInfo;
import com.example.student.arminianexpresapp.proviader.UserProvider;

public class InfoActivity extends AppCompatActivity {

    private ImageView image;
    private int[] a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!UserProvider.list.get(UserProvider.position).isToBasket) {
                    UserProvider.list.get(UserProvider.position).isToBasket = true;
                } else {
                    UserProvider.list.get(UserProvider.position).isToBasket = false;
                }
            }
        });
        image = findViewById(R.id.image_info);
        a = UserProvider.list.get(UserProvider.position).getImageId();
        RecyclerView recyclerView = findViewById(R.id.rec_info);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(new AdapterInfo(this, a));
        setUpVidyoView(UserProvider.list.get(UserProvider.position).getVideoUrl());
        RatingBar ratingBar = findViewById(R.id.rading_bar);
        image.setImageResource(UserProvider.list.get(UserProvider.position).getImageId()[0]);
        ratingBar.setRating(UserProvider.list.get(UserProvider.position).getReting());
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                UserProvider.list.get(UserProvider.position).setReting(v);
            }
        });

        TextView textView = findViewById(R.id.text_dec);
        textView.setText(UserProvider.list.get(UserProvider.position).getDescription());

    }

    private void setUpVidyoView(String url) {
        VideoView videoView = findViewById(R.id.video_view);
        videoView.setVideoURI(Uri.parse(url));
        videoView.start();
    }
}
