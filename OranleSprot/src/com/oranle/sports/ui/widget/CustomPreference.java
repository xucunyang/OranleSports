package com.oranle.sports.ui.widget;

import com.oranle.sports.R;
import com.oranle.sports.util.StringUtil;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 
 * @ClassName: CustomPreference
 * @Description: (自定义Preference控件)
 * @author: Oranle
 * @date: 2016年7月16日 下午10:17:21
 * @最后修改人: Oranle
 * @最后修改时间: 2016年7月16日 下午10:17:21
 */
public class CustomPreference extends Preference
{

    /**
     * 上下文
     */
    private Context mContext;

    /**
     * 图标
     */
    private Drawable icon;

    /**
     * 标题
     */
    private String title;

    /**
     * 是否显示箭头
     */
    private boolean isDisplayArrow;

    public CustomPreference(Context context, String title, Drawable icon, boolean isDisplayArrow)
    {
        super(context);
        this.mContext = context;
        this.title = title;
        this.icon = icon;
        this.isDisplayArrow = isDisplayArrow;
//        TypedArray typedArray = mContext.obtainStyledAttributes()
    }

    @Override
    public View getView(View convertView, ViewGroup parent)
    {
        return super.getView(convertView, parent);
    }

    @Override
    protected View onCreateView(ViewGroup parent)
    {
        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return mInflater.inflate(R.layout.ora_custom_preference_item, parent, false);

    }

    @Override
    protected void onBindView(View view)
    {
        super.onBindView(view);
        if (null != icon)
        {
            ImageView iconImage = (ImageView) view.findViewById(R.id.pf_icon);
            iconImage.setImageDrawable(icon);
            iconImage.setVisibility(View.VISIBLE);
        }
        if (!StringUtil.isEmpty(title))
        {
            TextView titleTV = (TextView) view.findViewById(R.id.pf_title);
            titleTV.setText(title);
        }
        if (isDisplayArrow)
        {
            view.findViewById(R.id.pf_arrow).setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected void onAttachedToActivity()
    {
        super.onAttachedToActivity();
    }

    @Override
    protected void onClick()
    {
        super.onClick();
    }

}
