package com.oranle.sports.logic.db.model;

/**
 * @Description: 数据库数据模型
 * @author: Oranle
 * @date: 2016年8月15日 下午9:06:17
 * @最后修改人: Oranle
 * @最后修改时间: 2016年8月15日 下午9:06:17
 */
public class DataBaseModel
{
    /**
     * 数据库名称前缀
     */
    public static final String DB_PREFIX = "oranlesprots_";

    public static final String UID = "";

    public static final String ACCOUNT = "account";

    /**
     * 数据库名称后缀
     */
    public static final String DB_SUFFIX = ".db";

    /**
     * 账户表
     * 
     * @author: Oranle
     * @date: 2016年8月19日 下午8:00:06
     * @最后修改人: Oranle
     * @最后修改时间: 2016年8月19日 下午8:00:06
     */
    public static class AccountTable
    {
        /**
         * 用户表名
         */
        public static String TABLE_NAME = "t_account_table";

        /**
         * 数据库 _id
         */
        public static String ID = "_id";

        /**
         * 用户UID
         */
        public static String UID = "uid";

        /**
         * 密码
         */
        public static String PASSWORD = "password";
        /**
         * 头像地址
         */
        public static String HEAD_IMAGE_URL = "head_image_url";

        /**
         * 昵称
         */
        public static String NICK_NAME = "nick_name";

        /**
         * 创建时间
         */
        public static String CREATE_TIME = "create_time";

    }

    /**
     * 用户表数据模型对应的字段
     * 
     * @author: Oranle
     * @date: 2016年8月15日 下午9:20:18
     * @最后修改人: Oranle
     * @最后修改时间: 2016年8月15日 下午9:20:18
     */
    public static class UserTable
    {
        /**
         * 用户表名
         */
        public static String TABLE_NAME = "t_user_table";

        /**
         * 数据库 _id
         */
        public static String ID = "_id";

        /**
         * 用户UID
         */
        public static String UID = "uid";

        /**
         * 密码（加密之后的字符串）
         */
        public static String PASSWORD = "pass_word";

        /**
         * 性别：0，女；1，男；-1，保密
         */
        public static String GENDER = "gender";

        /**
         * 年龄
         */
        public static String AGE = "age";

        /**
         * 昵称,最长10个字符
         */
        public static String NICK_NAME = "nick_name";

        /**
         * 头像地址
         */
        public static String HEAD_IMAGE_URL = "head_image_url";

        /**
         * 城市地区
         */
        public static String CITY = "city";

        /**
         * 签名
         */
        public static String SIGNATURE = "signture";

    }
}
