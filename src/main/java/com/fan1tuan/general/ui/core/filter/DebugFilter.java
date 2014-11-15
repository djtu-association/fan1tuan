package com.fan1tuan.general.ui.core.filter;

import java.io.IOException;
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


/**
 * A simple debugging filter.
 *
 * This filter is NOT mapped by default and is here only for Roller developers
 * to use while they are working on the code and debugging things.
 *
 * @web.filter name="DebugFilter"
 */
public class DebugFilter implements Filter {
    
    private static Log log = LogFactory.getLog(DebugFilter.class);
    
    
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        log.info("ENTERING "+request.getRequestURL());
        
        // some info about the request and response
        log.info("Response Object:");
        log.info("   isCommited = "+response.isCommitted());
        log.info("   bufferSize = "+response.getBufferSize());
        log.info("");
        
        chain.doFilter(request, response);
        
        log.info("EXITING "+request.getRequestURL());
        
        // some info about the request and response
        log.info("Response Object:");
        log.info("   isCommited = "+response.isCommitted());
        log.info("   bufferSize = "+response.getBufferSize());
        log.info("");
    }
    
    
    public void destroy() {}
    
    
    public void init(FilterConfig filterConfig) {}
    
}
