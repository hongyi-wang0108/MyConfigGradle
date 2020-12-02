/*package com.example.myconfiggradle.app;

import android.app.Application;

import com.alibaba.android.arouter.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //ARouter后台有ILogger接口，定义了一些输出日志
        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化ARouter

        /*init(this);
        initover(this);*/



   /* private void initover(MainApplication mainApplication) {
    }

    private void init(MainApplication mainApplication) {
    }*/

   /* private boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}*/

package com.example.myconfiggradle.app;
import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibs.AppConfig;
import com.example.baselibs.BaseApplication;

public class MainApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
      //ARouter后台有ILogger接口，定义了一些输出日志
        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            Log.d("1111","1111");
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.openDebug();
        ARouter.init(this);
        //init(this);
        //initover(this);

    }

    private boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    public void init(Application application) {
        for(String moduleApp : AppConfig.moduleApps){//AppConfig中是moduleApp的类名
            try{                                       //"com.example.login2.LoginApplication"
                Class clazz = Class.forName(moduleApp);//通过类名字对应的类
                BaseApplication baseApplication = null;
                baseApplication = (BaseApplication) clazz.newInstance();//类赋给baseApplication
                baseApplication.init(this);//初始化类，调用login的init方法
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initover(Application application) {
        for(String moduleApp : AppConfig.moduleApps){
            try{
                Class clazz = Class.forName(moduleApp);
                BaseApplication baseApplication = null;
                baseApplication = (BaseApplication) clazz.newInstance();
                baseApplication.initover(this);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}