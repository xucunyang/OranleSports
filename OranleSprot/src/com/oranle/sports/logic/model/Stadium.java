package com.oranle.sports.logic.model;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @ClassName: Stadium
 * @Description: 运动场数据模型
 * @author: Oranle
 * @date: 2016年8月3日 下午9:13:17
 * @最后修改人: Oranle
 * @最后修改时间: 2016年8月3日 下午9:13:17
 */
public class Stadium implements Parcelable
{

    /**
     * 场馆编号ID
     */
    private long sID;

    /**
     * 场馆名称
     */
    private String stadiumName;

    /**
     * 地址
     */
    private String location;

    /**
     * 评价
     */
    private List<Comment> comments;

    /**
     * 是否开放
     */
    private boolean isOpen;

    /**
     * 开放时间
     */
    private String openTime;

    /**
     * 关闭时间
     */
    private String closeTime;

    public long getsID()
    {
        return sID;
    }

    public void setsID(long sID)
    {
        this.sID = sID;
    }

    public String getStadiumName()
    {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName)
    {
        this.stadiumName = stadiumName;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public List<Comment> getComments()
    {
        return comments;
    }

    public void setComments(List<Comment> comments)
    {
        this.comments = comments;
    }

    public boolean isOpen()
    {
        return isOpen;
    }

    public void setOpen(boolean isOpen)
    {
        this.isOpen = isOpen;
    }

    public String getOpenTime()
    {
        return openTime;
    }

    public void setOpenTime(String openTime)
    {
        this.openTime = openTime;
    }

    public String getCloseTime()
    {
        return closeTime;
    }

    public void setCloseTime(String closeTime)
    {
        this.closeTime = closeTime;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeLong(sID);
        dest.writeString(stadiumName);
        dest.writeString(location);
        List<Comment> comments = new ArrayList<Comment>();
        dest.writeList(comments);
        dest.writeByte((byte) (isOpen ? 1 : 0));
        dest.writeString(openTime);
        dest.writeString(closeTime);
    }

    private Stadium(Parcel in)
    {
        this.sID = in.readLong();
        this.stadiumName = in.readString();
        this.location = in.readString();
        comments = new ArrayList<Comment>();
        in.readList(comments,Comment.class.getClassLoader());
        this.isOpen = in.readByte() != 0;
        this.openTime = in.readString();
        this.closeTime = in.readString();
    }

    public static final Parcelable.Creator<Stadium> CREATOR = new Creator<Stadium>()
    {

        @Override
        public Stadium[] newArray(int size)
        {
            return new Stadium[size];
        }

        @Override
        public Stadium createFromParcel(Parcel source)
        {
            return new Stadium(source);
        }
    };

}
