package com.bob.dcits.system.modules.mnt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bob.dcits.system.modules.mnt.domain.App;
import com.bob.dcits.system.modules.mnt.domain.vo.AppQueryCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author guoq
 * @description
 * @date 2024-06-12
 **/
@Mapper
public interface AppMapper extends BaseMapper<App> {

    IPage<App> queryAll(@Param("criteria") AppQueryCriteria criteria, Page<Object> page);

    List<App> queryAll(@Param("criteria") AppQueryCriteria criteria);
}
