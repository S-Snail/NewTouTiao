package com.example.newtoutiao.module.video;

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

public class VideoTabLayout extends Fragment {

    public static final String TAG = VideoTabLayout.class.getName();
    private static VideoTabLayout instance = null;
    public static VideoTabLayout getInstance() {
        if (instance == null){
            instance = new VideoTabLayout();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_tab,container,false);
        return view;
    }
}
