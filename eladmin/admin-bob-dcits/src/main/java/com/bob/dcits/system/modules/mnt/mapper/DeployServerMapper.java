package com.bob.dcits.system.modules.mnt.mapper;

import com.bob.dcits.system.modules.mnt.domain.Server;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Set;

/**
 * @author guoq
 * @description
 * @date 2024-06-12
 **/
@Mapper
public interface DeployServerMapper {

    void insertData(@Param("deployId") Long deployId, @Param("servers") Set<Server> servers);

    void deleteByDeployId(@Param("deployId") Long deployId);

    void deleteByDeployIds(@Param("deployIds") Set<Long> deployIds);

    void deleteByServerIds(@Param("serverIds") Set<Long> serverIds);
}
