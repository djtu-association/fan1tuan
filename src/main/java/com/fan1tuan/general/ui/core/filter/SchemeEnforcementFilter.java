package com.fan1tuan.general.ui.core.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fan1tuan.general.config.Fan1TuanConfig;


/**
 * The SchemeEnforcementFilter is provided for Roller sites that enable secure
 * logins and want to ensure that only login urls are used under https.
 *
 * @author  Allen Gilliland
 *
 * @web.filter name="SchemeEnforcementFilter"
 */
@SuppressWarnings({"rawtypes","unchecked","unused"})
public class SchemeEnforcementFilter implements Filter {
    
    private static Log mLogger = 
            LogFactory.getLog(SchemeEnforcementFilter.class);
    
    private FilterConfig filterConfig = null;
    
    private boolean schemeEnforcementEnabled = false;
    private boolean secureLoginEnabled = false;
    private int httpPort = 80;
    private int httpsPort = 443;
    private String httpsHeaderName = null;
    private String httpsHeaderValue = null;
    
	private Set allowedUrls = new HashSet();
    
    
    /**
     * Process filter.
     *
     * We'll take the incoming request and first determine if this is a
     * secure request.  If the request is secure then we'll see if it matches
     * one of the allowed secure urls, if not then we will redirect back out
     * of https.
     */
    public void doFilter(ServletRequest request, ServletResponse response,
                        FilterChain chain)
            throws IOException, ServletException {
        if(this.schemeEnforcementEnabled && this.secureLoginEnabled) {
            
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            
            mLogger.debug("checking path = "+req.getServletPath());
            
            if(!request.isSecure() && allowedUrls.contains(req.getServletPath())) {
                // http insecure request that should be over https
                String redirect = "https://"+req.getServerName();
                
                if(this.httpsPort != 443)
                    redirect += ":"+this.httpsPort;
                
                redirect += req.getRequestURI();
                
                if(req.getQueryString() != null)
                    redirect += "?"+req.getQueryString();
                
                mLogger.debug("Redirecting to "+redirect);
                res.sendRedirect(redirect);
                return;
                
            } else if(request.isSecure() && !allowedUrls.contains(req.getServletPath())) {
                // https secure request that should be over http
                String redirect = "http://"+req.getServerName();
                
                if(this.httpPort != 80)
                    redirect += ":"+this.httpPort;
                
                redirect += req.getRequestURI();
                
                if(req.getQueryString() != null)
                    redirect += "?"+req.getQueryString();
                
                mLogger.debug("Redirecting to "+redirect);
                res.sendRedirect(redirect);
                return;
            }
        }
        
        chain.doFilter(request, response);
    }
    
    
    public void destroy() {}
    
    
    /**
     * Filter init.
     *
     * We are just collecting init properties which we'll use for each request.
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        
        // determine if we are doing scheme enforcement
        this.schemeEnforcementEnabled = 
                Fan1TuanConfig.getBooleanProperty("schemeenforcement.enabled");
        this.secureLoginEnabled = 
        		Fan1TuanConfig.getBooleanProperty("securelogin.enabled");
        
        if(this.schemeEnforcementEnabled && this.secureLoginEnabled) {
            // gather some more properties
            String http_port = 
            		Fan1TuanConfig.getProperty("securelogin.http.port");
            String https_port = 
            		Fan1TuanConfig.getProperty("securelogin.https.port");
            
            try {
                this.httpPort = Integer.parseInt(http_port);
                this.httpsPort = Integer.parseInt(https_port);
            } catch(NumberFormatException nfe) {
                // ignored ... guess we'll have to use the defaults
                mLogger.warn("error with secure login ports", nfe);
            }
            
            // finally, construct our list of allowable https urls
            String urls = 
            		Fan1TuanConfig.getProperty("schemeenforcement.https.urls");
            String[] urlsArray = urls.split(",");
            for(int i=0; i < urlsArray.length; i++)
                this.allowedUrls.add(urlsArray[i]);
            
            // some logging for the curious
            mLogger.info("Scheme enforcement = enabled");
            if(mLogger.isDebugEnabled()) {
                mLogger.debug("allowed urls are:");
                for(Iterator it = this.allowedUrls.iterator(); it.hasNext();)
                    mLogger.debug(it.next());
            }
        }
    }
    
}
