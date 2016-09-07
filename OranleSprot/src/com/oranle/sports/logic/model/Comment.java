package com.oranle.sports.logic.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Comment implements Parcelable
{

    /**
     * 评论ID
     */
    private long cID;

    /**
     * 评论者ID
     */
    private long UID;

    /**
     * 评论时间
     */
    private long time;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 回复的评论的ID
     */
    private long toCommentID;

    public long getcID()
    {
        return cID;
    }

    public void setcID(long cID)
    {
        this.cID = cID;
    }

    public long getUID()
    {
        return UID;
    }

    public void setUID(long uID)
    {
        UID = uID;
    }

    public long getTime()
    {
        return time;
    }

    public void setTime(long time)
    {
        this.time = time;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public long getToCommentID()
    {
        return toCommentID;
    }

    public void setToCommentID(long toCommentID)
    {
        this.toCommentID = toCommentID;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeLong(cID);
        dest.writeLong(UID);
        dest.writeLong(time);
        dest.writeString(content);
        dest.writeLong(toCommentID);
    }

    private Comment(Parcel in)
    {
        this.cID = in.readLong();
        this.UID = in.readLong();
        this.time = in.readLong();
        this.content = in.readString();
        this.toCommentID = in.readLong();
    }

    public static final Parcelable.Creator<Comment> CREATOR = new Parcelable.Creator<Comment>()
    {

        @Override
        public Comment createFromParcel(Parcel source)
        {
            return new Comment(source);
        }

        @Override
        public Comment[] newArray(int size)
        {
            return new Comment[size];
        }
    };

}
