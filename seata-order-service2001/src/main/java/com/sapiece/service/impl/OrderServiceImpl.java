package com.sapiece.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sapiece.apis.AccountFeignApi;
import com.sapiece.apis.StorageFeignApi;
import com.sapiece.entities.Order;
import com.sapiece.mapper.OrderMapper;
import com.sapiece.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final StorageFeignApi storageFeignApi;
    private final AccountFeignApi accountFeignApi;

    @Override
    @GlobalTransactional(name = "zzyy-create-order",
            rollbackFor = Exception.class)
    public void create(Order order) {
        String xid = RootContext.getXID();
        log.info("----开始新建订单---");
        order.setStatus(0);
        int insert = orderMapper.insert(order);
        Order orderFromDB = null;
        if (insert > 0) {
            QueryWrapper<Order> wrapper = new QueryWrapper<>();
            wrapper.allEq(Map.of("id", order.getId()));
            orderFromDB = orderMapper.selectOne(wrapper);
            log.info("-----新建订单成功------");
            log.info("orderFromDB账户前{}", orderFromDB);
            storageFeignApi.decrease(1L, Long.valueOf(orderFromDB.getCount()));
            log.info("orderFromDB账户后{}", orderFromDB);
            log.info("-----库存删减成功-----");
            accountFeignApi.decrease(orderFromDB.getUserId(), orderFromDB.getMoney());
            log.info("-----账户余额扣减成功------");
            System.out.println();
            log.info("----->修改订单状态------");
            orderFromDB.setStatus(1);
            int result = orderMapper.updateByPrimaryKey(orderFromDB);
            if (result > 0) {
                log.info("---->订单状态修改成功------");
                log.info("-----orderFromDB-----{}", orderFromDB);
            } else {
                log.info("---->订单状态修改失败------");
            }
        }
        System.out.println();
        log.info("----结束订单-----");
    }
}
