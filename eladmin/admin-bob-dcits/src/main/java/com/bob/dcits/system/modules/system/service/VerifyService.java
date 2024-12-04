package com.bob.dcits.system.modules.system.service;

import com.bob.dcits.domain.vo.EmailVo;

/**
 * @author guoq
 * @date 2024-12-26
 */
public interface VerifyService {

    /**
     * 发送验证码
     * @param email /
     * @param key /
     * @return /
     */
    EmailVo sendEmail(String email, String key);


    /**
     * 验证
     * @param code /
     * @param key /
     */
    void validated(String key, String code);
}
