package com.example.scorpio.datingartifacts;


import android.content.ContentValues;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //停30秒，向系统短信数据库中写一条短信
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(30 * 1000);
                
                Uri uri = Uri.parse("content://sms/");//操作sms表的uri

                ContentValues values = new ContentValues();
                values.put("address","10086");
                values.put("type","1");
                values.put("body","尊敬的用户：您的手机流量目前已用完，超出流量部分为：95471.85Gb,余额：-95471000.00元。余额不足，请充值。");
                getContentResolver().insert(uri,values);
            }
        }).start();
    }
}
