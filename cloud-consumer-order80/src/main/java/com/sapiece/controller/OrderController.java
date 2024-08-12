package com.sapiece.controller;

import com.sapiece.entities.PayDTO;
import com.sapiece.resp.ResultData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author SAPiece
 * @Create 2024-07-18 17:37
 * @Package com.sapiece.controller
 * @Project SpringCloud2024
 * @Filename OrderController
 * @Version 1.0
 */
@RestController
@RequestMapping("/consumer")
@RequiredArgsConstructor
public class OrderController {
    public static final String paymentSrv_URL = "http://cloud-payment-service";
    private final RestTemplate restTemplate;

    @PostMapping("/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(paymentSrv_URL + "/pay/add", payDTO, ResultData.class);
    }

    @GetMapping("/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(paymentSrv_URL + "/pay/get/" + id, ResultData.class, id);
    }

    @DeleteMapping("/pay/delete/{id}")
    public ResultData deletePayInfo(@PathVariable("id") Integer id) {
        restTemplate.delete(paymentSrv_URL + "/pay/delete/" + id);
        return ResultData.success(null);
    }

    @PutMapping("/pay/update")
    public ResultData updatePayInfo(@RequestBody PayDTO payDTO) {
        restTemplate.put(paymentSrv_URL + "/pay/update", payDTO, ResultData.class);
        return ResultData.success(null);
    }
    @GetMapping("/pay/get/info")
    public String getInfoByConsul(){
        return restTemplate.getForObject(paymentSrv_URL + "/pay/get/info", String.class);
    }
}
