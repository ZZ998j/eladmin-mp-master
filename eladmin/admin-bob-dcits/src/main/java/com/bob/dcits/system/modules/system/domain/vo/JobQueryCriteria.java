package com.bob.dcits.system.modules.system.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.util.List;

/**
* @author admin
* @date 2019-6-4 14:49:34
*/
@Data
@NoArgsConstructor
public class JobQueryCriteria {

    private String name;

    private Boolean enabled;

    private List<Timestamp> createTime;
}