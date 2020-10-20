package com.sun.power.core.utils;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UUIDGenerator implements Serializable {
    private static final int ip;
    private static short counter = (short) 0;
    private static final int jvm = (int) ( System.currentTimeMillis() >>> 8 );  
    private final static String sep = "";
    
    public static int ip2Int(byte[] bytes) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = (result << 8) - Byte.MIN_VALUE + (int)bytes[i];
        }
        return result;
    }
    
    static {
        int ipAddr;
        try {
            ipAddr = ip2Int(InetAddress.getLocalHost().getAddress());
        } catch(UnknownHostException ex) {
            ipAddr = 0;
        }
        ip = ipAddr;
    }
    
    
    
    public UUIDGenerator() {
        
    }
    
    /**
     * 
     * Unique across JVMs on this machine 
     * 
     * @return 
     */
    protected static int getJVM() {
        return jvm;
    }
    
    /**
     * 
     *  Unique in a millisecond for this JVM instance 
     * 
     * @return 
     */
    protected static short getCount() {
        synchronized(UUIDGenerator.class) {
            if (counter<0)
                counter = 0;
            
            return counter++;
        }
    }
    
    /**
     * 
     * Unique in a local network 
     * 
     * @return 
     */
    protected static int getIP() {
        return ip;
    }
    
    protected static short getHiTime() {
        return (short) ( System.currentTimeMillis()>>> 32 );  
    }
    
    protected static int getLoTime() {
        return (int) System.currentTimeMillis();  
    }
    
    protected static String format(int intval) {
        String formatted = Integer.toHexString(intval);  
        StringBuilder buf = new StringBuilder("00000000");  
        buf.replace( 8-formatted.length(), 8, formatted );  
        return buf.toString();
    }
    
    protected static String format(short shortval) {
        String formatted = Integer.toHexString(shortval);  
        StringBuilder buf = new StringBuilder("0000");  
        buf.replace( 4-formatted.length(), 4, formatted );  
        return buf.toString();  
    }  

     public static String generate() {
         return new StringBuilder()
                 .append( format( getIP() ) ).append(sep)
                 .append( format( getJVM() ) ).append(sep)
                 .append( format( getHiTime() ) ).append(sep)
                 .append( format( getLoTime() ) ).append(sep)
                // .append( format( getCount() ) )
                 .toString();
     }

}
