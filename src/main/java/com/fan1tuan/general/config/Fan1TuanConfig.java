package com.fan1tuan.general.config;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * This is the single entry point for accessing configuration properties in Roller.
 */
public class Fan1TuanConfig {

    private static Properties config;

    private static Log log = LogFactory.getLog(Fan1TuanConfig.class);
    

    /*
     * Static block run once at class loading
     *
     * We load the default properties and any custom properties we find
     */
    static {
        config = new Properties();

        try {
            // we'll need this to get at our properties files in the classpath
            @SuppressWarnings("rawtypes")
			Class config_class = Class.forName("com.fan1tuan.general.config.Fan1TuanConfig");

            // first, lets load our default properties
            String default_config = "/com/fan1tuan.config/fan1tuan.properties";
            InputStream is = config_class.getResourceAsStream(default_config);
            config.load(is);

           
            
            //// initialize logging subsystem via WebloggerConfig
            //Properties log4jprops = new Properties();
            //PropertyConfigurator.configure(Fan1TuanConfig.getPropertiesStartingWith("log4j."));
            
            // finally we can start logging...

            // some debugging for those that want it
            if(log.isDebugEnabled()) {
                log.debug("Fan1TuanConfig looks like this ...");

                String key;
                @SuppressWarnings("rawtypes")
				Enumeration keys = config.keys();
                while(keys.hasMoreElements()) {
                    key = (String) keys.nextElement();
                    log.debug(key+"="+config.getProperty(key));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // no, you may not instantiate this class :p
    private Fan1TuanConfig() {}


    /**
     * Retrieve a property value
     * @param     key Name of the property
     * @return    String Value of property requested, null if not found
     */
    public static String getProperty(String key) {
        log.debug("Fetching property ["+key+"="+config.getProperty(key)+"]");
        String value = config.getProperty(key);
        return value == null ? null : value.trim();
    }
    
    /**
     * Retrieve a property value
     * @param     key Name of the property
     * @param     defaultValue Default value of property if not found     
     * @return    String Value of property requested or defaultValue
     */
    public static String getProperty(String key, String defaultValue) {
        log.debug("Fetching property ["+key+"="+config.getProperty(key)+",defaultValue="+defaultValue+"]");
        String value = config.getProperty(key);
        if(value == null)
          return defaultValue;
        
        return value.trim();
    }

    /**
     * Retrieve a property as a boolean ... defaults to false if not present.
     */
    public static boolean getBooleanProperty(String name) {
        return getBooleanProperty(name,false);
    }

    /**
     * Retrieve a property as a boolean ... with specified default if not present.
     */
    public static boolean getBooleanProperty(String name, boolean defaultValue) {
        // get the value first, then convert
        String value = Fan1TuanConfig.getProperty(name);

        if(value == null)
            return defaultValue;

        return Boolean.valueOf(value);
    }

    /**
     * Retrieve a property as an int ... defaults to 0 if not present.
     */
    public static int getIntProperty(String name) {
        return getIntProperty(name, 0);
    }

    /**
     * Retrieve a property as a int ... with specified default if not present.
     */
    public static int getIntProperty(String name, int defaultValue) {
        // get the value first, then convert
        String value = Fan1TuanConfig.getProperty(name);

        if (value == null)
            return defaultValue;

        return new Integer(value);
    }

    /**
     * Retrieve all property keys
     * @return Enumeration A list of all keys
     **/
    @SuppressWarnings("rawtypes")
	public static Enumeration keys() {
        return config.keys();
    }
    
    
    /**
     * Get properties starting with a specified string.
     */
    public static Properties getPropertiesStartingWith(String startingWith) {
        Properties props = new Properties();
        for (@SuppressWarnings("rawtypes")
		Enumeration it = config.keys(); it.hasMoreElements();) {
            String key = (String)it.nextElement();
            props.put(key, config.get(key));
        }
        return props;
    }
    

    /**
     * Set the "uploads.dir" property at runtime.
     * <p />
     * Properties are meant to be read-only, but we make this exception because  
     * we know that some people are still writing their uploads to the webapp  
     * context and we can only get that path at runtime (and for unit testing).
     * <p />
     * This property is *not* persisted in any way.
     */
    public static void setUploadsDir(String path) {
        // only do this if the user wants to use the webapp context
        //if("${webapp.context}".equals(config.getProperty("uploads.dir")))
            config.setProperty("uploads.dir", path);
    }
    
    /**
     * Set the "themes.dir" property at runtime.
     * <p />
     * Properties are meant to be read-only, but we make this exception because  
     * we know that some people are still using their themes in the webapp  
     * context and we can only get that path at runtime (and for unit testing).
     * <p />
     * This property is *not* persisted in any way.
     */
    public static void setThemesDir(String path) {
        // only do this if the user wants to use the webapp context
        //if("${webapp.context}".equals(config.getProperty("themes.dir")))
            config.setProperty("themes.dir", path);
    }
    
}
