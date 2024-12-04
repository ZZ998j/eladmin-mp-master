package com.bob.dcits.system.modules.system.domain.vo;

import lombok.Data;

/**
 * 修改密码的 Vo 类
 * @author guoq
 * @date 2024年7月11日13:59:49
 */
@Data
public class UserPassVo {

    private String oldPass;

    private String newPass;
}
