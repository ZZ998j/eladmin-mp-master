package com.bob.dcits.system.modules.system.service;

import com.bob.dcits.system.modules.system.domain.User;
import java.util.List;

/**
 * 数据权限服务类
 * @author guoq
 * @date 2020-05-07
 */
public interface DataService {

    /**
     * 获取数据权限
     * @param user /
     * @return /
     */
    List<Long> getDeptIds(User user);
}
