package com.example.akira.schedulebook;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by akira on 2020/04/24.
 */

public class ScheduleBookApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
    }
}
