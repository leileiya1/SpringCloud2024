package com.sapiece.apis;

import com.sapiece.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("seata-storage-service")
public interface StorageFeignApi {
    @PostMapping("/storage/decrease")
    ResultData decrease(@RequestParam("productId") Long productId, @RequestParam("count")Long count);
}
