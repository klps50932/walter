package com.example.coyi.walter;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BOOK extends AppCompatActivity {

    int hit=0;
    int index;
    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
        BTN = sound.load(this, R.raw.ms_btn , 1);//設定按鈕音效

        Test_Data test=new Test_Data(BOOK.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
            index = (int)i.getPet();
        }

        ImageView book1 = (ImageView) findViewById(R.id.imageView25);
        ImageView book2 = (ImageView) findViewById(R.id.imageView29);
        ImageView book3 = (ImageView) findViewById(R.id.imageView30);
        ImageView book4 = (ImageView) findViewById(R.id.imageView31);
        ImageView book5 = (ImageView) findViewById(R.id.imageView32);
        ImageView book6 = (ImageView) findViewById(R.id.imageView33);
        TextView PAGE = (TextView) findViewById(R.id.textView18);

        PAGE.setText(String.valueOf(1));
        if (7>index && index>0){
            book1.setImageResource(R.drawable.petopen_1);
        }
        else book1.setImageResource(R.drawable.pet_1);
        if (18>=index && index>12){
            book2.setImageResource(R.drawable.petopen_2);
        }
        else book2.setImageResource(R.drawable.pet_2);
        if (13>index && index>6){
            book3.setImageResource(R.drawable.petopen_3);
        }
        else book3.setImageResource(R.drawable.pet_3);
        if (7>index && index>1){
            book4.setImageResource(R.drawable.petopen_4);
        }
        else book4.setImageResource(R.drawable.pet_4);
        if (18>=index && index>13){
            book5.setImageResource(R.drawable.petopen_5);
        }
        else book5.setImageResource(R.drawable.pet_5);

        if (13>index && index>7){
            book6.setImageResource(R.drawable.petopen_6);
        }
        else book6.setImageResource(R.drawable.pet_6);

        ImageView DOWN = (ImageView) findViewById(R.id.imageView8);
        DOWN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
                ImageView book1 = (ImageView) findViewById(R.id.imageView25);
                ImageView book2 = (ImageView) findViewById(R.id.imageView29);
                ImageView book3 = (ImageView) findViewById(R.id.imageView30);
                ImageView book4 = (ImageView) findViewById(R.id.imageView31);
                ImageView book5 = (ImageView) findViewById(R.id.imageView32);
                ImageView book6 = (ImageView) findViewById(R.id.imageView33);
                TextView PAGE = (TextView) findViewById(R.id.textView18);


                hit = hit + 1;
                hit = hit % 3;
                if (hit == 0) {
                    PAGE.setText(String.valueOf(1));
                    if (7>index && index>0){
                        book1.setImageResource(R.drawable.petopen_1);
                    }
                    else book1.setImageResource(R.drawable.pet_1);
                    if (18>=index && index>12){
                        book2.setImageResource(R.drawable.petopen_2);
                    }
                    else book2.setImageResource(R.drawable.pet_2);
                    if (13>index && index>6){
                        book3.setImageResource(R.drawable.petopen_3);
                    }
                    else book3.setImageResource(R.drawable.pet_3);
                    if (7>index && index>1){
                        book4.setImageResource(R.drawable.petopen_4);
                    }
                    else book4.setImageResource(R.drawable.pet_4);
                    if (18>=index && index>13){
                        book5.setImageResource(R.drawable.petopen_5);
                    }
                    else book5.setImageResource(R.drawable.pet_5);

                    if (13>index && index>7){
                        book6.setImageResource(R.drawable.petopen_6);
                    }
                    else book6.setImageResource(R.drawable.pet_6);


                } else if (hit == 1 || hit == -1) {
                    PAGE.setText(String.valueOf(2));
                    if (7>index && index>2){
                        book1.setImageResource(R.drawable.petopen_7);
                    }
                    else book1.setImageResource(R.drawable.pet_7);
                    if (18>=index && index>14){
                        book2.setImageResource(R.drawable.petopen_8);
                    }
                    else book2.setImageResource(R.drawable.pet_8);
                    if (13>index && index>8){
                        book3.setImageResource(R.drawable.petopen_9);
                    }
                    else book3.setImageResource(R.drawable.pet_9);
                    if (7>index && index>3){
                        book4.setImageResource(R.drawable.petopen_10);
                    }
                    else book4.setImageResource(R.drawable.pet_10);
                    if (18>=index && index>15){
                        book5.setImageResource(R.drawable.petopen_11);
                    }
                    else book5.setImageResource(R.drawable.pet_11);

                    if (13>index && index>9){
                        book6.setImageResource(R.drawable.petopen_12);
                    }
                    else book6.setImageResource(R.drawable.pet_12);
                } else {
                    PAGE.setText(String.valueOf(3));
                    if (7>index && index>4){
                        book1.setImageResource(R.drawable.petopen_13);
                    }
                    else book1.setImageResource(R.drawable.pet_13);
                    if (18>=index && index>16){
                        book2.setImageResource(R.drawable.petopen_14);
                    }
                    else book2.setImageResource(R.drawable.pet_14);
                    if (13>index && index>10){
                        book3.setImageResource(R.drawable.petopen_15);
                    }
                    else book3.setImageResource(R.drawable.pet_15);
                    if (6==index){
                        book4.setImageResource(R.drawable.petopen_16);
                    }
                    else book4.setImageResource(R.drawable.pet_16);
                    if (18==index){
                        book5.setImageResource(R.drawable.petopen_17);
                    }
                    else book5.setImageResource(R.drawable.pet_17);

                    if (12==index){
                        book6.setImageResource(R.drawable.petopen_18);
                    }
                    else book6.setImageResource(R.drawable.pet_18);
                }
            }

        });

        ImageView UP = (ImageView) findViewById(R.id.imageView26);
        UP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
                ImageView book1 = (ImageView) findViewById(R.id.imageView25);
                ImageView book2 = (ImageView) findViewById(R.id.imageView29);
                ImageView book3 = (ImageView) findViewById(R.id.imageView30);
                ImageView book4 = (ImageView) findViewById(R.id.imageView31);
                ImageView book5 = (ImageView) findViewById(R.id.imageView32);
                ImageView book6 = (ImageView) findViewById(R.id.imageView33);
                TextView PAGE = (TextView) findViewById(R.id.textView18);

                hit = hit - 1;
                hit = hit % 3;
                if (hit == 0) {
                    PAGE.setText(String.valueOf(1));
                    if (7>index && index>0){
                        book1.setImageResource(R.drawable.petopen_1);
                    }
                    else book1.setImageResource(R.drawable.pet_1);
                    if (18>=index && index>12){
                        book2.setImageResource(R.drawable.petopen_2);
                    }
                    else book2.setImageResource(R.drawable.pet_2);
                    if (13>index && index>6){
                        book3.setImageResource(R.drawable.petopen_3);
                    }
                    else book3.setImageResource(R.drawable.pet_3);
                    if (7>index && index>1){
                        book4.setImageResource(R.drawable.petopen_4);
                    }
                    else book4.setImageResource(R.drawable.pet_4);
                    if (18>=index && index>13){
                        book5.setImageResource(R.drawable.petopen_5);
                    }
                    else book5.setImageResource(R.drawable.pet_5);

                    if (13>index && index>7){
                        book6.setImageResource(R.drawable.petopen_6);
                    }
                    else book6.setImageResource(R.drawable.pet_6);


                } else if (hit == 1 || hit == -1) {
                    PAGE.setText(String.valueOf(2));
                    if (7>index && index>2){
                        book1.setImageResource(R.drawable.petopen_7);
                    }
                    else book1.setImageResource(R.drawable.pet_7);
                    if (18>=index && index>14){
                        book2.setImageResource(R.drawable.petopen_8);
                    }
                    else book2.setImageResource(R.drawable.pet_8);
                    if (13>index && index>8){
                        book3.setImageResource(R.drawable.petopen_9);
                    }
                    else book3.setImageResource(R.drawable.pet_9);
                    if (7>index && index>3){
                        book4.setImageResource(R.drawable.petopen_10);
                    }
                    else book4.setImageResource(R.drawable.pet_10);
                    if (18>=index && index>15){
                        book5.setImageResource(R.drawable.petopen_11);
                    }
                    else book5.setImageResource(R.drawable.pet_11);

                    if (13>index && index>9){
                        book6.setImageResource(R.drawable.petopen_12);
                    }
                    else book6.setImageResource(R.drawable.pet_12);
                } else {
                    PAGE.setText(String.valueOf(3));
                    if (7>index && index>4){
                        book1.setImageResource(R.drawable.petopen_13);
                    }
                    else book1.setImageResource(R.drawable.pet_13);
                    if (18>=index && index>16){
                        book2.setImageResource(R.drawable.petopen_14);
                    }
                    else book2.setImageResource(R.drawable.pet_14);
                    if (13>index && index>10){
                        book3.setImageResource(R.drawable.petopen_15);
                    }
                    else book3.setImageResource(R.drawable.pet_15);
                    if (6==index){
                        book4.setImageResource(R.drawable.petopen_16);
                    }
                    else book4.setImageResource(R.drawable.pet_16);
                    if (18==index){
                        book5.setImageResource(R.drawable.petopen_17);
                    }
                    else book5.setImageResource(R.drawable.pet_17);

                    if (12==index){
                        book6.setImageResource(R.drawable.petopen_18);
                    }
                    else book6.setImageResource(R.drawable.pet_18);
                }
            }
        });

        ImageView toPET1 = (ImageView) findViewById(R.id.imageView25);
        toPET1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效

                if (hit==0 && 7>index && index>0){
                    startActivity(new Intent(BOOK.this, PET1.class));
                    finish();
                }
                else if (hit==1 && 7>index && index>2){
                    startActivity(new Intent(BOOK.this, PET7.class));
                    finish();
                }
                else if(hit==2 && 7>index && index>4) {
                    startActivity(new Intent(BOOK.this, PET13.class));
                    finish();
                }
                else {
                    Toast toast = Toast.makeText(BOOK.this, "圖鑑尚未開啟", Toast.LENGTH_LONG);
                    toast.show();
                }
            }

        });

        ImageView toPET2 = (ImageView) findViewById(R.id.imageView29);
        toPET2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
                Test_Data test=new Test_Data(BOOK.this);
                List<Item> items=test.getAll();
                for(Item i:items) {
                    index = (int)i.getPet();
                }
                if (hit==0 && 18>=index && index>12){
                    startActivity(new Intent(BOOK.this, PET2.class));
                    finish();
                }
                else if (hit==1 && 18>=index && index>14){
                    startActivity(new Intent(BOOK.this, PET8.class));
                    finish();
                }
                else if(hit==2 && 18>=index && index>16) {
                    startActivity(new Intent(BOOK.this, PET14.class));
                    finish();
                }
                else {
                    Toast toast = Toast.makeText(BOOK.this, "圖鑑尚未開啟", Toast.LENGTH_LONG);
                    toast.show();
                }
            }

        });

        ImageView toPET3 = (ImageView) findViewById(R.id.imageView30);
        toPET3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
                Test_Data test=new Test_Data(BOOK.this);
                List<Item> items=test.getAll();
                for(Item i:items) {
                    index = (int)i.getPet();
                }
                if (hit==0 && 13>index && index>6){
                    startActivity(new Intent(BOOK.this, PET3.class));
                    finish();
                }
                else if (hit==1 && 13>index && index>8){
                    startActivity(new Intent(BOOK.this, PET9.class));
                    finish();
                }
                else if(hit==2 && 13>index && index>10) {
                    startActivity(new Intent(BOOK.this, PET15.class));
                    finish();
                }
                else {
                    Toast toast = Toast.makeText(BOOK.this, "圖鑑尚未開啟", Toast.LENGTH_LONG);
                    toast.show();
                }
            }

        });

        ImageView toPET4 = (ImageView) findViewById(R.id.imageView31);
        toPET4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
                Test_Data test=new Test_Data(BOOK.this);
                List<Item> items=test.getAll();
                for(Item i:items) {
                    index = (int)i.getPet();
                }
                if (hit==0 && 7>index && index>1){
                    startActivity(new Intent(BOOK.this, PET4.class));
                    finish();
                }
                else if (hit==1 && 7>index && index>3){
                    startActivity(new Intent(BOOK.this, PET10.class));
                    finish();
                }
                else if(hit==2 && index==6) {
                    startActivity(new Intent(BOOK.this, PET16.class));
                    finish();
                }
                else {
                    Toast toast = Toast.makeText(BOOK.this, "圖鑑尚未開啟", Toast.LENGTH_LONG);
                    toast.show();
                }
            }

        });
        ImageView toPET5 = (ImageView) findViewById(R.id.imageView32);
        toPET5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
                Test_Data test=new Test_Data(BOOK.this);
                List<Item> items=test.getAll();
                for(Item i:items) {
                    index = (int)i.getPet();
                }
                if (hit==0 && 18>=index && index>13){
                    startActivity(new Intent(BOOK.this, PET5.class));
                    finish();
                }
                else if (hit==1 && 18>=index && index>15){
                    startActivity(new Intent(BOOK.this, PET11.class));
                    finish();
                }
                else if(hit==2 && 18==index ) {
                    startActivity(new Intent(BOOK.this, PET17.class));
                    finish();
                }
                else {
                    Toast toast = Toast.makeText(BOOK.this, "圖鑑尚未開啟", Toast.LENGTH_LONG);
                    toast.show();
                }
            }

        });

        ImageView toPET6 = (ImageView) findViewById(R.id.imageView33);
        toPET6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
                Test_Data test=new Test_Data(BOOK.this);
                List<Item> items=test.getAll();
                for(Item i:items) {
                    index = (int)i.getPet();
                }
                if (hit==0 && 13>index && index>7){
                    startActivity(new Intent(BOOK.this, PET6.class));
                    finish();
                }
                else if (hit==1 && 13>index && index>9){
                    startActivity(new Intent(BOOK.this, PET12.class));
                    finish();
                }
                else if(hit==2 && index==12) {
                    startActivity(new Intent(BOOK.this, PET18.class));
                    finish();
                }
                else {
                    Toast toast = Toast.makeText(BOOK.this, "圖鑑尚未開啟", Toast.LENGTH_LONG);
                    toast.show();
                }
            }

        });
    }
    public void toGAME(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(BOOK.this,GAME.class));finish();
    }



}
