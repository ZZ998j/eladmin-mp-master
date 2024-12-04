package com.bob.dcits.system.modules.quartz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bob.dcits.system.modules.quartz.domain.QuartzJob;
import com.bob.dcits.system.modules.quartz.domain.vo.QuartzJobQueryCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author guoq
 * @description
 * @date 2024-06-12
 **/
@Mapper
public interface QuartzJobMapper extends BaseMapper<QuartzJob> {

    IPage<QuartzJob> findAll(@Param("criteria") QuartzJobQueryCriteria criteria, Page<Object> page);

    List<QuartzJob> findAll(@Param("criteria") QuartzJobQueryCriteria criteria);

    List<QuartzJob> findByIsPauseIsFalse();
}
