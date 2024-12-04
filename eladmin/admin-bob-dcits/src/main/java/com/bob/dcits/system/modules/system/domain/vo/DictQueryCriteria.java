package com.bob.dcits.system.modules.system.domain.vo;

import lombok.Data;

/**
 * @author guoq
 * 公共查询类
 */
@Data
public class DictQueryCriteria {

    private String blurry;

    private Long offset;

    private Long size;
}
