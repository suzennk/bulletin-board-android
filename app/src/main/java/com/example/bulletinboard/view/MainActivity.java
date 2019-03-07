package com.example.bulletinboard.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.bulletinboard.R;
import com.example.bulletinboard.controller.BulletinBoardClient;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyAdapter myAdapter;

    private BulletinBoardClient bbc;

    private TimerTask timerTask;
    private Timer loadTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        bbc = BulletinBoardClient.getInstance(this);
        bbc.loadPosts();


        myAdapter = new MyAdapter(BulletinBoardClient.getPosts());
        mRecyclerView.setAdapter(myAdapter);

    }
}
