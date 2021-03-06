package me.minicoral.util;

import java.security.MessageDigest;

public class MD5Util
{
    public static String encode(String message)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(message.getBytes());
            byte b[] = md.digest();
            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0 ; offset < b.length ; offset++)
            {
                i = b[offset];
                if (i < 0)
                {
                    i += 256;
                }
                if (i < 16)
                {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
