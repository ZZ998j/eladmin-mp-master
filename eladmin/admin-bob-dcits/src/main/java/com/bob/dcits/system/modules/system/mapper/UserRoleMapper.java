package com.bob.dcits.system.modules.system.mapper;

import com.bob.dcits.system.modules.system.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Set;

/**
 * @author guoq
 * @date 2024-06-20
 */
@Mapper
public interface UserRoleMapper {
    void insertData(@Param("userId") Long userId, @Param("roles") Set<Role> roles);

    void deleteByUserId(@Param("userId") Long userId);

    void deleteByUserIds(@Param("userIds") Set<Long> userIds);
}
