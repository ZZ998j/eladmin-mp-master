package com.bob.dcits.system.modules.mnt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bob.dcits.system.modules.mnt.domain.Server;
import com.bob.dcits.system.modules.mnt.domain.vo.ServerQueryCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author guoq
 * @description
 * @date 2024-06-12
 **/
@Mapper
public interface ServerMapper extends BaseMapper<Server> {
    Server findByIp(@Param("ip") String ip);

    IPage<Server> findAll(@Param("criteria") ServerQueryCriteria criteria, Page<Object> page);

    List<Server> findAll(@Param("criteria") ServerQueryCriteria criteria);
}
