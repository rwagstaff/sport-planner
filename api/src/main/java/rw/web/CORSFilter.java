package rw.web;

import org.apache.catalina.connector.RequestFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CORSFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(CORSFilter.class);

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {


        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin", requestUrl(req));
        response.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        if (isPreflight(req)) {
            LOG.info("Returning from pre flight request");
            return;
        }
        // Can't use wildcard with Allow-Credentials, so set request url as accepted
        //response.setHeader("Access-Control-Expose-Headers", "x-token")
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) {
        // DO nothing
    }

    @Override
    public void destroy() {
        // Do nothing
    }

    private String requestUrl(ServletRequest req) {
        String origin = ((javax.servlet.http.HttpServletRequest) req).getHeader("origin");
        LOG.info("Received request {} from {}", ((HttpServletRequest) req).getRequestURI(), origin);
        return origin;
    }

    private boolean isPreflight(ServletRequest req) {
        return ((RequestFacade)req).getMethod().equals("OPTIONS");
    }
}