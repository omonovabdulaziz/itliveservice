package it.live.itliveservice.config;

import io.github.bucket4j.*;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Duration;

@Component
public class RateLimitFilter implements Filter {

    private static final long CAPACITY = 10;
    private static final Duration TIME_PERIOD = Duration.ofSeconds(1);

    private Bucket bucket;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Bandwidth limit = Bandwidth.classic(CAPACITY, Refill.intervally(CAPACITY, TIME_PERIOD));
        bucket = Bucket4j.builder().addLimit(limit).build();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);
        if (probe.isConsumed()) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            try {
                sendRateLimitResponse(servletResponse);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                servletResponse.getWriter().write("Error occurred during rate limiting.");
                servletResponse.setContentType("text/plain");
            }
        }
    }

    private void sendRateLimitResponse(ServletResponse servletResponse) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.setStatus(429);
        httpResponse.setContentType("text/plain");
        httpResponse.getWriter().write("Rate limit exceeded.");
    }

    @Override
    public void destroy() {
        // No cleanup needed
    }
}