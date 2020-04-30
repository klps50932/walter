package com.example.coyi.walter;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class STORY extends AppCompatActivity {

    private int index=0; //定義類別內的序數
    final static int[] pic = {R.drawable.story_1,R.drawable.story_2,R.drawable.story_3,R.drawable.story_4,R.drawable.story_5,R.drawable.story_6,
            R.drawable.story_7,R.drawable.story_8,R.drawable.story_9,R.drawable.story_10,R.drawable.story_11,R.drawable.story_12
            ,R.drawable.story_13,R.drawable.story_14,R.drawable.story_15,R.drawable.story_16,R.drawable.story_17,R.drawable.story_18
            ,R.drawable.story_19,R.drawable.story_20,R.drawable.story_21,R.drawable.story_22,R.drawable.story_23,R.drawable.story_24,R.drawable.story_25
            ,R.drawable.story_26,R.drawable.story_27,R.drawable.story_28,R.drawable.story_29,R.drawable.story_30};
    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
        BTN = sound.load(this, R.raw.ms_btn , 1);
        ImageView NEXT =(ImageView) findViewById(R.id.imageView34);
        NEXT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ImageView story = (ImageView)findViewById(R.id.imageView36);
                sound.play(BTN, 1, 1, 0, 0, 1);
                index = index+1;
                if (index<30){
                     story.setImageResource(pic[index]);}
                else  {
                    startActivity(new Intent(STORY.this,GAME.class));
                    finish();
                }
            }

        });

    }

    public void toGAME(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);
        Intent intent = new Intent();   //intent實體化
        intent.setClass(STORY.this, GAME.class); // 切到頁面2
        startActivity(intent);
        finish();
    }
}
