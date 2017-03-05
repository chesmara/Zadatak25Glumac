package com.example.androiddevelopment.zadatak20glumac.db;

/**
 * Created by SNinkovic_ns on 4.3.2017.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.example.androiddevelopment.zadatak20glumac.db.model.Glumac;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME  = "orimlite.db";
    private static final int DATABASE_VERSION =1;

    private Dao<Glumac, Integer> mGlumacDao= null;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource,Glumac.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
            //e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            TableUtils.dropTable(connectionSource, Glumac.class,true);
            onCreate(db,connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
            //e.printStackTrace();
        }

    }
       public Dao<Glumac,Integer> getGlumacDao() throws SQLException {
           if(mGlumacDao== null){
               mGlumacDao=getDao(Glumac.class);
           }
           return mGlumacDao;
       }
        @Override
        public void close(){
            mGlumacDao= null;

            super.close();
        }

}
