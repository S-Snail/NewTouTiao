package com.example.newtoutiao;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.newtoutiao.module.base.BaseActivity;
import com.example.newtoutiao.module.media.MediaTabLayout;
import com.example.newtoutiao.module.news.NewsTabLayout;
import com.example.newtoutiao.module.photo.PhotoTabLayout;
import com.example.newtoutiao.module.video.VideoTabLayout;
import com.example.newtoutiao.widget.helper.BottomNavigationViewHelp;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Toolbar toolbar;
    private BottomNavigationView bottom_navigationview;

    private static final int FRAGMENT_NEWS = 0;
    private static final int FRAGMENT_PHOTO = 1;
    private static final int FRAGMENT_VIDEO = 2;
    private static final int FRAGMENT_MEDIA = 3;
    private NewsTabLayout newsTabLayout;
    private PhotoTabLayout photoTabLayout;
    private VideoTabLayout videoTabLayout;
    private MediaTabLayout mediaTabLayout;

    private static final String POSITION = "position";
    private static final String SELECT_ITEM = "bottomNavigationSelectItem";
    private int position;

    private long exit_time = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        if (savedInstanceState != null){
            newsTabLayout = (NewsTabLayout) getSupportFragmentManager().findFragmentByTag(NewsTabLayout.class.getName());
            photoTabLayout = (PhotoTabLayout) getSupportFragmentManager().findFragmentByTag(PhotoTabLayout.class.getName());
            videoTabLayout = (VideoTabLayout) getSupportFragmentManager().findFragmentByTag(VideoTabLayout.class.getName());
            mediaTabLayout = (MediaTabLayout) getSupportFragmentManager().findFragmentByTag(MediaTabLayout.class.getName());
            //恢复recreate前的位置；
            showFragment(savedInstanceState.getInt(POSITION));
            bottom_navigationview.setSelectedItemId(savedInstanceState.getInt(SELECT_ITEM));
        }else {
            showFragment(FRAGMENT_NEWS);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(POSITION, position);
        outState.putInt(SELECT_ITEM, bottom_navigationview.getSelectedItemId());
    }

    private void showFragment(int index) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        hideFragment(ft);
        position = index;
        switch(index){
            case FRAGMENT_NEWS:
                toolbar.setTitle(R.string.app_name);
                if (newsTabLayout == null){
                    newsTabLayout = NewsTabLayout.getInstance();
                    ft.add(R.id.container,newsTabLayout,NewsTabLayout.TAG);
                }else {
                    ft.show(newsTabLayout);
                }
                break;
            case FRAGMENT_PHOTO:
                toolbar.setTitle(R.string.title_photo);
                if (photoTabLayout == null){
                    photoTabLayout = PhotoTabLayout.getInstace();
                    ft.add(R.id.container,photoTabLayout,PhotoTabLayout.TAG);
                }else{
                    ft.show(photoTabLayout);
                }
                break;
            case FRAGMENT_VIDEO:
                toolbar.setTitle(R.string.title_video);
                if (videoTabLayout == null){
                    videoTabLayout = VideoTabLayout.getInstance();
                    ft.add(R.id.container,videoTabLayout,VideoTabLayout.TAG);
                }else {
                    ft.show(videoTabLayout);
                }
                break;
            case FRAGMENT_MEDIA:
                toolbar.setTitle(R.string.title_media);
                if (mediaTabLayout == null){
                    mediaTabLayout = MediaTabLayout.getInstance();
                    ft.add(R.id.container,mediaTabLayout,MediaTabLayout.TAG);
                }else {
                    ft.show(mediaTabLayout);
                }
                break;
        }
        ft.commit();
    }

    private void hideFragment(FragmentTransaction ft) {
        if (newsTabLayout != null){
            ft.hide(newsTabLayout);
        }
        if (photoTabLayout != null){
            ft.hide(photoTabLayout);
        }
        if (videoTabLayout != null){
            ft.hide(videoTabLayout);
        }
        if (mediaTabLayout != null){
            ft.hide(mediaTabLayout);
        }
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_activity_main);
        bottom_navigationview = findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelp.disableShiftingMode(bottom_navigationview);
        setSupportActionBar(toolbar);
        bottom_navigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_news:
                        showFragment(FRAGMENT_NEWS);
                        break;
                    case R.id.action_photo:
                        showFragment(FRAGMENT_PHOTO);
                        break;
                    case R.id.action_video:
                        showFragment(FRAGMENT_VIDEO);
                        break;
                    case R.id.action_media:
                        showFragment(FRAGMENT_MEDIA);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        long curret_time = System.currentTimeMillis();
        if (curret_time - exit_time < 2000){
            super.onBackPressed();
        }else {
            Toast.makeText(this, R.string.double_click_exit, Toast.LENGTH_SHORT).show();
            exit_time = curret_time;
        }
    }
}
