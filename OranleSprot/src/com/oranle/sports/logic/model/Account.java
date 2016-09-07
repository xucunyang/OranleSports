package com.oranle.sports.logic.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 账号数据模型
 * 
 * @author: Oranle
 * @date: 2016年8月19日 下午8:43:41
 * @最后修改人: Oranle
 * @最后修改时间: 2016年8月19日 下午8:43:41
 */
public class Account implements Parcelable
{

    /**
     * 用户UID
     */
    private long UID;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像地址
     */
    private String headImageUrl;

    /**
     * 账户登录的创建时间
     */
    private long createTime;

    public Account()
    {
    }
    
    public long getUID()
    {
        return UID;
    }

    public void setUID(long uID)
    {
        UID = uID;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getHeadImageUrl()
    {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl)
    {
        this.headImageUrl = headImageUrl;
    }

    public long getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(long createTime)
    {
        this.createTime = createTime;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeLong(UID);
        dest.writeString(nickName);
        dest.writeString(password);
        dest.writeString(headImageUrl);
        dest.writeLong(createTime);
    }

    public Account(Parcel in)
    {
        this.UID = in.readLong();
        this.nickName = in.readString();
        this.password = in.readString();
        this.headImageUrl = in.readString();
        this.createTime = in.readLong();
    }

    public static final Parcelable.Creator<Account> CREATOR = new Creator<Account>()
    {

        @Override
        public Account[] newArray(int size)
        {
            return new Account[size];
        }

        @Override
        public Account createFromParcel(Parcel source)
        {
            return new Account(source);
        }
    };

}
