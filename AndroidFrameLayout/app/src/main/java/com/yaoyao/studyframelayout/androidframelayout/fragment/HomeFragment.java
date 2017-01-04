package com.yaoyao.studyframelayout.androidframelayout.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yaoyao.studyframelayout.androidframelayout.R;
import com.yyydjk.library.BannerLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseLoadingFragment implements View.OnClickListener {

    private LinearLayout layoutLocation;
    private TextView textLocation;
    private RelativeLayout layoutGuestRequest;
    private RelativeLayout layoutOpenDoor;
    private LinearLayout itemServicePhone;
    private BannerLayout bannerHome;
    private RecyclerView recyclerHouseKeep;

    private List<String> bannerImages;
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment getInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    View onCreateContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    private void initData() {
        if (bannerImages == null) {
            bannerImages = new ArrayList<>();
        }
    }

    protected void initUI(View view) {
        super.initUI(view);
        layoutLocation = (LinearLayout) view.findViewById(R.id.layout_location);
        textLocation = (TextView) view.findViewById(R.id.text_location);
        recyclerHouseKeep = (RecyclerView) view.findViewById(R.id.recycler_house_keep);
        layoutGuestRequest = (RelativeLayout) view.findViewById(R.id.layout_guest_request);
        layoutOpenDoor = (RelativeLayout) view.findViewById(R.id.layout_open_door);
        itemServicePhone = (LinearLayout) view.findViewById(R.id.item_service_phone);
        bannerHome = (BannerLayout) view.findViewById(R.id.banner_home);

        layoutLocation.setOnClickListener(this);
        layoutGuestRequest.setOnClickListener(this);
        layoutOpenDoor.setOnClickListener(this);
        itemServicePhone.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_service_phone:

                break;
            case R.id.layout_location:

                break;
            case R.id.layout_guest_request:

                break;
            case R.id.layout_open_door:
                break;
        }
    }

}
