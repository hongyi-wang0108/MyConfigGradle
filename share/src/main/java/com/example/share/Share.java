package com.example.share;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.baselibs.ServiceFactory;
import com.example.module_login.R;
import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/share/share1")
public class Share extends AppCompatActivity {
    private Button tv_share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        tv_share = findViewById(R.id.tv_share);
        tv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ServiceFactory.getInstance().getLoginService().isLogin() )
                ){
                    Toast.makeText(Share.this,"分享成功！",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Share.this,"分享失败，请先登录！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}