package com.bob.dcits.domain.vo;

import lombok.Data;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author guoq
 * @date 2024-6-4 09:54:37
 */
@Data
public class QiniuQueryCriteria{

    private String key;

    private List<Timestamp> createTime;
}
