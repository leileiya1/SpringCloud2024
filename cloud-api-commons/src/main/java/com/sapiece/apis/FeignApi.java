package com.sapiece.apis;


import com.sapiece.entities.PayDTO;
import com.sapiece.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @Author SAPiece
 * @Create 2024-07-23 15:08
 * @Package com.sapiece.apis
 * @Project SpringCloud2024
 * @Filename FeignApi
 * @Version 1.0
 */
@FeignClient(value = "cloud-gateway",url = "http://localhost:9527")
public interface FeignApi {

    @PostMapping("/pay/add")
    ResultData addPay(@RequestBody PayDTO payDTO);

    @GetMapping("/pay/get/{id}")
    ResultData queryPay(@PathVariable("id") Integer id);

    @DeleteMapping("/pay/delete/{id}")
    ResultData deletePayInfo(@PathVariable("id") Integer id);

    @PutMapping("/pay/update")
    ResultData updatePayInfo(@RequestBody PayDTO payDTO);

    @GetMapping("/pay/circuit/{id}")
    String myCircuit(@PathVariable("id") Integer id);

    @GetMapping("/pay/get/info")
    String getInfo();

    @GetMapping("/pay/gateway/get/{id}")
    ResultData getById(@PathVariable("id") Integer id);

    @GetMapping("/pay/gateway/info")
    ResultData<String> getGatewayInfo();

}
