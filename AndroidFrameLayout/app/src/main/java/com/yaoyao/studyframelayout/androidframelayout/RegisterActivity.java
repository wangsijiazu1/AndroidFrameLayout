package com.yaoyao.studyframelayout.androidframelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yaoyao.studyframelayout.androidframelayout.untils.ValidateUtil;
import com.yaoyao.studyframelayout.androidframelayout.widget.ClearableEditText;
import com.yaoyao.studyframelayout.androidframelayout.widget.TimeButton;

import java.sql.BatchUpdateException;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private String phone;
    private String code;
    private String password;

    private ClearableEditText textPhone;
    private ClearableEditText textCode;
    private ClearableEditText textPassword;
    private Button btnGetCode;
    private Button btnRegister;
    private Button btnToLogin;
    private Button btnToAgreement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initUI();
        //initTimeButton(savedInstanceState);
    }

    private void initUI() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_comm);
        textTitle = (TextView) findViewById(R.id.text_title);

        textPhone = (ClearableEditText) findViewById(R.id.text_phone);
        textCode = (ClearableEditText) findViewById(R.id.text_code);
        textPassword = (ClearableEditText) findViewById(R.id.text_password);
        btnGetCode = (Button) findViewById(R.id.btn_get_code);
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnToLogin = (Button) findViewById(R.id.btn_to_login);
        btnToAgreement = (Button) findViewById(R.id.btn_to_agreement);

        initToolBar("注册");
        btnRegister.setOnClickListener(this);
        btnToLogin.setOnClickListener(this);
        btnToAgreement.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                if (doValidate()) {

                }
                break;
            case R.id.btn_get_code:
                if (validatePhone()) {
                    //sendSms();
                }
                break;
            case R.id.btn_to_login:
                onBackPressed();
                break;
            case R.id.btn_to_agreement:
                //IntentUtil.redirectAgreement(RegisterActivity.this);
                break;
        }
    }

    private boolean validatePhone() {
        boolean result = true;
        phone = textPhone.getText().toString().trim();
        StringBuilder buffer = new StringBuilder();
        if (phone.equals("")) {
            buffer.append("请填写手机号\n");
        } else if (!ValidateUtil.validatePhone(phone)) {
            buffer.append("请填写有效的手机号\n");
        }
        if (!TextUtils.isEmpty(buffer)) {
            result = false;
        }
        return result;
    }

    private boolean doValidate() {
        boolean result = true;
        phone = textPhone.getText().toString().trim();
        password = textPassword.getText().toString().trim();
        code = textCode.getText().toString().trim();
        StringBuilder buffer = new StringBuilder();
        if (phone.equals("")) {
            buffer.append("请填写手机号\n");
        } else if (!ValidateUtil.validatePhone(phone)) {
            buffer.append("请填写有效的手机号\n");
        } else {
            if (code.equals("")) {
                buffer.append("请填写验证码\n");
            } else if (!ValidateUtil.validateCode(code)) {
                buffer.append("验证码只能是6位数字\n");
            } else {
                if (password.equals("")) {
                    buffer.append("请填写密码\n");
                } else if (!ValidateUtil.validatePassword(password)) {
                    buffer.append("密码只能是6至20位的字母和数字\n");
                }
            }
        }
        return result;
    }
}
