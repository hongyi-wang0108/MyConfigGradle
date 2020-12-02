package com.example.login2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.baselibs.ServiceFactory;
import com.example.module_login.R;

import org.greenrobot.eventbus.EventBus;

import eventbus.EventMessage;

@Route(path = "/login/login1")
public class Login2 extends AppCompatActivity {
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUtil.isLogin = true;
                LoginUtil.password = "admin";
                ServiceFactory.getInstance()
                 .setLoginService(new AccountService(LoginUtil.isLogin,LoginUtil.password ));
                EventBus.getDefault().post(new EventMessage(LoginUtil.password));
                EventBus.getDefault().postSticky(new EventMessage(LoginUtil.password));
            }
        });
    }
}