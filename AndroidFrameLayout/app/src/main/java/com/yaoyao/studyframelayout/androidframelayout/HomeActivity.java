package com.yaoyao.studyframelayout.androidframelayout;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jaeger.library.StatusBarUtil;
import com.yaoyao.studyframelayout.androidframelayout.app.NeighbourApplication;
import com.yaoyao.studyframelayout.androidframelayout.entity.TabEntity;
import com.yaoyao.studyframelayout.androidframelayout.fragment.HelpFragment;
import com.yaoyao.studyframelayout.androidframelayout.fragment.HomeFragment;
import com.yaoyao.studyframelayout.androidframelayout.fragment.MineFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements OnTabSelectListener  {

    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private HelpFragment helpFragment;
    private MineFragment mineFragment;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private CommonTabLayout mTabLayout;
    private FrameLayout frameMain;

    private String[] mTitles = {"劲邻", "邻里互助", "我"};

    private int[] mIconUnselectIds = {
            R.drawable.tab_home_unselect, R.drawable.tab_help_unselect,
            R.drawable.tab_me_unselect};
    private int[] mIconSelectIds = {
            R.drawable.tab_home_select, R.drawable.tab_help_select,
            R.drawable.tab_me_select};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
        StatusBarUtil.setTranslucent(this, 60);
        fragmentManager = getSupportFragmentManager();
        initData();
        initUI();
    }

    private void initData() {
        NeighbourApplication.isAddHouse = true;
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
    }

    private void initUI() {
        frameMain = (FrameLayout) findViewById(R.id.frame_main);
        mTabLayout = (CommonTabLayout) findViewById(R.id.layout_tab);

        mTabLayout.setTabData(mTabEntities);
        mTabLayout.setCurrentTab(0);
        setTabSelection(0);
        mTabLayout.setOnTabSelectListener(this);
    }

    /**
     * 切换fragment
     */
    private void setTabSelection(int index) {
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                NeighbourApplication.isMineTab = false;
                if (homeFragment == null) {
                    homeFragment = HomeFragment.getInstance();
                    transaction.add(R.id.frame_main, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                NeighbourApplication.isMineTab = false;
                if (helpFragment == null) {
                    helpFragment = HelpFragment.getInstance();
                    transaction.add(R.id.frame_main, helpFragment);
                } else {
                    transaction.show(helpFragment);
                }
                break;
            case 2:
                NeighbourApplication.isMineTab = true;
                if (mineFragment == null) {
                    mineFragment = MineFragment.getInstance();
                    transaction.add(R.id.frame_main, mineFragment);
                } else {
                    transaction.show(mineFragment);
                }
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (helpFragment != null) {
            transaction.hide(helpFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    @Override
    public void onTabSelect(int position) {
        setTabSelection(position);
    }

    @Override
    public void onTabReselect(int position) {

    }

    /**
     * 重写返回键点击事件
     */
    private long mExitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
