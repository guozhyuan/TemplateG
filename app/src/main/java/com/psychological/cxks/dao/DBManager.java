package com.psychological.cxks.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Author : jugg
 * Date   : 2018/6/25
 */
public class DBManager {

    private DaoMaster master;
    private DaoSession session;
    private SQLiteDatabase db;

    private DBManager() {
    }

    private static DBManager Instance;

    public static DBManager getInstance() {
        synchronized (DBManager.class) {
            if (Instance == null) {
                Instance = new DBManager();
                return Instance;
            }
        }
        return Instance;
    }

    public void init(Context ctx) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(ctx, "guo.sqlite");
        db = helper.getWritableDatabase();
        master = new DaoMaster(db);
        session = master.newSession();
    }


    public DaoSession getDaoSession() {
        return session;
    }

    public DaoMaster getMaster() {
        return master;
    }

    public SQLiteDatabase getDb() {
        return db;
    }



}
