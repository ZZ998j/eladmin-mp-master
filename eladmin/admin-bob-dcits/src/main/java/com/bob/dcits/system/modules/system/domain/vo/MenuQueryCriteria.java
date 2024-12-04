package com.bob.dcits.system.modules.system.domain.vo;

import lombok.Data;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author guoq
 * 公共查询类
 */
@Data
public class MenuQueryCriteria {

    private String blurry;

    private List<Timestamp> createTime;

    private Boolean pidIsNull;

    private Long pid;
}
