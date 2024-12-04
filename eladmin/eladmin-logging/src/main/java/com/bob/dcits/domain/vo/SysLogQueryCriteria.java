package com.bob.dcits.domain.vo;

import lombok.Data;
import java.sql.Timestamp;
import java.util.List;

/**
 * 日志查询类
 * @author guoq
 * @date 2024-6-4 09:23:07
 */
@Data
public class SysLogQueryCriteria {

    private String blurry;

    private String username;

    private String logType;

    private List<Timestamp> createTime;
}
