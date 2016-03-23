package com.sinisa.slovarica;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

/**
 * Created by SINISA on 8.3.2016..
 */
public class UcimActivity extends AppCompatActivity {

    private int next;
    private SoundPool soundPool;
    private boolean loaded;

    private ImageButton forward, backward;
    private FrameLayout frameLayout;
    private Utilities ids = new Utilities();
    private int number = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ucim_activity);

        initSounds();
        setUpToolbar();

        forward = (ImageButton)findViewById(R.id.forward);
        backward = (ImageButton)findViewById(R.id.backward);
        frameLayout = (FrameLayout)findViewById(R.id.frameLayout);
        frameLayout.setBackgroundResource((Integer) ids.getIdsLearning().get(number));

        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playRightAnswer();
                number++;
                if (number<0){
                    number = 29;
                }
                if (number > 29){
                    number = 0;
                }
                frameLayout.setBackgroundResource((Integer) ids.getIdsLearning().get(number));
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playRightAnswer();
                number++;
                if (number<0){
                    number = 29;
                }
                if (number > 29){
                    number = 0;
                }
                frameLayout.setBackgroundResource((Integer) ids.getIdsLearning().get(number));
            }
        });

        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playRightAnswer();
                number--;
                if (number<0){
                    number = 29;
                }
                if (number > 29){
                    number = 0;
                }
                frameLayout.setBackgroundResource((Integer) ids.getIdsLearning().get(number));
            }
        });

    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    public void playRightAnswer() {
        if (loaded){
            soundPool.play(next,1F,1F,0,0,1F);
        }
    }

    @Override
    protected void onPause() {
        soundPool.release();
        super.onPause();
    }
    private void initSounds() {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, AudioManager.ADJUST_SAME);

        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });
        next = soundPool.load(this, R.raw.wrong_answer, 1);
    }
}
