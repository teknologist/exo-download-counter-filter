package com.teknologism.filter;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.web.filter.Filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: eric
 * Date: 16/03/15
 * Time: 16:55
 */
public class DownloadCounterFilter implements Filter {
    private static final Log LOG = ExoLogger.getLogger(DownloadCounterFilter.class);




    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        LOG.info("DownloadCounterFilter start");
        if (request instanceof HttpServletRequest) {
            String url = ((HttpServletRequest) request).getRequestURL().toString();
            String queryString = ((HttpServletRequest) request).getQueryString();
            LOG.info("Filtered request: " + url + "?" + queryString);
        }

        LOG.info("DownloadCounterFilter Custom Processing Done");


        try {
            chain.doFilter(request, response);
        } finally {
            LOG.info("DownloadCounterFilter Finally End");
        }
    }


}