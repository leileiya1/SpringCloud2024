package com.sapiece.controller;

import com.sapiece.entities.Pay;
import com.sapiece.entities.PayDTO;
import com.sapiece.resp.ResultData;
import com.sapiece.resp.ReturnCodeEnum;
import com.sapiece.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author SAPiece
 * @Create 2024-07-18 10:33
 * @Package com.sapiece.controller
 * @Project SpringCloud2024
 * @Filename PayController
 * @Version 1.0
 */
@Tag(name = "支付模块", description = "支付模块相关接口")
@RestController
@RequestMapping("/pay")
@RequiredArgsConstructor
public class PayController {
    private final PayService payService;

    @PostMapping("/add")
    @Operation(summary = "新增支付信息", description = "新增支付信息")
    public ResultData<String> add(@RequestBody Pay pay) {
        payService.add(pay);
        return ResultData.success("插入成功!");
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除支付信息", description = "删除支付信息")
    public ResultData<String> delete(@PathVariable("id") Integer id) {
        payService.delete(id);
        return ResultData.success("删除成功!");
    }

    @PutMapping("/update")
    @Operation(summary = "更新支付信息", description = "更新支付信息")
    public ResultData<String> update(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        payService.update(pay);
        return ResultData.success("更新成功!");
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "根据ID查询支付信息", description = "根据ID查询支付信息")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        Pay pay = payService.getById(id);
        return pay != null ? ResultData.success(pay) : ResultData.failure(ReturnCodeEnum.RC500.getCode(),
                "没有当前用户!");

    }

    @GetMapping("/list")
    @Operation(summary = "查询所有支付信息", description = "查询所有支付信息")
    public ResponseEntity<List<Pay>> list() {
        List<Pay> payList = payService.list();
        return ResponseEntity.ok(payList);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/get/info")
    public String getPort() {
        return "info信息：端口2";
    }
}
