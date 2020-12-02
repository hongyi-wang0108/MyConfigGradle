package com.example.login2;

import android.app.Application;

import com.example.baselibs.BaseApplication;
import com.example.baselibs.ServiceFactory;

public class LoginApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        init(this);
        initover(this);
        //ServiceFactory.getInstance().setLoginService(new AccountService(LoginUtil.isLogin,LoginUtil.password));
        //ServiceFactory.getInstance()
          //      .setLoginService(new AccountService(LoginUtil.isLogin,LoginUtil.password));
    }

    @Override
    public void init(Application application) {
        ServiceFactory.getInstance()
                .setLoginService(new AccountService(LoginUtil.isLogin,LoginUtil.password));
    }

    @Override
    public void initover(Application application) {

    }
}