package com.yaoyao.studyframelayout.androidframelayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yaoyao.studyframelayout.androidframelayout.widget.ClearableEditText;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private String phone;
    private String password;

    private ClearableEditText textPhone;
    private ClearableEditText textPassword;
    private Button btnForgetPsw;
    private Button btnToRegister;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //TODO:为什么顶部的nav没有消失
        initUI();
    }

    private void initUI() {

        toolbar = (Toolbar) findViewById(R.id.toolbar_comm);
        textTitle = (TextView) findViewById(R.id.text_title);

        textPhone = (ClearableEditText) findViewById(R.id.text_phone);
        textPassword = (ClearableEditText) findViewById(R.id.text_password);
        btnToRegister = (Button) findViewById(R.id.btn_to_register);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnForgetPsw = (Button) findViewById(R.id.btn_forget_psw);

        btnLogin.setOnClickListener(this);
        btnToRegister.setOnClickListener(this);
        btnForgetPsw.setOnClickListener(this);

        setToolBar("登录");
    }

    private void setToolBar(String title) {
        setTitle("");
        setSupportActionBar(toolbar);
        textTitle.setText(title);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_to_register:
                //TODO:如何写2个跳转
//                Intent intent = new Intent(this, RegisterActivity.class);
//                startActivity(intent);
                break;
            case R.id.btn_forget_psw:

                break;
        }
    }
}
