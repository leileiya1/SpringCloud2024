package com.sapiece.handler;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * @Author SAPiece
 * @Create 2024-08-02 23:46
 * @Package com.sapiece.handler
 * @Project SpringCloud2024
 * @Filename ReuquestOriginParser
 * @Version 1.0
 */
@Component
public class RequestOriginParserHandler implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
        return request.getParameter("serverName");
    }
}
