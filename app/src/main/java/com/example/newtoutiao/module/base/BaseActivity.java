package com.example.newtoutiao.module.base;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by 李忠成 on 2018/4/9.
 */

public class BaseActivity extends RxAppCompatActivity {

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();
        if (count <= 0){
            super.onBackPressed();
        }else {
         getFragmentManager().popBackStack();
        }
    }
}
