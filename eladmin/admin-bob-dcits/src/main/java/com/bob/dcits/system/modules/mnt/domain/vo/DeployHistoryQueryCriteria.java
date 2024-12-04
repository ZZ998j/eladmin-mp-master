package com.bob.dcits.system.modules.mnt.domain.vo;

import lombok.Data;
import java.sql.Timestamp;
import java.util.List;

/**
* @author admin
* @date 2019-08-24
*/
@Data
public class DeployHistoryQueryCriteria{

	private String blurry;

	private Long deployId;

	private List<Timestamp> deployDate;
}
