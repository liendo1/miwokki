package com.example.miwokki;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mComplitionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<word> words = new ArrayList<word>();



        words.add(new word("red","wetetti",R.drawable.color_red,R.raw.color_red));
        words.add(new word("green","chokokki",R.drawable.color_green,R.raw.color_green));
        words.add(new word("brown","takaakki",R.drawable.color_brown,R.raw.color_brown));
        words.add(new word("gray","topoppi",R.drawable.color_gray,R.raw.color_gray));
        words.add(new word("black","kululli",R.drawable.color_black,R.raw.color_black));
        words.add(new word("white","kelelli",R.drawable.color_white,R.raw.color_white));
        words.add(new word("dusty yellow","topissa",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));





        wordAdapter adapter = new wordAdapter(this,words,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this,word.getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mComplitionListener);
            }
        }); }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

        }

    }
}