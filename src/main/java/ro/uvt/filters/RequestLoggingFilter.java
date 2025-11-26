package ro.uvt.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class RequestLoggingFilter implements Filter {
    private Logger logger;

    @Override
    public void init(FilterConfig filterConfig) {
        try {
            logger = Logger.getLogger("RequestLogger");
            FileHandler fh = new FileHandler("requests.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        logger.info("Incoming: " + req.getMethod() + " " + req.getRequestURI());
        chain.doFilter(request, response);
        logger.info("Outgoing: " + req.getMethod() + " " + req.getRequestURI() + " -> " + res.getStatus());
    }

    @Override
    public void destroy() {}
}
