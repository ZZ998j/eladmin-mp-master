package com.bob.dcits.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bob.dcits.domain.QiniuConfig;

/**
 * @author guoq
 * @date 2024-12-31
 */
public interface QiNiuConfigService extends IService<QiniuConfig> {

    /**
     * 查询配置
     * @return QiniuConfig
     */
    QiniuConfig getConfig();

    /**
     * 保存
     * @param type 类型
     */
    void saveConfig(QiniuConfig type);

    /**
     * 更新
     * @param type 类型
     */
    void updateType(String type);
}
