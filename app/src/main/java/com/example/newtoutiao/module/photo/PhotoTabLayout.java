package com.example.newtoutiao.module.photo;

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

public class PhotoTabLayout extends Fragment {

    public static final String TAG = PhotoTabLayout.class.getName();
    private static PhotoTabLayout photoTabLayout = null;

    public static PhotoTabLayout getInstace() {
        if (photoTabLayout == null){
            photoTabLayout = new PhotoTabLayout();
            return photoTabLayout;
        }
        return photoTabLayout;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_tab,container,false);
        return view;
    }
}
