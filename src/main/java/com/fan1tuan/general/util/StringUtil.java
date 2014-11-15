package com.fan1tuan.general.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class StringUtil {
	private static Log mLogger = LogFactory.getLog(StringUtil.class);

	
	//------------------------------------------------------------------------
    /**
     * Replaces occurences of non-alphanumeric characters with an underscore.
     */
    public static String replaceNonAlphanumeric(String str) {
        return replaceNonAlphanumeric(str, '_');
    }
    
    //------------------------------------------------------------------------
    /**
     * Replaces occurences of non-alphanumeric characters with a
     * supplied char.
     */
    public static String replaceNonAlphanumeric(String str, char subst) {
        StringBuffer ret = new StringBuffer(str.length());
        char[] testChars = str.toCharArray();
        for (int i = 0; i < testChars.length; i++) {
            if (Character.isLetterOrDigit(testChars[i])) {
                ret.append(testChars[i]);
            } else {
                ret.append( subst );
            }
        }
        return ret.toString();
    }
    
    //------------------------------------------------------------------------
    /**
     * Remove occurences of non-alphanumeric characters.
     */
    public static String removeNonAlphanumeric(String str) {
        StringBuffer ret = new StringBuffer(str.length());
        char[] testChars = str.toCharArray();
        for (int i = 0; i < testChars.length; i++) {
            // MR: Allow periods in page links
            if (Character.isLetterOrDigit(testChars[i]) ||
                    testChars[i] == '.') {
                ret.append(testChars[i]);
            }
        }
        return ret.toString();
    }
    
    //------------------------------------------------------------------------
    /**
     * @param stringArray
     * @param delim
     * @return
     */
    public static String stringArrayToString(String[] stringArray, String delim) {
        String ret = "";
        for (int i = 0; i < stringArray.length; i++) {
            if (ret.length() > 0)
                ret = ret + delim + stringArray[i];
            else
                ret = stringArray[i];
        }
        return ret;
    }
    
    //--------------------------------------------------------------------------
    /** Convert string to string array. */
    public static String[] stringToStringArray(String instr, String delim)
    throws NoSuchElementException, NumberFormatException {
        StringTokenizer toker = new StringTokenizer(instr, delim);
        String stringArray[] = new String[toker.countTokens()];
        int i = 0;
        
        while (toker.hasMoreTokens()) {
            stringArray[i++] = toker.nextToken();
        }
        return stringArray;
    }
    
    //--------------------------------------------------------------------------
    /** Convert string to integer array. */
    public static int[] stringToIntArray(String instr, String delim)
    throws NoSuchElementException, NumberFormatException {
        StringTokenizer toker = new StringTokenizer(instr, delim);
        int intArray[] = new int[toker.countTokens()];
        int i = 0;
        
        while (toker.hasMoreTokens()) {
            String sInt = toker.nextToken();
            int nInt = Integer.parseInt(sInt);
            intArray[i++] = new Integer(nInt).intValue();
        }
        return intArray;
    }
    
    //-------------------------------------------------------------------
    /** Convert integer array to a string. */
    public static String intArrayToString(int[] intArray) {
        String ret = "";
        for (int i = 0; i < intArray.length; i++) {
            if (ret.length() > 0)
                ret = ret + "," + Integer.toString(intArray[i]);
            else
                ret = Integer.toString(intArray[i]);
        }
        return ret;
    }
    
    
    /**
     * Encode a string using algorithm specified in web.xml and return the
     * resulting encrypted password. If exception, the plain credentials
     * string is returned
     *
     * @param password Password or other credentials to use in authenticating
     *        this username
     * @param algorithm Algorithm used to do the digest
     *
     * @return encypted password based on the algorithm.
     */
    public static String encodePassword(String password, String algorithm) {
        byte[] unencodedPassword = password.getBytes();
        
        MessageDigest md = null;
        
        try {
            // first create an instance, given the provider
            md = MessageDigest.getInstance(algorithm);
        } catch (Exception e) {
            mLogger.error("Exception: " + e);
            return password;
        }
        
        md.reset();
        
        // call the update method one or more times
        // (useful when you don't know the size of your data, eg. stream)
        md.update(unencodedPassword);
        
        // now calculate the hash
        byte[] encodedPassword = md.digest();
        
        StringBuffer buf = new StringBuffer();
        
        for (int i = 0; i < encodedPassword.length; i++) {
            if ((encodedPassword[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            
            buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
        }
        
        return buf.toString();
    }
    
    
    /**
     * @param string
     * @return
     */
    public static int stringToInt(String string) {
        try {
            return Integer.valueOf(string).intValue();
        } catch (NumberFormatException e) {
            mLogger.debug("Invalid Integer:" + string);
        }
        return 0;
    }
    
    
    public static String encodeURL(String url){
    	try {
			String encoded = URLEncoder.encode(url, "UTF-8");
			return encoded;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static String decodeURL(String url){
    	try {
			String decoded = URLDecoder.decode(url, "UTF-8");
			return decoded;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static String generateOrderNo(String userId, Date date){
    	String uuid = UUIDGenerator.generateUUID();
    	return userId.substring(0, userId.length()/4+1)+uuid.substring(0, uuid.indexOf('-'))+date.getTime();
    }
    
}
