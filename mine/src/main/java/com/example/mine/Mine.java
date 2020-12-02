package com.example.mine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.module_login.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import eventbus.EventMessage;

@Route(path = "/mine/mine1")
public class Mine extends AppCompatActivity {
    TextView tv_mine;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        tv_mine = findViewById(R.id.tv_mine);

        EventBus.getDefault().register(this);
    }
    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void showEventMessage(EventMessage message){
        tv_mine.setText(message.getAccount());
    }

}