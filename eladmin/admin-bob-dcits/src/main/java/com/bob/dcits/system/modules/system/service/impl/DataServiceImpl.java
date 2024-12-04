package com.bob.dcits.system.modules.system.service.impl;

import lombok.RequiredArgsConstructor;
import com.bob.dcits.system.modules.system.domain.Dept;
import com.bob.dcits.system.modules.system.domain.Role;
import com.bob.dcits.system.modules.system.domain.User;
import com.bob.dcits.system.modules.system.service.DataService;
import com.bob.dcits.system.modules.system.service.DeptService;
import com.bob.dcits.system.modules.system.service.RoleService;
import com.bob.dcits.utils.enums.DataScopeEnum;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * @author guoq
 * @description 数据权限服务实现
 * @date 2020-05-07
 **/
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "data")
public class DataServiceImpl implements DataService {

    private final RoleService roleService;
    private final DeptService deptService;

    /**
     * 用户角色和用户部门改变时需清理缓存
     * @param user /
     * @return /
     */
    @Override
    @Cacheable(key = "'user:' + #p0.id")
    public List<Long> getDeptIds(User user) {
        // 用于存储部门id
        Set<Long> deptIds = new HashSet<>();
        // 查询用户角色
        List<Role> roleList = roleService.findByUsersId(user.getId());
        // 获取对应的部门ID
        for (Role role : roleList) {
            DataScopeEnum dataScopeEnum = DataScopeEnum.find(role.getDataScope());
            switch (Objects.requireNonNull(dataScopeEnum)) {
                case THIS_LEVEL:
                    deptIds.add(user.getDept().getId());
                    break;
                case CUSTOMIZE:
                    deptIds.addAll(getCustomize(deptIds, role));
                    break;
                default:
                    return new ArrayList<>();
            }
        }
        return new ArrayList<>(deptIds);
    }

    /**
     * 获取自定义的数据权限
     * @param deptIds 部门ID
     * @param role 角色
     * @return 数据权限ID
     */
    public Set<Long> getCustomize(Set<Long> deptIds, Role role){
        Set<Dept> depts = deptService.findByRoleId(role.getId());
        for (Dept dept : depts) {
            deptIds.add(dept.getId());
            List<Dept> deptChildren = deptService.findByPid(dept.getId());
            if (deptChildren != null && deptChildren.size() != 0) {
                deptIds.addAll(deptService.getDeptChildren(deptChildren));
            }
        }
        return deptIds;
    }
}
