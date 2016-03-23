package com.sinisa.slovarica;

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

    ImageButton forward, backward;
    FrameLayout frameLayout;
    Utilities ids = new Utilities();
    int number = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ucim_activity);
        setUpToolbar();

        forward = (ImageButton)findViewById(R.id.forward);
        backward = (ImageButton)findViewById(R.id.backward);
        frameLayout = (FrameLayout)findViewById(R.id.frameLayout);
        frameLayout.setBackgroundResource((Integer) ids.getIds().get(number));

        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                if (number<0){
                    number = 29;
                }
                if (number > 29){
                    number = 0;
                }
                frameLayout.setBackgroundResource((Integer) ids.getIds().get(number));
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                if (number<0){
                    number = 29;
                }
                if (number > 29){
                    number = 0;
                }
                frameLayout.setBackgroundResource((Integer) ids.getIds().get(number));
            }
        });

        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number--;
                if (number<0){
                    number = 29;
                }
                if (number > 29){
                    number = 0;
                }
                frameLayout.setBackgroundResource((Integer) ids.getIds().get(number));
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
}
