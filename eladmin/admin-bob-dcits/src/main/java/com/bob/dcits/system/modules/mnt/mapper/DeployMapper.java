package com.bob.dcits.system.modules.mnt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bob.dcits.system.modules.mnt.domain.Deploy;
import com.bob.dcits.system.modules.mnt.domain.vo.DeployQueryCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Set;

/**
 * @author guoq
 * @description
 * @date 2024-06-12
 **/
@Mapper
public interface DeployMapper extends BaseMapper<Deploy> {

    Long countAll(@Param("criteria") DeployQueryCriteria criteria);

    List<Deploy> findAll(@Param("criteria") DeployQueryCriteria criteria);
    
    Set<Long> getIdByAppIds(@Param("appIds") Set<Long> appIds);

    Deploy getDeployById(@Param("deployId") Long deployId);
}
