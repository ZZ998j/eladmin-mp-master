package com.bob.dcits.system.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bob.dcits.system.modules.system.domain.Dept;
import com.bob.dcits.system.modules.system.domain.vo.DeptQueryCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Set;

/**
* @author admin
* @date 2023-06-20
*/
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

    List<Dept> findAll(@Param("criteria") DeptQueryCriteria criteria);

    List<Dept> findByPid(@Param("pid") Long pid);

    List<Dept> findByPidIsNull();

    Set<Dept> findByRoleId(@Param("roleId") Long roleId);

    @Select("select count(*) from sys_dept where pid = #{pid}")
    int countByPid(@Param("pid") Long pid);

    @Select("update sys_dept set sub_count = #{count} where dept_id = #{id}")
    void updateSubCntById(@Param("count") Integer count, @Param("id") Long id);
}