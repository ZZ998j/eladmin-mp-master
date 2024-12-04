package com.bob.dcits.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bob.dcits.domain.LocalStorage;
import com.bob.dcits.domain.vo.LocalStorageQueryCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author guoq
 * @description
 * @date 2024-06-14
 **/
@Mapper
public interface LocalStorageMapper extends BaseMapper<LocalStorage> {

    IPage<LocalStorage> findAll(@Param("criteria") LocalStorageQueryCriteria criteria, Page<Object> page);

    List<LocalStorage> findAll(@Param("criteria") LocalStorageQueryCriteria criteria);
}
