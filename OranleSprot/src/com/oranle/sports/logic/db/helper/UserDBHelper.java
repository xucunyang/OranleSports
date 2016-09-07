package com.oranle.sports.logic.db.helper;

import java.util.ArrayList;
import java.util.List;

import com.oranle.sports.logic.db.model.DataBaseModel.UserTable;
import com.oranle.sports.logic.model.User;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * @Description: 数据库：用户表操作类
 * @author: Oranle
 * @date: 2016年8月15日 下午10:59:23
 * @最后修改人: Oranle
 * @最后修改时间: 2016年8月15日 下午10:59:23
 */
public class UserDBHelper
{
    /**
     * 数据库操作类
     */
    private final SQLiteHelper sqLiteHelper;

    /**
     * 数据库对象
     */
    private SQLiteDatabase sqliter;
    
    /**
     * 单实例
     */
    private static UserDBHelper sInstance;
    
    public synchronized static UserDBHelper getInstance(Context context)
    {
        if(null == sInstance)
        {
            sInstance = new UserDBHelper(context);
        }
        return sInstance;
    }
    

    /**
     * 构造函数
     * 
     * @param context
     */
    public UserDBHelper(Context context)
    {
        sqLiteHelper = new SQLiteHelper(context);
    }

    /**
     * 插入数据库
     * @return: void
     * @throws
     */
    public void insert(User user)
    {
        String sql = "insert into " + UserTable.TABLE_NAME + "(" + UserTable.UID + ", " + UserTable.AGE + ", "
                + UserTable.CITY + ", " + UserTable.GENDER + ", " + UserTable.HEAD_IMAGE_URL + ", "
                + UserTable.NICK_NAME + ", " + UserTable.SIGNATURE + ")"
                + " values(?, ?, ?, ?, ?, ?, ?)";

        String[] argms = new String[]{
                user.getUID() + "", 
                user.getAge() + "",
                user.getCity(),
                user.getGender() + "",
                user.getHeadImageURL(),
                user.getNickName(),
                user.getSignture(),
        };

        dbWriteOperator(sql, argms);
        
    }
    
    /**
     * 删除
     * @return: void
     * @throws
     */
    public void delete(int uid)
    {
        String sql = "delete from " + UserTable.TABLE_NAME + " where " + UserTable.UID + "=?";
        String[] argms = new String[] { uid + "" };
        dbWriteOperator(sql, argms);
    }
    
    /**
     * 更新
     * @return: void
     * @throws
     */
    public void update(User user)
    {
        String sql = "update " + UserTable.TABLE_NAME + " set "
                + UserTable.UID + "=?, " 
                + UserTable.AGE + "=?, " 
                + UserTable.CITY + "=?, "
                + UserTable.GENDER + "=?, "
                + UserTable.HEAD_IMAGE_URL + "=?, "
                + UserTable.NICK_NAME + "=?, "
                + UserTable.SIGNATURE + "=? "
                + "  where " 
                + UserTable.UID + "=?";
        String[] argms = new String[]
        {
            user.getUID() + "",
            user.getAge() + "",
            user.getCity(),
            user.getGender() + "",
            user.getHeadImageURL(),
            user.getNickName(),
            user.getSignture()
        };
        dbWriteOperator(sql, argms);
    }

    public List<User> getAllUser()
    {
        return query("", null);
    }
    
    /**
     * 根据条件查询数据库
     * @return: List<User>
     * @throws
     */
    private List<User> query(String where, String[] argms)
    {
        // 数据库操作对象
        sqliter = sqLiteHelper.getReadableDatabase();
        // 拼接sql语句
        String sql = "select * from " + UserTable.TABLE_NAME + where;
        // 查询数据库
        Cursor cursor = sqliter.rawQuery(sql, argms);

        List<User> userList = getUsersFromCursor(cursor);

        if (!cursor.isClosed())
        {
            cursor.close();
        }

        sqliter.close();

        return userList;

    }

    /**
     * 遍历cursor取值封装
     * @Description: 
     * @return: List<User>
     * @throws
     */
    private List<User> getUsersFromCursor(Cursor cursor)
    {
        List<User> userList = new ArrayList<User>();

        if (null == cursor)
        {
            return userList;
        }

        while (cursor.moveToNext())
        {
            User user = new User();
            user.setUID(cursor.getLong(cursor.getColumnIndex(UserTable.UID)));
            user.setAge(cursor.getInt(cursor.getColumnIndex(UserTable.AGE)));
            user.setCity(cursor.getString(cursor.getColumnIndex(UserTable.CITY)));
            user.setGender(cursor.getInt(cursor.getColumnIndex(UserTable.GENDER)));
            user.setHeadImageURL(cursor.getString(cursor.getColumnIndex(UserTable.HEAD_IMAGE_URL)));
            user.setNickName(cursor.getString(cursor.getColumnIndex(UserTable.NICK_NAME)));
            user.setSignture(cursor.getString(cursor.getColumnIndex(UserTable.SIGNATURE)));
            
            userList.add(user);
        }
        return userList;

    }
    
    /**
     * 对数据库对象进行管理，获得、执行、关闭等操作 @Description: @return: void @throws
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
    
//    /**
//     * 对数据库对象进行管理，获得、执行、关闭等操作 @Description: @return: void @throws
//     */
//    private void dbReadOperator(String sql, String[] argms)
//    {
//        if (sqliter == null)
//        {
//            sqliter = sqLiteHelper.getReadableDatabase();
//        }
//
//        sqliter.execSQL(sql, argms);
//
//        if (sqliter != null)
//        {
//            sqliter.close();
//        }
//    }
    
    public void destory()
    {
        sqLiteHelper.close();
    }
}
