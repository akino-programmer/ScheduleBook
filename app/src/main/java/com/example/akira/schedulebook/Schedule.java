package com.example.akira.schedulebook;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by akira on 2020/04/24.
 */

public class Schedule extends RealmObject {
    @PrimaryKey
    public long id;
    public Date date;//予定の日付
    public String title;// 予定のタイトル
    public String detail;// 予定の詳細
}
