package com.fan1tuan.general.ui.core.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Entry point filter for all requests. This filter ensures that the request 
 * encoding is set to UTF-8 before any other processing forces request parsing 
 * using a default encoding.  It also syncs up the Struts and JSTL locales.  
 * This filter should normally be first and last in the chain.
 *
 * @author <a href="mailto:anil@busybuddha.org">Anil Gangolli</a>
 */
public class CharEncodingFilter implements Filter {
    
    @SuppressWarnings("unused")
	private FilterConfig mFilterConfig = null;
    private static Logger mLogger = LogManager.getLogger(CharEncodingFilter.class.getName());
    
    /**
     * init
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        mFilterConfig = filterConfig;
    }
    
    /**
     * destroy
     */
    public void destroy() {
    }
    
    /**
     * Set the character encoding and sync up Struts and JSTL locales.  This filter should normally be first (and last)
     * in the chain.
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    throws IOException, ServletException {
        mLogger.trace("Processing CharEncodingFilter");
        
        mLogger.trace(((HttpServletRequest)req).getRequestURL().toString()+"?"+((HttpServletRequest)req).getQueryString());
        try {
        	if (!"UTF-8".equals(req.getCharacterEncoding())) {
        		// only set encoding if not already UTF-8
        		// despite the fact that this is the first filter in the chain, on Glassfish it 
        		// is already too late to set request encoding without getting a WARN level log message
        		req.setCharacterEncoding("UTF-8");
        	}
        	mLogger.trace(((HttpServletRequest)req).getRequestURL());
            mLogger.trace("Set request character encoding to UTF-8");
            
        } catch (UnsupportedEncodingException e) {
            // This should never happen since UTF-8 is a Java-specified required encoding.
            throw new ServletException("Can't set incoming encoding to UTF-8");
        }
        
        chain.doFilter(req, res);
    }
    
}
