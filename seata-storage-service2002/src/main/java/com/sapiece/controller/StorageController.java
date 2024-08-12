package com.sapiece.controller;

import com.sapiece.resp.ResultData;
import com.sapiece.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StorageController {
    private final StorageService storageService;
    @PostMapping("/storage/decrease")
    public ResultData decrease(@RequestParam("productId") Long productId,
                               @RequestParam("count") Long count){
        storageService.decrease(productId,count);
        return ResultData.success("扣除减库存成功!");
    }
}
