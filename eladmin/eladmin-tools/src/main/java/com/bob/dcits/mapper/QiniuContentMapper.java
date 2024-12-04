package com.bob.dcits.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bob.dcits.domain.QiniuContent;
import com.bob.dcits.domain.vo.QiniuQueryCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author guoq
 * @description
 * @date 2024-06-14
 **/
@Mapper
public interface QiniuContentMapper extends BaseMapper<QiniuContent> {

    QiniuContent findByKey(@Param("name") String name);

    IPage<QiniuContent> findAll(@Param("criteria") QiniuQueryCriteria criteria, Page<Object> page);

    List<QiniuContent> findAll(QiniuQueryCriteria criteria);
}
