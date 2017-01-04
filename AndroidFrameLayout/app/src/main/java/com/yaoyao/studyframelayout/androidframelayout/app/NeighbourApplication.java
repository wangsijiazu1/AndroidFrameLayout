package com.yaoyao.studyframelayout.androidframelayout.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import java.util.Map;


/**
 * Created by Lv on 2016/5/13.
 */
public class NeighbourApplication extends Application {

    public static final int TIMELINE_SUPPORTED_VERSION = 0x21020001;

    private static NeighbourApplication instance;

    private static Handler mHandler;
    //公共的保存信息的地方
    public static SharedPreferences sharedPreferences;
    //用于判断是否登录
    public static boolean hasLogin;
    //用于判断是否绑定
    public static boolean hasBind;
    //蓝牙已连接
    public static boolean blueToothConnected;
    // 用于存放倒计时时间
    public static Map<String, Long> validateTimeMap;

    public static String user_id;

    public static String token;

    public static boolean isAddHouse;

    public static boolean isMineTab;

    public static NeighbourApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initBase();
        sharedPreferences = instance.getSharedPreferences("config", Context.MODE_PRIVATE);
        hasLogin = sharedPreferences.getBoolean("hasLogin", false);
        user_id = sharedPreferences.getString("user_id", "");
        token = sharedPreferences.getString("token", "");
        hasBind = sharedPreferences.getBoolean("hasBind", false);
        isAddHouse = false;
        isMineTab = false;
    }

    public static Handler getHandler() {
        if (mHandler == null) {
            mHandler = new Handler();
        }
        return mHandler;
    }

    private void initBase() {
        instance = this;
        mHandler = new Handler();
        blueToothConnected = false;
    }

}
