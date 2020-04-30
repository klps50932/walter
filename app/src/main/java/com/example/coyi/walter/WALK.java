package com.example.coyi.walter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.today.step.lib.ISportStepInterface;
import com.today.step.lib.TodayStepManager;
import com.today.step.lib.TodayStepService;

import java.util.List;

public class WALK extends AppCompatActivity {
    int LAVE;

    private static String TAG = "WALK";
    private static final int REFRESH_STEP_WHAT = 0;
    //循环取当前时刻的步数中间的间隔时间
    private long TIME_INTERVAL_REFRESH = 500;
    private Handler mDelayHandler = new Handler(new TodayStepCounterCall());
    private int mStepSum;
    private ISportStepInterface iSportStepInterface;
    private TextView mStepArrayTextView;
    int GOAL;
    int BTN;
    SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk);
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
        BTN = sound.load(this, R.raw.ms_btn , 1);//設定按鈕音效

        // 建立資料庫物件
        Test_Data test=new Test_Data(WALK.this);

        List<Item> items=test.getAll();

        for(Item i:items) {
            GOAL = 6500 + ((int) i.getExamount() * 500);
        }

        //初始化计步模块
        TodayStepManager.init(getApplication());
        mStepArrayTextView = (TextView)findViewById(R.id.stepArrayTextView);
        //开启计步Service，同时绑定Activity进行aidl通信
        Intent intent = new Intent(this, TodayStepService.class);
        startService(intent);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                //Activity和Service通过aidl进行通信
                iSportStepInterface = ISportStepInterface.Stub.asInterface(service);
                try {
                    mStepSum = iSportStepInterface.getCurrentTimeSportStep();
                    updateStepCount();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                mDelayHandler.sendEmptyMessageDelayed(REFRESH_STEP_WHAT, TIME_INTERVAL_REFRESH);

            }
            @Override
            public void onServiceDisconnected(ComponentName name) {
            }
        }, Context.BIND_AUTO_CREATE);
    }
    class TodayStepCounterCall implements Handler.Callback{
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case REFRESH_STEP_WHAT: {
                    //每隔500毫秒获取一次计步数据刷新UI
                    if (null != iSportStepInterface) {
                        int step = 0;
                        try {
                            step = iSportStepInterface.getCurrentTimeSportStep();
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        if (mStepSum != step) {
                            mStepSum = step;
                            updateStepCount();
                        }
                    }
                    mDelayHandler.sendEmptyMessageDelayed(REFRESH_STEP_WHAT, TIME_INTERVAL_REFRESH);
                    break;
                }
            }
            return false;
        }
    }
    private void updateStepCount() {
        Log.e(TAG,"updateStepCount : " + mStepSum);
        TextView stepTextView = (TextView)findViewById(R.id.stepTextView);
        TextView stepLAVE = (TextView)findViewById(R.id.textView11);
        TextView stepGOAL = (TextView)findViewById(R.id.textView10);

        if (mStepSum>=GOAL)
            LAVE=0;
        else
            LAVE = GOAL - mStepSum;

        stepTextView.setText(mStepSum + "步");
        stepLAVE.setText(String.valueOf(LAVE));
        stepGOAL.setText(String.valueOf(GOAL));

        // 建立資料庫物件
        Test_Data test=new Test_Data(WALK.this);
        List<Item> items=test.getAll();
        for(Item i:items) {
            i.setWalkday(mStepSum);
            test.update(i);
        }

    }

    public void toGAME(View v) {
        sound.play(BTN, 1, 1, 0, 0, 1);//按鈕音效
        startActivity(new Intent(WALK.this,GAME.class));finish();
    }
}
