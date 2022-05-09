package com.example.a4514_internal_mc_lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String dbname = "4514data.db";
    private static final String tablename="inventory_management";

    public DBHelper(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table "+tablename+"( name TEXT PRIMARY KEY,id TEXT,mom TEXT,yom TEXT,cate TEXT,price TEXT,Quantity TEXT,moe TEXT,yoe TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists "+tablename);
    }
    public Boolean insertmethod(String name,String  id,String  mom,String  yom,String  cate,String  price,String  quantity,String  moe,String  yoe){
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("id",id);
        cv.put("mom",mom);
        cv.put("yom",yom);
        cv.put("cate",cate);
        cv.put("price",price);
        cv.put("quantity",quantity);
        cv.put("moe",moe);
        cv.put("yoe",yoe);
        SQLiteDatabase DB=this.getWritableDatabase();
        long res=DB.insert(tablename,null,cv);
        if(res==-1)
            return false;
        else
            return true;
    }
    public Boolean updatemethod(String name,String  id,String  mom,String  yom,String  cate,String  price,String  quantity,String  moe,String  yoe){
        ContentValues cv=new ContentValues();
        cv.put("id",id);
        cv.put("mom",mom);
        cv.put("yom",yom);
        cv.put("cate",cate);
        cv.put("price",price);
        cv.put("quantity",quantity);
        cv.put("moe",moe);
        cv.put("yoe",yoe);
        SQLiteDatabase DB=this.getWritableDatabase();
        long res=DB.update(tablename,cv,"name=?",new String[]{name});
        if(res!=-1)
            return true;
        else
            return false;
    }
    public Cursor getData(){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor c1=DB.rawQuery("select * from "+tablename,null);
        return c1;
    }

    public void newmethod() {
        SQLiteDatabase DB=this.getWritableDatabase();
        DB.execSQL("drop table if exists "+tablename);

        DB.execSQL("create table "+tablename+"( name TEXT PRIMARY KEY,id TEXT,mom TEXT,yom TEXT,cate TEXT,price TEXT,Quantity TEXT,moe TEXT,yoe TEXT)");

    }
}
