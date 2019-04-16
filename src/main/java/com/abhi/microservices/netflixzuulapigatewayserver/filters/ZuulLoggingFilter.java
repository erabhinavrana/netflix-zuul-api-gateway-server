package com.abhi.microservices.netflixzuulapigatewayserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.constants.ZuulConstants;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Abhinav on 4/16/2019.
 */
@Component
public class ZuulLoggingFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        return "pre"; //This will define when the filter will run like pre, post, or error
    }

    @Override
    public int filterOrder() {
        return 1; // This will prioritize the order, if multiple filters configured
    }

    @Override
    public boolean shouldFilter() {
        return true; //This will enable/disable the filter based on business logic
    }

    @Override
    public Object run() throws ZuulException {
        //This will contains the business logic what we want to log as part of this filter.
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("Request : {} URI : {}", request, request.getRequestURI());
        return null;
    }
}
