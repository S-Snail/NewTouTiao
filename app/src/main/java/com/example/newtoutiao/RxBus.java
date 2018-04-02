package com.example.newtoutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by 李忠成 on 2018/4/1.
 */

public class RxBus {

    //Test
    private ConcurrentHashMap<Object,List<Subject>> subjectMapper = new ConcurrentHashMap<>();

    private RxBus(){

    }

    private static class Holder{
        private static RxBus instance = new RxBus();
    }

    public RxBus getInstance(){
        return Holder.instance;
    }

    public <T> Observable<T> register(Class<T> clzz){
        return register(clzz.getName());
    }

    public <T> Observable<T> register(Object tag){
        List<Subject> subjectList = subjectMapper.get(tag);
        if (null == subjectList){
            subjectList = new ArrayList<>();
            subjectMapper.put(tag,subjectList);
        }

        Subject<T> subject =  PublishSubject.create();
        subjectList.add(subject);

        //注册到RxBus
        return subject;
    }

    public <T> void unregister(Class<T> clzz,Observable observable ){
        unregister(clzz.getName(),observable);
    }

    public void unregister(Object tag,Observable observable){
        List<Subject> subjectList = subjectMapper.get(tag);
        if (subjectList != null){
            subjectList.remove(observable);
            if (subjectList.isEmpty()){
                //从RxBus取消注册
                subjectMapper.remove(tag);
            }
        }
    }
}
