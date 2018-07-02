package com.example.newtoutiao.module.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.newtoutiao.R;
import com.example.newtoutiao.module.news.channel.NewsChannelActivity;

/**
 * Created by 李忠成 on 2018/4/15.
 */

public class NewsTabLayout extends Fragment {

    public static final String TAG = NewsTabLayout.class.getName();
    private static NewsTabLayout instance = null;
    private ViewPager viewPager;

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
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        TabLayout tabLayout = view.findViewById(R.id.tab_layout_news);
        viewPager = view.findViewById(R.id.view_pager_news);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        ImageView add_channel_iv = view.findViewById(R.id.add_channel_iv);
        add_channel_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),NewsChannelActivity.class));
            }
        });
    }

    private void initData() {
        initTabs();
    }

    private void initTabs() {

    }
}
