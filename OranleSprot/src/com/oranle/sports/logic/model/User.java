package com.oranle.sports.logic.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @ClassName: User
 * @Description: 用户数据类
 * @author: Oranle
 * @date: 2016年8月3日 下午9:09:07
 * @最后修改人: Oranle
 * @最后修改时间: 2016年8月3日 下午9:09:07
 */
public class User implements Parcelable
{

    /**
     * 性别：女
     */
    public static final int FEMALE = 0;

    /**
     * 性别：男
     */
    public static final int MALE = 1;

    /**
     * 性别：保密（未知）
     */
    public static final int SECRECY = -1;

    /**
     * 用户ID
     */
    private long UID;

    /**
     * 性别：0，女；1，男；-1，保密
     */
    private int gender;

    /**
     * 年龄
     */
    private int age;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像地址
     */
    private String headImageURL;

    /**
     * 城市地区
     */
    private String city;

    /**
     * 个性签名
     */
    private String signture;

    public long getUID()
    {
        return UID;
    }

    public void setUID(long uID)
    {
        UID = uID;
    }

    public int getGender()
    {
        return gender;
    }

    public void setGender(int gender)
    {
        this.gender = gender;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getSignture()
    {
        return signture;
    }

    public void setSignture(String signture)
    {
        this.signture = signture;
    }

    public String getHeadImageURL()
    {
        return headImageURL;
    }

    public void setHeadImageURL(String headImageURL)
    {
        this.headImageURL = headImageURL;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
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
        dest.writeInt(gender);
        dest.writeInt(age);
        dest.writeString(nickName);
        dest.writeString(headImageURL);
        dest.writeString(city);
        dest.writeString(signture);
    }

    private User(Parcel in)
    {
        this.UID = in.readLong();
        this.gender = in.readInt();
        this.age = in.readInt();
        this.nickName = in.readString();
        this.headImageURL = in.readString();
        this.city = in.readString();
        this.signture = in.readString();
    }

    public User()
    {
    }

    public static final Parcelable.Creator<User> CREATEOR = new Creator<User>()
    {

        @Override
        public User[] newArray(int size)
        {
            return new User[size];
        }

        @Override
        public User createFromParcel(Parcel source)
        {
            return new User(source);
        }
    };
}
