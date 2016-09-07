package com.oranle.sports.logic.db.helper;

import com.oranle.sports.logic.db.model.DataBaseModel;
import com.oranle.sports.logic.db.model.DataBaseModel.UserTable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper
{

    private static int version = 1000;
    
    private static String CURRENT_DB_NAME =  DataBaseModel.DB_PREFIX + DataBaseModel.UID + DataBaseModel.DB_SUFFIX;

    public SQLiteHelper(Context context)
    {
        super(context, CURRENT_DB_NAME , null, version);
    }

    public SQLiteHelper(Context context, String name, CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // 创建user表
        createUserTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    /**
     * 创建user表
     * @Description: @return: void @throws
     */
    private void createUserTable(SQLiteDatabase db)
    {
        String CREATE_USER_TABLE_SQL = "create table if not exists " + UserTable.TABLE_NAME 
                + "(" + UserTable.ID + " integer primary key autoincrement,"
                + UserTable.UID + " integer,"
                + UserTable.NICK_NAME + " varchar(10),"
                + UserTable.AGE + " smallint,"
                + UserTable.GENDER + " smallint,"
                + UserTable.HEAD_IMAGE_URL + " text," 
                + UserTable.CITY + " varchar(30),"
                + UserTable.SIGNATURE + " text"
                + ")";
        db.execSQL(CREATE_USER_TABLE_SQL);
    }

}
