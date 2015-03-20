package com.example.disha.gps_accelerometer;


import android.provider.BaseColumns;

/**
 * Created by admin on 3/18/2015.
 */
public class TableData {

    public TableData(){

    }

    public static abstract class TableInfo implements BaseColumns{

        public static final String lat = "latitude";
        public static final String lon = "longitude";
        public static final String database_name = "Driving";
        public static final String table_name = "location";


    }
}