package com.bob.dcits.system.modules.mnt.domain.vo;

import lombok.Data;
import java.sql.Timestamp;
import java.util.List;

/**
* @author admin
* @date 2019-08-24
*/
@Data
public class DeployQueryCriteria{

    private String appName;

	private List<Timestamp> createTime;

    private Long offset;

    private Long size;
}
