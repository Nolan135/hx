package hx.edu.huatec.com.hx.activity;

import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import hx.edu.huatec.com.hx.R;
import hx.edu.huatec.com.hx.comm.BaseActivity;
import hx.edu.huatec.com.hx.fragment.NavigationFragment;


public class MainActivity extends BaseActivity {

    @Override
    public @LayoutRes
    int getContentViewId(){
        return R.layout.activity_main;
    }
    @Override
    protected void initView(){
        super.initView();
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.fl_main,new NavigationFragment());
        transaction.commit();
    }

}