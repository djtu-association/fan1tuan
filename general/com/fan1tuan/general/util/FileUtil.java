package com.fan1tuan.general.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.support.ServletContextResource;

public class FileUtil {
	@SuppressWarnings("unused")
	private static Log mLogger = LogFactory.getLog(FileUtil.class);
	
	//------------------------------------------------------------------------
    public static void copyFile(File from, File to) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        
        try {
            in = new FileInputStream(from);
        } catch (IOException ex) {
            throw new IOException(
                    "Utilities.copyFile: opening input stream '"
                    + from.getPath()
                    + "', "
                    + ex.getMessage());
        }
        
        try {
            out = new FileOutputStream(to);
        } catch (Exception ex) {
            try {
                in.close();
            } catch (IOException ex1) {
            }
            throw new IOException(
                    "Utilities.copyFile: opening output stream '"
                    + to.getPath()
                    + "', "
                    + ex.getMessage());
        }
        
        copyInputToOutput(in, out, from.length());
    }
    
    //------------------------------------------------------------------------
    /**
     * Utility method to copy an input stream to an output stream.
     * Wraps both streams in buffers. Ensures right numbers of bytes copied.
     */
    @SuppressWarnings("resource")
	public static void copyInputToOutput(
            InputStream input,
            OutputStream output,
            long byteCount)
            throws IOException {
        int bytes;
        long length;
        
        BufferedInputStream in = new BufferedInputStream(input);
        BufferedOutputStream out = new BufferedOutputStream(output);
        
        byte[] buffer;
        buffer = new byte[8192];
        
        for (length = byteCount; length > 0;) {
            bytes = (int) (length > 8192 ? 8192 : length);
            
            try {
                bytes = in.read(buffer, 0, bytes);
            } catch (IOException ex) {
                try {
                    in.close();
                    out.close();
                } catch (IOException ex1) {
                }
                throw new IOException(
                        "Reading input stream, " + ex.getMessage());
            }
            
            if (bytes < 0)
                break;
            
            length -= bytes;
            
            try {
                out.write(buffer, 0, bytes);
            } catch (IOException ex) {
                try {
                    in.close();
                    out.close();
                } catch (IOException ex1) {
                }
                throw new IOException(
                        "Writing output stream, " + ex.getMessage());
            }
        }
        
        try {
            in.close();
            out.close();
        } catch (IOException ex) {
            throw new IOException("Closing file streams, " + ex.getMessage());
        }
    }
    
    //------------------------------------------------------------------------
    public static void copyInputToOutput(
            InputStream input,
            OutputStream output)
            throws IOException {
        BufferedInputStream in = new BufferedInputStream(input);
        BufferedOutputStream out = new BufferedOutputStream(output);
        byte buffer[] = new byte[8192];
        for (int count = 0; count != -1;) {
            count = in.read(buffer, 0, 8192);
            if (count != -1)
                out.write(buffer, 0, count);
        }
        
        try {
            in.close();
            out.close();
        } catch (IOException ex) {
            throw new IOException("Closing file streams, " + ex.getMessage());
        }
    }
    
    
    public static InputStream getWebResourceInputStream(ServletContext context, String path){    	
    	try {
			return getServletContextResource(context, path).getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static File getWebResourceFile(ServletContext context, String path){
    	try {
			return getServletContextResource(context, path).getFile();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static ServletContextResource getServletContextResource(ServletContext context, String path){
    	ServletContextResource resource = new ServletContextResource(context, path);
    	return resource;
    }
    
    
    public static File getClassPathResourceFile(String path){
    	try {
			return getClassPathResource(path).getFile();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static InputStream getClassPathResourceInputStream(String path){
    	try {
			return getClassPathResource(path).getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static ClassPathResource getClassPathResource(String path){
    	ClassPathResource resource = new ClassPathResource(path);
    	return resource;
    }
    
}
