package com.sapiece.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author SAPiece
 * @Create 2024-08-01 15:15
 * @Package com.sapiece.controller
 * @Project SpringCloud2024
 * @Filename RateLimitController
 * @Version 1.0
 */
@RestController
@Slf4j
public class RateLimitController {
    @GetMapping("/rateLimit/byUrl")
    public String byUrl() {
        return "按rest地址限流测试OK";
    }
    @GetMapping("/rateLimit/bySource")
    @SentinelResource(value = "bySource",blockHandler = "blockHandler")
    public String bySource() {
        return "按照资源名称限流测试OK,o(╥﹏╥)o";
    }
    public String blockHandler(BlockException ex) {
        log.error("bySource blockHandler: ", ex);
        return "请求过于频繁，请稍后再试~~^-^~~" ;
    }
    @GetMapping("/rateLimit/doAction/{p1}")
    @SentinelResource(value = "doAction",
            blockHandler = "doActionBlockHandler",
            fallback = "doActionBlockHandler")
    public String doAction(@PathVariable("p1") Integer p1){
        if (p1==0) {
            throw new RuntimeException("参数不可为0");
        }
        return "限流测试通过";
    }
    public String doActionBlockHandler(@PathVariable("p1") Integer p1, BlockException ex) {
        log.error("doAction blockHandler: ", ex);
        return "参数不可为0，请稍后再试~~^-^~~";
    }
    public String doActionBlockHandler(@PathVariable("p1") Integer p1, Throwable ex){
        log.error("程序逻辑异常:",ex);
        return "程序逻辑异常，请稍后再试~~^-^~~"+"\t"+ex.getMessage();
    }
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealHandler_blockHandler")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {
        return "testHotKey";
    }
    public String dealHandler_blockHandler(String p1, String p2, BlockException ex) {
        log.error("dealHandler_blockHandler: ", ex);
        return "请求过于频繁，请稍后再试~~^-^~~";
    }
}
