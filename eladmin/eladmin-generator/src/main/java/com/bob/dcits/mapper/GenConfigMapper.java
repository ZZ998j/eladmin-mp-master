package com.bob.dcits.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bob.dcits.domain.GenConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author guoq
 * @date 2024-06-26
 */
@Mapper
public interface GenConfigMapper extends BaseMapper<GenConfig> {

    GenConfig findByTableName(@Param("tableName") String tableName);
}
