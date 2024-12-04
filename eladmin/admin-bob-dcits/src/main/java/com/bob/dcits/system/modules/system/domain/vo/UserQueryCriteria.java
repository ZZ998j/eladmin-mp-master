package com.bob.dcits.system.modules.system.domain.vo;

import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author guoq
 * @date 2024-11-23
 */
@Data
public class UserQueryCriteria implements Serializable {

    private Long id;

    private Set<Long> deptIds = new HashSet<>();

    private String blurry;

    private Boolean enabled;

    private Long deptId;

    private List<Timestamp> createTime;

    private Long offset;

    private Long size;
}
