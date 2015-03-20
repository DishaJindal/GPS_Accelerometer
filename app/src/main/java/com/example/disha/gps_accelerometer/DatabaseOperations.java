package com.example.disha.gps_accelerometer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by admin on 3/18/2015.
 */
public class DatabaseOperations extends SQLiteOpenHelper {

    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE " + TableData.TableInfo.table_name + "("+
            TableData.TableInfo.lat + " DOUBLE," + TableData.TableInfo.lon +" DOUBLE);";

    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.database_name, null, database_version);
        Log.d("Database open","Database created Successfully");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
        Log.d("Table Created","Table created Successfully");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void Put_Location(DatabaseOperations dop,double lat, double lon){

        SQLiteDatabase sq =  dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.lat, lat);
        cv.put(TableData.TableInfo.lon, lon);
        long k = sq.insert(TableData.TableInfo.table_name, null, cv);
        Log.d("Database","One row inserted");

    }

    public Cursor getLocation(DatabaseOperations dop){
        SQLiteDatabase sq = dop.getReadableDatabase();
        String[] columns = {TableData.TableInfo.lat, TableData.TableInfo.lon};
        Cursor cr = sq.query(TableData.TableInfo.table_name,columns, null,null, null, null,null );
        return cr;
    }
}
