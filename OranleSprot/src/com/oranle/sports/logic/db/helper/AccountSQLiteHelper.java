package com.oranle.sports.logic.db.helper;

import com.oranle.sports.logic.db.model.DataBaseModel;
import com.oranle.sports.logic.db.model.DataBaseModel.AccountTable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AccountSQLiteHelper extends SQLiteOpenHelper
{

    private static int version = 1000;

    private static String CURRENT_DB_NAME = DataBaseModel.DB_PREFIX + DataBaseModel.ACCOUNT
            + DataBaseModel.DB_SUFFIX;

    public AccountSQLiteHelper(Context context)
    {
        super(context, CURRENT_DB_NAME, null, version);
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
     * 创建账户表
     * 
     * @Description: @return: void @throws
     */
    private void createUserTable(SQLiteDatabase db)
    {
        String CREATE_USER_TABLE_SQL = "create table if not exists " + AccountTable.TABLE_NAME 
                + "(" + AccountTable.ID + " integer primary key autoincrement,"
                + AccountTable.UID + " integer,"
                + AccountTable.NICK_NAME + " varchar(10),"
                + AccountTable.PASSWORD + " char(8),"
                + AccountTable.HEAD_IMAGE_URL + " text,"
                + AccountTable.CREATE_TIME + " text" 
                + ")";
        db.execSQL(CREATE_USER_TABLE_SQL);
    }

}
