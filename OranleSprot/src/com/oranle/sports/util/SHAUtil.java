package com.oranle.sports.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: SHA256Util
 * 
 * @author: Oranle
 * @date: 2016年8月21日 下午8:58:57
 * @最后修改人: Oranle
 * @最后修改时间: 2016年8月21日 下午8:58:57
 */
public class SHAUtil
{
    public static final String SHA_TYPE_256 = "SHA-256";

    public static final String SHA_TYPE_512 = "SHA-512";

    /**
     * 传入文本内容，返回 SHA-256 串 @return: String @throws
     */
    public String encryptSHA256(final String strText)
    {
        return encrypt(strText, SHA_TYPE_256);
    }

    /**
     * 传入文本内容，返回 SHA-512 串
     * 
     * @param strText
     * @return
     */
    public String encryptSHA512(final String strText)
    {
        return encrypt(strText, SHA_TYPE_512);
    }

    /**
     * 字符串 SHA 加密
     * 
     * @param strSourceText
     * @return
     */
    private String encrypt(final String strText, final String strType)
    {
        // 返回值
        String strResult = null;

        // 是否是有效字符串
        if (strText != null && strText.length() > 0)
        {
            try
            {
                // SHA 加密开始
                // 创建加密对象 并傳入加密類型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes());
                // 得到 byte 類型结果
                byte byteBuffer[] = messageDigest.digest();

                // 將 byte 轉換爲 string
                StringBuffer strHexString = new StringBuffer();
                // 遍歷 byte buffer
                for (int i = 0; i < byteBuffer.length; i++)
                {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1)
                    {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回結果
                strResult = strHexString.toString();
            }
            catch (NoSuchAlgorithmException e)
            {
                e.printStackTrace();
            }
        }

        return strResult;
    }

}
