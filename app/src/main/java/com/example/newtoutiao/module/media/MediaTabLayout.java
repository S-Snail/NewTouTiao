package com.example.newtoutiao.module.media;

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

public class MediaTabLayout extends Fragment {

    public static final String TAG = MediaTabLayout.class.getName();
    private static MediaTabLayout instance = null;
    public static MediaTabLayout getInstance() {
        if (instance == null){
            instance = new MediaTabLayout();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_media_tab,container,false);
        return view;
    }
}
