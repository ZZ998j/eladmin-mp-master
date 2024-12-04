package com.bob.dcits.system.modules.system.mapper;

import com.bob.dcits.system.modules.system.domain.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Set;

/**
 * @author guoq
 * @date 2024-06-20
 */
@Mapper
public interface RoleDeptMapper {
    void insertData(@Param("roleId") Long roleId, @Param("depts") Set<Dept> depts);

    void deleteByRoleId(@Param("roleId") Long roleId);

    void deleteByRoleIds(@Param("roleIds") Set<Long> roleIds);
}
