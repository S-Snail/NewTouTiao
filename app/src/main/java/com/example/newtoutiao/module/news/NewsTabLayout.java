package com.example.newtoutiao.module.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newtoutiao.R;

/**
 * Created by 李忠成 on 2018/4/15.
 */

public class NewsTabLayout extends Fragment {

    public static final String TAG = NewsTabLayout.class.getName();
    private static NewsTabLayout instance = null;

    public static NewsTabLayout getInstance(){
        if (instance == null){
            instance = new NewsTabLayout();
            return instance;
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_tab,container,false);
        return view;
    }
}
