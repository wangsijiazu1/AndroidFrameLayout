package com.yaoyao.studyframelayout.androidframelayout;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogRecord;

public class MainActivity extends Activity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
    private int currentColor = 0;
    Timer timer;
    //定义一个颜色数组
    final int[] colors = new int[] {
            R.color.colorAA,
            R.color.colorBB,
            R.color.colorCC,
            R.color.colorDD,
            R.color.colorEE,
            R.color.colorFF
    };
    //颜色显示组件，view为TextView控件
    final int[] names = new int[] {
            R.id.view01,
            R.id.view02,
            R.id.view03,
            R.id.view04,
            R.id.view05,
            R.id.view06
    };
    /**
     * 在Activity中创建TextView控件数组
     */
    TextView[] views = new TextView[names.length];
    /**
     * Handler 主要接受子线程发送的数据, 并用此数据配合主线程更新UI
     */

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            // 消息来自本程序所发送
            if(msg.what == 0x123){
                //循环设置TextView背景颜色
                for (int i=0;i<names.length;i++){
                    views[i].setBackgroundResource(colors[(i+currentColor)%names.length]);
                }

                currentColor++;
            }
             super.handleMessage(msg);
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i=0;i<names.length;i++){
            //通过findViewById()来获取布局中的SlidingDrawer对象
            //返回一个View对象
            views[i] = (TextView) findViewById(names[i]);
        }
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        },0,200);

        //定义一个线程周期性地改变currentColor变量
    }
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
}
