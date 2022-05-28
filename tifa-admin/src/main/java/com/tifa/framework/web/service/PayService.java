package com.tifa.framework.web.service;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePayResponse;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.tifa.framework.web.pojo.PaymentBO;
import com.tifa.framework.web.util.OrderUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 *  支付宝支付，业务实现
 *
 * @author wangziyang
 * @date 2020-09-08
 * */
@Service
public class PayService {

    //支付成功后要跳转的页面
    @Value("${alipay.returnUrl}")
    private String returnUrl;

    /**
     *  下单支付
     * */
    public Object pay (PaymentBO bo) throws Exception {

        //调用sdk，发起支付
        AlipayTradePagePayResponse response = Factory.Payment
                .Page()
                .pay(bo.getSubject() , OrderUtil.getOrderNo(), bo.getTotal().toString() , returnUrl);
        return response.body;
    }
}