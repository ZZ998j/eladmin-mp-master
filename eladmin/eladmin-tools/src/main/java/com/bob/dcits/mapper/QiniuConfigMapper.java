package com.bob.dcits.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bob.dcits.domain.EmailConfig;
import com.bob.dcits.domain.QiniuConfig;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author guoq
 * @description
 * @date 2024-06-14
 **/
@Mapper
public interface QiniuConfigMapper extends BaseMapper<QiniuConfig> {

}
