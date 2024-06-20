package startup;


/**
 * Calcula MD5
 * 
 * @author BOo 
 * @version 0.1b 15.03.2005
 */
import java.io.*;
import java.security.*;

public abstract class HashPass
{
    public static String md(String args)throws Exception
    {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte bb;
        byte[] b = args.getBytes();
        for(int o = 0; o < b.length; o++) 
        {
            bb = b[o];
            md5.update(bb);
        }

        b = md5.digest();
        return Hexa.toHexString(b);
     }
}
