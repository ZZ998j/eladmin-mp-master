package com.bob.dcits.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bob.dcits.domain.vo.TradeVo;
import com.bob.dcits.domain.AlipayConfig;

/**
 * @author guoq
 * @date 2024-12-31
 */
public interface AliPayService extends IService<AlipayConfig> {

    /**
     * 查询配置
     * @return AlipayConfig
     */
    AlipayConfig find();

    /**
     * 更新配置
     * @param alipayConfig 支付宝配置
     * @return AlipayConfig
     */
    AlipayConfig config(AlipayConfig alipayConfig);

    /**
     * 处理来自PC的交易请求
     * @param alipay 支付宝配置
     * @param trade 交易详情
     * @return String
     * @throws Exception 异常
     */
    String toPayAsPc(AlipayConfig alipay, TradeVo trade) throws Exception;

    /**
     * 处理来自手机网页的交易请求
     * @param alipay 支付宝配置
     * @param trade 交易详情
     * @return String
     * @throws Exception 异常
     */
    String toPayAsWeb(AlipayConfig alipay, TradeVo trade) throws Exception;
}
