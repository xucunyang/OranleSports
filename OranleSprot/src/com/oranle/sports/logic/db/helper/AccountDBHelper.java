package com.oranle.sports.logic.db.helper;

import java.util.ArrayList;
import java.util.List;

import com.oranle.sports.logic.db.model.DataBaseModel.AccountTable;
import com.oranle.sports.logic.model.Account;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 账户 数据库操作类
 * @author: Oranle
 * @date: 2016年8月19日 下午10:27:03
 * @最后修改人: Oranle
 * @最后修改时间: 2016年8月19日 下午10:27:03
 */
public class AccountDBHelper
{

    /**
     * 数据库操作类
     */
    private final AccountSQLiteHelper sqLiteHelper;

    /**
     * 数据库对象
     */
    private SQLiteDatabase sqliter;

    /**
     * 单实例
     */
    private static AccountDBHelper sInstance;

    public synchronized static AccountDBHelper getInstance(Context context)
    {
        if (null == sInstance)
        {
            sInstance = new AccountDBHelper(context);
        }
        return sInstance;
    }

    /**
     * 构造函数
     * 
     * @param context
     */
    public AccountDBHelper(Context context)
    {
        sqLiteHelper = new AccountSQLiteHelper(context);
    }

    /**
     * 插入数据库 @return: void @throws
     */
    public void insert(Account account)
    {
        String sql = "insert into " + AccountTable.TABLE_NAME
                + "(" 
                + AccountTable.UID + ", " 
                + AccountTable.NICK_NAME + ", " 
                + AccountTable.PASSWORD + ", "
                + AccountTable.HEAD_IMAGE_URL + ", "
                + AccountTable.CREATE_TIME 
                + ")" 
                + " values(?, ?, ?, ?, ?)";

        String[] argms = new String[]
        { 
                account.getUID() + "", 
                account.getNickName() + "", 
                account.getPassword(), 
                account.getHeadImageUrl() + "", 
                account.getCreateTime() + ""
        };

        dbWriteOperator(sql, argms);

    }

    /**
     * 删除 
     * @return: void @throws
     */
    public void delete(int uid)
    {
        String sql = "delete from " + AccountTable.TABLE_NAME + " where " + AccountTable.UID + "=?";
        String[] argms = new String[]
        { uid + "" };
        dbWriteOperator(sql, argms);
    }

    /**
     * 更新 @return: void @throws
     */
    public void update(Account account)
    {
        String sql = "update " + AccountTable.TABLE_NAME + " set " 
                + AccountTable.NICK_NAME + "=?, " 
                + AccountTable.PASSWORD + "=?, " 
                + AccountTable.HEAD_IMAGE_URL + "=?, " 
                + AccountTable.CREATE_TIME + "=? " 
                + "  where "
                + AccountTable.UID + "=?";
        String[] argms = new String[]
        { 
                account.getNickName(),
                account.getPassword(),
                account.getHeadImageUrl(),
                account.getCreateTime() + "",
                account.getUID() + ""
        };
        dbWriteOperator(sql, argms);
    }

    public List<Account> getAllAccount()
    {
        return query("", null);
    }

    /**
     * 根据条件查询数据库 @return: List<User> @throws
     */
    private List<Account> query(String where, String[] argms)
    {
        // 数据库操作对象
        sqliter = sqLiteHelper.getReadableDatabase();
        // 拼接sql语句
        String sql = "select * from " + AccountTable.TABLE_NAME + where;
        // 查询数据库
        Cursor cursor = sqliter.rawQuery(sql, argms);

        List<Account> userList = getAccountsFromCursor(cursor);

        if (!cursor.isClosed())
        {
            cursor.close();
        }

        sqliter.close();

        return userList;

    }

    
    /**
     *  遍历cursor取值封装
     * @return: List<Account>
     * @throws
     */
    private List<Account> getAccountsFromCursor(Cursor cursor)
    {
        List<Account> accountList = new ArrayList<Account>();

        if (null == cursor)
        {
            return accountList;
        }

        while (cursor.moveToNext())
        {
            Account account = new Account();
            account.setUID(cursor.getLong(cursor.getColumnIndex(AccountTable.UID)));
            account.setCreateTime(cursor.getLong(cursor.getColumnIndex(AccountTable.CREATE_TIME)));
            account.setHeadImageUrl(cursor.getString(cursor.getColumnIndex(AccountTable.HEAD_IMAGE_URL)));
            account.setNickName(cursor.getString(cursor.getColumnIndex(AccountTable.NICK_NAME)));
            account.setPassword(cursor.getString(cursor.getColumnIndex(AccountTable.PASSWORD)));

            accountList.add(account);
        }
        return accountList;

    }

    /**
     * 对数据库对象进行管理，获得、执行、关闭等操作 
     * @return: void @throws
     */
    private void dbWriteOperator(String sql, String[] argms)
    {
        if (sqliter == null)
        {
            sqliter = sqLiteHelper.getWritableDatabase();
        }

        sqliter.execSQL(sql, argms);

        if (sqliter != null)
        {
            sqliter.close();
        }
    }

    // /**
    // * 对数据库对象进行管理，获得、执行、关闭等操作 @Description: @return: void @throws
    // */
    // private void dbReadOperator(String sql, String[] argms)
    // {
    // if (sqliter == null)
    // {
    // sqliter = sqLiteHelper.getReadableDatabase();
    // }
    //
    // sqliter.execSQL(sql, argms);
    //
    // if (sqliter != null)
    // {
    // sqliter.close();
    // }
    // }

    public void destory()
    {
        sqLiteHelper.close();
    }

}
