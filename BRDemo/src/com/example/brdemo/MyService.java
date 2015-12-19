package com.example.brdemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
//系统使用MediaPlayer播放音乐，定义对象mp
    private MediaPlayer mey;
    private String TAG="Main";
    @Override
    public IBinder onBind(Intent intent) { 
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
//初始化MediaPlayer对象，准备播放音乐，音乐文件放在文件夹/res/raw中
        mey = MediaPlayer.create(MyService.this, R.raw.zhou);
	    Intent intent = new Intent();  
        intent.putExtra("control", 1);  
        sendBroadcast(intent);
        mey.start();
        Log.i(TAG, "MusicService onCreate被运行");
    }
    
  @Override
public int onStartCommand(Intent intent, int flags, int startId) {
	// TODO Auto-generated method stub
//开始播放音乐
	 mey.start();
	 Log.i(TAG, "MusicService onStartCommand被运行");
	 return super.onStartCommand(intent, flags, startId);
	
}

    @Override
    public void onDestroy() {
        super.onDestroy();
        //停止播放音乐
            mey.stop();
        Log.i(TAG, "MusicService onDestroy被运行");
    }

}