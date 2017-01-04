package com.yaoyao.studyframelayout.androidframelayout.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yaoyao.studyframelayout.androidframelayout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {

    protected Activity mActivity;
    protected void initUI(View view) {

    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base, container, false);
    }

    protected Toolbar initToolBar(View view, int resId, String title) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_comm);
        TextView titleText = (TextView) view.findViewById(R.id.text_title);
        toolbar.setTitle("");
        toolbar.inflateMenu(resId);
        titleText.setText(title);
        return toolbar;
    }

}
